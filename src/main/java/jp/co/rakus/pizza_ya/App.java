package jp.co.rakus.pizza_ya;


import java.util.Scanner;

import jp.co.rakus.pizza_ya.human.Guest;
import jp.co.rakus.pizza_ya.human.Human;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * pizza-yaシステム起動.
 * @author hiroki.mae
 *
 */
public class App {
	
	
	public static void main(String[] args) {
		
		
		Human mae = new Human();
		Shop selectedShop = mae.selectTheShop();
		Guest guestMae = selectedShop.toGreetCustomers(mae); //お店は客が入ってきたら持っている席を一つ客に割り振る

		
		//レジ行くまで繰り返す
		boolean isContinue = true;
		while (isContinue) {
			switch (selectAction()) {
			case 1: //メニュー見る
				guestMae.viewMenu();
				break;
				
			case 2: //注文する
				guestMae.order();
				break;
				
			case 3: //伝票を確認する
				guestMae.viewSlip();
				break;
				
			case 4: //所持金を確認する
				guestMae.showPossessionMoney();
				break;
				
			case 0: //レジへ向かう
				guestMae.proceedToAccounting();
				isContinue = false;
				break;
				
			default:
				break;
			}
			
		}
	}
	
	/**
	 * 行動を選択する. 
	 * @return 行動の番号
	 */
	@SuppressWarnings("resource")
	private static int selectAction() {
		System.out.println("(どうしますか？)");
		System.out.println("1.メニューをみる");
		System.out.println("2.注文する");
		System.out.println("3.伝票を確認する");
		System.out.println("4.所持金を確認する");
		System.out.println("0.レジへ向かう");
		
		int selectActionNumber = 0;
		while (true) {
			try {
				selectActionNumber = new Scanner(System.in).nextInt(5);
				break;
			} catch (Exception e) {
				System.out.println("正しい数字を選択してください。");
				continue;
			}
		}
		return selectActionNumber;
	}
}
