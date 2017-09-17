package jp.co.rakus.pizza_ya.equipment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.pizza_ya.order.Order;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.food.Food;
import jp.co.rakus.pizza_ya.product.food.pizza.CheesePizza;
import jp.co.rakus.pizza_ya.product.food.pizza.Cloth;
import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * ハンディ(店員が注文を受け付ける時に使うアレ)を表すクラス.
 * @author hiroki.mae
 *
 */
@Service
public class Handy {

	private Cashier cashier;
	
	private Shop shop;
	
	/** 一回分の注文内容*/
	private List<Food> orders = new ArrayList<>();
	private Order order;
	
	public Handy(Shop shop) {
		this.shop = shop;
	}
	
	/**
	 * 注文を受け付ける.
	 * @param tableNumber 注文が入るテーブル番号
	 */
	public void startOrder(int tableNumber) {
		
		this.orders = new ArrayList<>();
		
		Cloth cloth = shop.getCloth();
		Sauce sauce = shop.getSauce();
		
	
		
		orders.add(new CheesePizza(cloth, sauce));
		orders.add(new CheesePizza(cloth, sauce));
		orders.add(new CheesePizza(cloth, sauce));
		
		
		//ピザ選び終わったらオーダオブジェクトにする
		this.order = new Order(tableNumber, this.orders);
		
		
	}
	
	/**
	 * 注文内容をレジに送信する.
	 * @param order 注文内容
	 * @return 伝票
	 */
	public Slip sendOrder(int tableNumber) {
		cashier.addOrder(this.order);
		this.orders = new ArrayList<>(); //送信後にクリア
		return new Slip(this.order);
	}
}
