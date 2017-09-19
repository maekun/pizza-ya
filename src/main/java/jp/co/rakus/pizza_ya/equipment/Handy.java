package jp.co.rakus.pizza_ya.equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import jp.co.rakus.pizza_ya.human.Employee;
import jp.co.rakus.pizza_ya.order.Order;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.food.pizza.CheesePizza;
import jp.co.rakus.pizza_ya.product.food.pizza.Cloth;
import jp.co.rakus.pizza_ya.product.food.pizza.PepperoniiPizza;
import jp.co.rakus.pizza_ya.product.food.pizza.Pizza;
import jp.co.rakus.pizza_ya.product.food.pizza.SeafoodPizza;
import jp.co.rakus.pizza_ya.product.food.pizza.VegetablePizza;
import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Cheese;
import jp.co.rakus.pizza_ya.product.food.topping.Pepperoni;
import jp.co.rakus.pizza_ya.product.food.topping.Shrimp;
import jp.co.rakus.pizza_ya.product.food.topping.Tomato;
import jp.co.rakus.pizza_ya.product.food.topping.Topping;
import jp.co.rakus.pizza_ya.product.menu.PizzaMenu;
import jp.co.rakus.pizza_ya.product.menu.ToppingMenu;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * ハンディ(店員が注文を受け付ける時に使うアレ)を表すクラス.
 * @author hiroki.mae
 *
 */
@Service
public class Handy {
	
	Scanner scanner = new Scanner(System.in);

	/** 登録されている店舗*/
	private Shop shop;
	/** 接続しているレジ*/
	private Cashier cashier;
	/** このハンディを現在持っている従業員*/
	private Employee employee;
	/** 一回分の注文内容*/
	private List<Pizza> nowOrderPizzaList;
	private Order order;
	
	public Handy(Shop shop) {
		this.shop = shop;
		this.cashier = shop.getCashier();
	}
	
	/**
	 * 注文を受け付ける.
	 * @param tableNumber 注文が入るテーブル番号
	 * @return 伝票
	 */
	public Slip startOrder(int tableNumber) {
		
		this.nowOrderPizzaList = new ArrayList<>();

		while (true) {
			Pizza pizza = selectPizza();
			System.out.println(this.employee.getName() + "「" + pizza.getName() + " ですね。」");
			System.out.println(this.employee.getName() + "「追加のトッピングはいかがですか？」　　1. いる  0. いらない");
			String selectNumber = "";
			while (true) {
				selectNumber = scanner.nextLine();
				if("1".equals(selectNumber) || "１".equals(selectNumber)) { 
					pizza.addToppings(selectToppings()); break; }
				if("0".equals(selectNumber) || "０".equals(selectNumber)) { break; }
				System.out.println("正しく入力してください");
			}
			
			
			nowOrderPizzaList.add(pizza);
			
			selectNumber = "";
			System.out.println(this.employee.getName() + "「ご注文を続けるなら１を、終了するなら０を入力してください。」");
			while (true) {
				selectNumber = scanner.nextLine();
				if("1".equals(selectNumber) || "１".equals(selectNumber)) { break;}
				if("0".equals(selectNumber) || "０".equals(selectNumber)) { break; }
				System.out.println("正しく入力してください");
			}
			if("1".equals(selectNumber) || "１".equals(selectNumber)) { continue;}
			if("0".equals(selectNumber) || "０".equals(selectNumber)) { break; }
			
			
		}
		//ピザ選び終わったらオーダオブジェクトにする
		this.order = new Order(tableNumber, this.nowOrderPizzaList);
		
		//レジに注文内容を飛ばす
		cashier.addOrder(this.order);
		this.nowOrderPizzaList = new ArrayList<>(); //送信後にクリア
		return new Slip(this.order);
	}
	
	/**
	 * ピザを選ぶ.
	 * @return 選ばれたピザ
	 */
	private Pizza selectPizza() {
		Cloth cloth = shop.getCloth();
		Sauce sauce = shop.getSauce();
		
		System.out.println(this.employee.getName() + "「ご希望のピザをご注文ナンバーでお選びください」");
		System.out.println(this.employee.getName() + "「当店の生地は " + cloth.getDescription() + "でソースは " + sauce.getDescription() + "ですよ」");
		PizzaMenu.open();
		while (true) {
			String selectNumber = scanner.nextLine();
			if(String.valueOf(PizzaMenu.CHEESE_PIZZA.getId()).equals(selectNumber) || "１".equals(selectNumber)) {
				return new CheesePizza(cloth, sauce);
			}
			if(String.valueOf(PizzaMenu.PEPPERONI_PIZZA.getId()).equals(selectNumber) || "２".equals(selectNumber)) {
				return new PepperoniiPizza(cloth, sauce);
			}
			if(String.valueOf(PizzaMenu.SEAFOOD_PIZZA.getId()).equals(selectNumber) || "３".equals(selectNumber)) {
				return new SeafoodPizza(cloth, sauce);
			}
			if(String.valueOf(PizzaMenu.VEGETABLES_PIZZA.getId()).equals(selectNumber) || "４".equals(selectNumber)) {
				return new VegetablePizza(cloth, sauce);
			}
//			キャンセルの選択肢未実装
//			if("0".equals(selectNumber) || "０".equals(selectNumber)) {
//				return null;
//			}
			System.out.println(this.employee.getName() + "「正しく入力してください」");
		}
	}
	/**
	 * 追加トッピングを選ぶ.
	 * @return 選んだトッピング
	 */
	private List<Topping> selectToppings() {
		System.out.println(this.employee.getName() + "「ご希望のトッピングをご注文ナンバーでお選びください」    0 でトッピングを終了する");
		ToppingMenu.open();
		List<Topping> addToppings = new ArrayList<>();
		while (true) {
			String selectNumber = scanner.nextLine();
			if(String.valueOf(ToppingMenu.CHEESE.getId()).equals(selectNumber) || "１".equals(selectNumber)) {
				addToppings.add(new Cheese());
				System.out.println(this.employee.getName() + "「チーズトッピングが１点」");
			}
			else if(String.valueOf(ToppingMenu.PEPPERONI.getId()).equals(selectNumber) || "２".equals(selectNumber)) {
				addToppings.add(new Pepperoni());
				System.out.println(this.employee.getName() + "「ペパロニトッピングが１点」");
			}
			else if(String.valueOf(ToppingMenu.SHRIMP.getId()).equals(selectNumber) || "３".equals(selectNumber)) {
				addToppings.add(new Shrimp());
				System.out.println(this.employee.getName() + "「エビトッピングが１点」");
			}
			else if(String.valueOf(ToppingMenu.TOMATO.getId()).equals(selectNumber) || "４".equals(selectNumber)) {
				addToppings.add(new Tomato());
				System.out.println(this.employee.getName() + "「トマトトッピングが１点」");
			}
			else if("0".equals(selectNumber) || "０".equals(selectNumber)) {
				break;
			}
			else {System.out.println(this.employee.getName() + "「正しく入力してください」");}
		}
		return addToppings;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
