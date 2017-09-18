package jp.co.rakus.pizza_ya.order;

import java.util.List;

import jp.co.rakus.pizza_ya.product.food.Food;

/**
 * 伝票を表すクラス.
 * @author hiroki.mae
 *
 */
public class Slip {

	/** 注文を受けたテーブルの番号*/
	private int tableNumber;
	//TODO:ピザのリスト自体はオーダーオブジェクトの中にあるから伝票からは消すか？それとも注文内容を客が伝票から確認できるようにするために残すか？
	/** 注文されていたピザ*/
	private List<Food> orderedPizzaList;
	
	public Slip(Order order) {
		this.tableNumber = order.getTableNumber();
		this.orderedPizzaList = order.getOrderedPizzaList();
	}
	
	/**
	 * 伝票内容を表示する.
	 * @return 伝票一枚あたりの小計
	 */
	public int showOrdered() {
		int SubTotalPrice = 0;
		for (Food food : orderedPizzaList) {
			System.out.println(food.getName());
			int subPrice = food.getSubTotalPrice();
			SubTotalPrice += subPrice;
			System.out.println("単品価格:" + subPrice + " 円");
		}
		System.out.println("====================");
		System.out.println("小計:" + SubTotalPrice + " 円\n");
		return SubTotalPrice;
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
