package jp.co.rakus.pizza_ya.product.food.pizza;

import java.util.ArrayList;
import java.util.Arrays;

import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Cheese;
import jp.co.rakus.pizza_ya.product.food.topping.Onion;
import jp.co.rakus.pizza_ya.product.food.topping.Pepperoni;

/**
 * チーズピザを表すクラス
 * @author hiroki.mae
 *
 */
public class CheesePizza extends Pizza {

	public CheesePizza(Cloth cloth, Sauce sauce) {
		super(cloth,sauce);
		this.setName("チーズピザ");
		this.setDefaultToppings(new ArrayList<>(
				Arrays.asList(new Cheese(),new Cheese(),new Pepperoni(),new Onion())));
		setPriceByClothAndDefaultToppings(); 
	}
}
