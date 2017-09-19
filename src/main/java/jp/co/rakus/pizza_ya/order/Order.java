package jp.co.rakus.pizza_ya.order;

import java.util.List;

import jp.co.rakus.pizza_ya.product.food.pizza.Pizza;

/**
 * 注文を表すクラス.
 * @author hiroki.mae
 *
 */
public class Order {

	/** 注文を受けたテーブルの番号*/
	private int tableNumber;
	/** 注文されていたピザ*/
	private List<Pizza> orderedPizzaList;
	
	/**
	 * コンストラクタ.
	 * @param tableNumber　テーブル番号
	 * @param orderedPizzaList　注文内容
	 */
	public Order(int tableNumber, List<Pizza> orderedPizzaList) {
		this.tableNumber = tableNumber;
		this.orderedPizzaList = orderedPizzaList;
	}
	
	
	/** getter/setter */
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}


	public List<Pizza> getOrderedPizzaList() {
		return orderedPizzaList;
	}


	public void setOrderedPizzaList(List<Pizza> orderedPizzaList) {
		this.orderedPizzaList = orderedPizzaList;
	}
	
	
	
}
