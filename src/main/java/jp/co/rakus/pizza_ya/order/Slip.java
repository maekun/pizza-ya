package jp.co.rakus.pizza_ya.order;

import java.util.List;

import jp.co.rakus.pizza_ya.product.food.pizza.Pizza;
import jp.co.rakus.pizza_ya.product.food.topping.Topping;

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
	private List<Pizza> orderedPizzaList;
	
	public Slip(Order order) {
		this.tableNumber = order.getTableNumber();
		this.orderedPizzaList = order.getOrderedPizzaList();
	}
	
	/**
	 * 伝票内容を表示する.
	 * @return 伝票一枚あたりの小計
	 */
	public int showOrdered() {
		int subTotalPrice = 0;
		System.out.println("========================================\n                 [伝票]\n========================================");
		for (Pizza pizza : orderedPizzaList) {
			System.out.println(pizza.getName() + "   " + pizza.getPrice() + " 円");
			
			//トッピング一つごと
			for (Topping topping : pizza.getAddToppings()) {
				System.out.println("[" + topping.getName() + " 追加トッピング単品 :価格 " + topping.getPrice() + " 円 ]");
			}
			subTotalPrice += pizza.getSubTotalPrice();
			System.out.println(
					"- - - - - - - - - - - - - - - - - - - - \n                        単品小計 : " + pizza.getSubTotalPrice() + " 円\n----------------------------------------");
		}
		System.out.println("========================================\n                [伝票]\n========================================");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println("                           小計:" + subTotalPrice + " 円");
		System.out.println("++++++++++++++++++++++++++++++++++++++++\n\n");
		return subTotalPrice;
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
