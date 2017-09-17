package jp.co.rakus.pizza_ya.human;

import java.util.Scanner;

import jp.co.rakus.pizza_ya.equipment.Handy;
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
	

	public Employee(Shop shop) {
		this.handy = new Handy();
		this.shop = shop;
	}
	
	/**
	 * 注文を受ける.
	 * @param guest 注文をする客
	 */
	public void receiveOrder(Guest guest) {
		
		int tableNumber = guest.getTable().getTableNumber();
		
		//メニューを客に見せて注文をwhile文で受け付ける
		System.out.println("ご注文をお伺いします。");
		handy.startOrder(tableNumber);
	
		//ハンディを使用し、レジに注文送信
		Slip slip = handy.sendOrder(tableNumber);
		System.out.println("ご注文承りました。");
		//伝票をテーブルに置く
		guest.getTable().setSlip(slip);
		System.out.println("お会計の際はこちらの伝票をレジまでお持ちください。");
	}
	
	/**
	 * 客から伝票を受け取りお会計対応する.
	 * @param slip 伝票
	 * @return お釣り
	 */
	public int toAccount(Slip slip) {
		
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
			System.out.println(charge + "円のお返しです。");
		}
		return charge;
	}
	
}
