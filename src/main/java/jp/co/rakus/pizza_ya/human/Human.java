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
		int selectedShopNumber = scanner.nextInt();
		
		if(selectedShopNumber == 1) {
			return new PizzayaNewYork();
		}else if(selectedShopNumber == 2) {
			return new PizzayaChicago();}
		return null;
	}
	
	/** getter/setter */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
