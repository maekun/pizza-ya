package jp.co.rakus.pizza_ya.human;

import java.util.Scanner;

import jp.co.rakus.pizza_ya.shop.PizzayaChicago;
import jp.co.rakus.pizza_ya.shop.PizzayaNewYork;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * 人間を表す抽象クラス.
 * @author hiroki.mae
 *
 */
public class Human {
	Scanner scanner = new Scanner(System.in);
	
	/** 名前*/
	private String name ;
	
	/**
	 * 名前を受け取るコンストラクタ.
	 * @param name 
	 */
	public Human(String name) {
		setName(name);
	}
	
	/**
	 * 入る店舗を選択する.
	 * @return 入る店舗
	 */
	public Shop selectTheShop() {
		System.out.println("入る店舗ナンバーを入力してください");
		System.out.println("ピザーヤ");
		System.out.println("1.ニューヨーク店 / 2.シカゴ店");
		int selectedShopNumber = 0;
		while (true) {
			try {
				String strShopNumber = scanner.nextLine();
				if("1".equals(strShopNumber) ||"１".equals(strShopNumber)) {
					selectedShopNumber = 1; break;}
				if("2".equals(strShopNumber) ||"２".equals(strShopNumber)) {
					selectedShopNumber = 2; break;}
				throw new Exception();
			} catch (Exception e) {
				System.out.println("正しい数字を選択してください。");
				continue;
			}
		}
		if( 1 == selectedShopNumber) return new PizzayaNewYork();
		if( 2 == selectedShopNumber) return new PizzayaChicago();
		else return null;
	}
	
	/** getter/setter */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
