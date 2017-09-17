package jp.co.rakus.pizza_ya.order;

import java.util.List;

import jp.co.rakus.pizza_ya.product.food.Food;

/**
 * 注文内容を表すクラス.
 * @author hiroki.mae
 *
 */
public class Order {

	/** 注文を受けたテーブルの番号*/
	private int tableNumber;
	/** 注文されていたピザ*/
	private List<Food> orderedPizzaList;
	
	public Order(int tableNumber, List<Food> orderedPizzaList) {
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
	public List<Food> getOrderedPizzaList() {
		return orderedPizzaList;
	}
	public void setOrderedPizzaList(List<Food> orderedPizzaList) {
		this.orderedPizzaList = orderedPizzaList;
	}
	
	
}
