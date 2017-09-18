package jp.co.rakus.pizza_ya.equipment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jp.co.rakus.pizza_ya.order.Order;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.food.Food;
import jp.co.rakus.pizza_ya.product.food.pizza.Pizza;
import jp.co.rakus.pizza_ya.product.food.topping.Topping;

/**
 * レジを表すサービスクラス.
 * 
 * @author hiroki.mae
 *
 */
@Service
public class Cashier {

	/** 2017/09/17現在の日本の消費税率(8%) */
	private final double JAPAN_SALES_TAX = 1.08;
	// /** 2017/09/17現在のシカゴの消費税率(10.25%)*/
	// private final double CHICAGO_SALES_TAX = 1.1025;
	// /** 2017/09/17現在のニューヨークの消費税率(8.875%)*/
	// private final double NY_SALES_TAX = 1.08875;

	/** レジ内の残高 */
	private int balance;
	/** 小計(一回の会計が終わるごとにクリアされる) */
	private int subTotalPrice;
	/** 合計(一回の会計が終わるごとにクリアされる) */
	private int totalPrice;

	/** ハンディから受信した注文内容リスト */
	private Map<Integer, List<Order>> orders;

	public Cashier() {
		this.setBalance(500000);
		orders = new HashMap<Integer, List<Order>>();
	}

	/**
	 * ハンディからの注文内容を蓄積する.
	 * 
	 * @param order
	 *            注文
	 */
	public void addOrder(Order order) {
		int tableNumber = order.getTableNumber();
		
		//すでに会計前の注文がある場合
		if(this.orders.containsKey(tableNumber)) {
			orders.get(tableNumber).add(order);
		//初注文だった場合
		}else {
			this.orders.put(tableNumber, new ArrayList<>(Arrays.asList(order)));
		}
	}

	/**
	 * 伝票を読み込み、注文内容を画面に出力する.
	 * @param slip 伝票
	 */
	public void displayOrder(Slip slip) {
		List<Order> orders = this.orders.get(slip.getTableNumber());
		for (Order order : orders) {
			
			for ( Pizza pizza : order.getOrderedPizzaList()) {
				System.out.println( pizza.getName() + " 単品 : " + pizza.getPrice() + " 円");
				
				for ( Topping topping : pizza.getAddToppings()) {
					System.out.println(topping.getName() + " 単品 : " + topping.getPrice() + " 円");
				}
				System.out.println("--------------------\n単品小計 : " + pizza.getSubTotalPrice() + " 円\n--------------------");
			}
		}
	}
	
	/**
	 * 伝票を読み込み、合計金額を表示する.
	 * 
	 * @param slip
	 *            伝票
	 * @return 合計金額
	 */
	public int showTotalPrice(Slip slip) {
		int tableNumber = slip.getTableNumber();
		List<Order> orders = this.orders.get(tableNumber);
		return calcTotalPriceInJapan(calcSubTotalPrice(orders));
	}

	/**
	 * 精算する.
	 * 
	 * @param receiptAmount
	 *            お預かり金額
	 * @return お釣り
	 */
	public int toAccount(int receiptAmount) {
		int change = receiptAmount - this.totalPrice;
		accountingEnd();
		return change;
	}

	/**
	 * 小計を算出する.
	 * 
	 * @param orders
	 *            注文リスト
	 * @return 小計
	 */
	private int calcSubTotalPrice(List<Order> orders) {
		this.subTotalPrice = 0;
		for (Order order : orders) {
			for (Food food : order.getOrderedPizzaList()) {
				subTotalPrice += food.getSubTotalPrice();
			}
		}
		System.out.println("====================");
		System.out.println("小計:" + subTotalPrice + " 円\n");
		return subTotalPrice;
	}

	/**
	 * 税込金額を算出する(日本).
	 * 
	 * @param subTotalPrice
	 *            小計
	 * @return 合計金額
	 */
	private int calcTotalPriceInJapan(int subTotalPrice) {
		this.totalPrice = (int) (subTotalPrice * JAPAN_SALES_TAX);
		return this.totalPrice;
	}

	/** 売上計上する. */
	private void accountingEnd() {
		setBalance(getBalance() + this.totalPrice);
		this.subTotalPrice = 0;
		this.totalPrice = 0;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// ピザの値段が日本円なので断念しました。。。

	// private double calcTotalPriceInChicago(double subTotalPrice) {
	// //ここで小数点２位まで求めてリターンする
	// return (int) (subTotalPrice * CHICAGO_SALES_TAX);
	// }
	// private double calcTotalPriceInNY(double subTotalPrice) {
	// //ここで小数点２位まで求めてリターンする
	// return (int) (subTotalPrice * NY_SALES_TAX);
	// }

}
