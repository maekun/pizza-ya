package jp.co.rakus.pizza_ya.equipment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jp.co.rakus.pizza_ya.order.Order;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.food.Food;

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
	private Map<Integer, List<Food>> orders;

	public Cashier() {
		this.setBalance(500000);
		orders = new HashMap<Integer, List<Food>>();
	}

	/**
	 * ハンディからの注文内容を蓄積する.
	 * 
	 * @param order
	 *            新規注文
	 */
	public void addOrder(Order order) {
		this.orders.put(order.getTableNumber(), order.getOrderedPizzaList());
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
		List<Food> orderedFoods = this.orders.get(tableNumber);
		return calcTotalPriceInJapan(calcSubTotalPrice(orderedFoods));
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
	 * @param orderedFoods
	 *            注文商品リスト
	 * @return 小計
	 */
	private int calcSubTotalPrice(List<Food> orderedFoods) {
		this.subTotalPrice = 0;
		for (Food food : orderedFoods) {
			subTotalPrice += food.getSubTotalPrice();
		}
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
