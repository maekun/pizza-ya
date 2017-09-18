package jp.co.rakus.pizza_ya.equipment;

import java.util.ArrayList;
import java.util.List;

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

	/** 登録されている店舗*/
	private Shop shop;
	/** 接続しているレジ*/
	private Cashier cashier;
	
	/** 一回分の注文内容*/
	private List<Food> nowOrderList;
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
		
		this.nowOrderList = new ArrayList<>();
		
		Cloth cloth = shop.getCloth();
		Sauce sauce = shop.getSauce();
		
	
		
		nowOrderList.add(new CheesePizza(cloth, sauce));
		nowOrderList.add(new CheesePizza(cloth, sauce));
		nowOrderList.add(new CheesePizza(cloth, sauce));
		
		
		//ピザ選び終わったらオーダオブジェクトにする
		this.order = new Order(tableNumber, this.nowOrderList);
		
		
		cashier.addOrder(this.order);
		this.nowOrderList = new ArrayList<>(); //送信後にクリア
		return new Slip(this.order);
	}
	
}
