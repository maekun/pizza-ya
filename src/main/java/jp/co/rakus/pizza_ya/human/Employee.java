package jp.co.rakus.pizza_ya.human;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jp.co.rakus.pizza_ya.equipment.Handy;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * 従業員を表すクラス.
 * 
 * @author hiroki.mae
 */
public class Employee extends Human {

	Scanner scanner = new Scanner(System.in);

	/** 働いている店舗 */
	private Shop shop;
	/** 持っているハンディ */
	private Handy handy;
	/** 対応中のお客様 */
	private Guest guest;

	/** 出勤したらハンディを持つ*/
	public Employee(Shop shop, Handy handy) {
		super(randomName());
		this.handy = handy;
		this.shop = shop;
		this.handy.setEmployee(this);
	}
	
	/**
	 * 客をテーブルに案内する.
	 * @param guest 来店客
	 * @return 席に着いた客
	 */
	public Guest passTheTableToTheGuest(Guest guest) {
		Table table = shop.getTables().get(new Random().nextInt(16));
		System.out.println(this.getName() + "「いらっしゃいませ！　" + this.shop.getName() + "へようこそ！」");
		System.out.println(this.getName() + "「" + table.getTableNumber() + "番テーブルへご案内させていただきます。」");
		guest.setTable(table); // お客さんをテーブルにつかせる
		return guest;
	}

	/**
	 * 注文を受ける.
	 * @param guest　注文をする客
	 */
	public void receiveOrder(Guest guest) {

		int tableNumber = guest.getTable().getTableNumber();

		// メニューを客に見せて注文をwhile文で受け付ける
		System.out.println(this.getName() + "「ご注文をお伺いします。」");
		// ハンディを使用し、レジに注文送信
		Slip newSlip = handy.startOrder(tableNumber);

		System.out.println(this.getName() + "「ご注文承りました。」");
		// 伝票をテーブルに置く
		guest.getTable().addSlip(newSlip);
		System.out.println(this.getName() + "「お会計の際はこちらの伝票をレジまでお持ちください。」");
	}

	/**
	 * 客から伝票を受け取りお会計対応する.
	 * @param slip 伝票
	 * @return お釣り
	 */
	public int toAccount(Guest guest) {
		this.guest = guest;
		Slip slip = this.guest.getSlips().get(0);
		System.out.println("\n" + this.getName() + "「伝票お預かりいたします。」\n\n\n");
		shop.getCashier().displayOrder(slip);
		int totalPrice = shop.getCashier().showTotalPrice(slip);
		System.out.println(this.getName() + "「お客様のお支払金額は税込 " + totalPrice + " 円です。」");

		int receiptAmount = this.guest.payBillAmount(totalPrice);

		int charge = 0;
		if (receiptAmount == totalPrice) {
			System.out.println(this.getName() + "「" +  totalPrice + " 円、ちょうどお預かりいたします。」");
		} else {
			System.out.println(this.getName() + "「" + receiptAmount + " 円お預かりいたします。」");
			charge = shop.getCashier().toAccount(receiptAmount);
			System.out.println(this.getName() + "「" + charge + " 円のお返しです。」");
			this.guest.toGetMoney(charge); // お釣りを渡す
		}

		int isReceiptNecessary = 0; // レシートが必要かフラグ
		while (true) {
			System.out.println(this.getName() + "「レシートはご利用になりますか？」　　1. いる  0. いらない");
			try {
				isReceiptNecessary = scanner.nextInt(2);
				break;
			} catch (Exception e) {
				System.out.println("(正しい数字で入力をしてください)");
			}
		}

		switch (isReceiptNecessary) {
		case 1:
			shop.getCashier().printReceipt(guest.getTable().getTableNumber(),this);
			System.out.println(this.getName() + "「こちらレシートです。ありがとうございました。」");
			break;
		case 0:
			System.out.println(this.getName() + "「ありがとうございました。」");
			break;
		default:
			break;
		}
		shop.getCashier().accountingEnd(guest);
		return charge;
	}

	
	/**
	 * 店員名をランダムセレクト<br>
	 * 世の中、同じ名前の人はいるのであえて名前がかぶる設計.
	 * @return 選ばれた名前
	 */
	private static String randomName() {
		List<String> names = new ArrayList<>(
				Arrays.asList("猪狩","金子","神山","佐藤(男)","佐藤(女)","大地","中野","本間","松本","村井","八尋","吉野","吐愚痴","寺田さん","伊賀さん"));
		return names.get(new Random().nextInt(15));
	}
	
	/** getter /setter */
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Handy getHandy() {
		return handy;
	}

	public void setHandy(Handy handy) {
		this.handy = handy;
	}
	
	

}
