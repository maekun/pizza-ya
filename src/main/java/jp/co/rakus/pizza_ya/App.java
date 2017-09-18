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
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("「あなたの名前を入力してください」\n");
		String playerName = scanner.nextLine();
		Human player = new Human(playerName);
		Shop selectedShop = player.selectTheShop();
		Guest guestMae = selectedShop.toGreetCustomers(player); //お店は客が入ってきたら持っている席を一つ客に割り振る
		
		//レジ行くまで繰り返す
		boolean isContinue = true;
		while (isContinue) {
			switch (selectAction()) {
			case 1: //メニュー見る
				guestMae.viewMenu(); break;
			case 2: //注文する
				guestMae.order(); break;
			case 3: //伝票を確認する
				guestMae.viewSlip(); break;
			case 4: //所持金を確認する
				guestMae.showPossessionMoney(); break;
			case 0: //レジへ向かう
				try {
					guestMae.proceedToAccounting();
					isContinue = false;
					break;
				} catch (Exception e) {
					continue;
				}
			default:
				break;
			}
		}
	}
	
	/**
	 * 行動を選択する. 
	 * @return 行動の番号
	 */
	private static int selectAction() {
		System.out.println("(どうしますか？)");
		System.out.println("1.メニューをみる");
		System.out.println("2.店員を呼んで注文する");
		System.out.println("3.伝票を確認する");
		System.out.println("4.所持金を確認する");
		System.out.println("0.レジへ向かう");
		
		int selectActionNumber = 0;
		while (true) {
			try {
				String strActionNumber = scanner.nextLine();
				if("1".equals(strActionNumber) ||"１".equals(strActionNumber)) {
					selectActionNumber = 1; break;
				}
				if("2".equals(strActionNumber) ||"２".equals(strActionNumber)) {
					selectActionNumber = 2; break;
				}
				if("3".equals(strActionNumber) ||"３".equals(strActionNumber)) {
					selectActionNumber = 3; break;
				}
				if("4".equals(strActionNumber) ||"４".equals(strActionNumber)) {
					selectActionNumber = 4; break;
				}
				if("0".equals(strActionNumber) ||"０".equals(strActionNumber)) {
					selectActionNumber = 0; break;
				}
				throw new Exception();
			} catch (Exception e) {
				System.out.println("正しい数字を選択してください。");
				continue;
			}
		}
		return selectActionNumber;
	}
}
