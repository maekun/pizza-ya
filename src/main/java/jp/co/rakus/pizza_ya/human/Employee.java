package jp.co.rakus.pizza_ya.human;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jp.co.rakus.pizza_ya.equipment.Handy;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * 従業員を表すクラス.
 * @author hiroki.mae
 *
 */
public class Employee extends Human {
	
	Scanner scanner = new Scanner(System.in);
	
	private Handy handy;
	private Shop shop;
	

	public Employee(Shop shop, Handy handy) {
		this.handy = handy;
		this.shop = shop;
	}
	
	
	/**
	 * 客をテーブルに案内する.
	 * @param guest 来店客
	 * @return　席に着いた客
	 */
	public Guest passTheTableToTheGuest(Guest guest) {
		Table table = shop.getTables().get(new Random().nextInt(16));
		System.out.println("いらっしゃいませ！　" + this.shop.getName() + "へようこそ！");
		System.out.println(table.getTableNumber() + "番テーブルへご案内させていただきます。");
		guest.setTable(table); //お客さんをテーブルにつかせる
		return guest;
	}
	
	/**
	 * 注文を受ける.
	 * @param guest 注文をする客
	 */
	public void receiveOrder(Guest guest) {
		
		int tableNumber = guest.getTable().getTableNumber();
		
		//メニューを客に見せて注文をwhile文で受け付ける
		System.out.println("ご注文をお伺いします。");
		//ハンディを使用し、レジに注文送信
		Slip newSlip = handy.startOrder(tableNumber);
	
		System.out.println("ご注文承りました。");
		//伝票をテーブルに置く
		guest.getTable().addSlip(newSlip);
		System.out.println("お会計の際はこちらの伝票をレジまでお持ちください。");
	}
	
	/**
	 * 客から伝票を受け取りお会計対応する.
	 * @param slip 伝票
	 * @return お釣り
	 */
	public int toAccount(List<Slip> slips) {
		
		Slip slip = slips.get(0);
		System.out.println("伝票お預かりいたします。");
		int totalPrice = shop.getCashier().showTotalPrice(slip);
		System.out.println("お客様のお支払金額は税込 "+ totalPrice + " 円です。");
		
		int receiptAmount = 0;
		System.out.println("(いくら渡しますか？)");
		while (true) {
			receiptAmount = scanner.nextInt();
			if(receiptAmount < totalPrice) {
				System.out.println("合計金額に届いていません。");
				continue;
			}
			break;
		}
		
		int charge = 0;
		if(receiptAmount == totalPrice) { 
			System.out.println(totalPrice + " 円、ちょうどお預かりいたします。"); 
		}else { 
			System.out.println(receiptAmount + " 円お預かりいたします。"); 
			charge = shop.getCashier().toAccount(receiptAmount);
			System.out.println(charge + " 円のお返しです。");
		}
		
		int isReceiptNecessary = 0; //レシートが必要かフラグ
		while(true) {
			System.out.println("レシートはご利用になりますか？　　0. いる  1. いらない");
			try {
				isReceiptNecessary = scanner.nextInt(2);
				break;
			} catch (Exception e) {
				System.out.println("(正しい数字で入力をしてください)");
			}
			
			}
			
		switch (isReceiptNecessary) {
		case 0:
			System.out.println("こちらレシートです。ありがとうございました。//レシート内容未実装");
			break;
		case 1:
			System.out.println("ありがとうございました。");
			break;
		default:
			break;
		}
		return charge;
	}
	
	
	
	
}
