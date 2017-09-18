package jp.co.rakus.pizza_ya.product.food.pizza;

import java.util.ArrayList;
import java.util.Arrays;

import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Cheese;
import jp.co.rakus.pizza_ya.product.food.topping.Shrimp;
import jp.co.rakus.pizza_ya.product.food.topping.Squid;

/**
 * シーフードピザを表すクラス.
 * @author hiroki.mae
 *
 */
public class SeafoodPizza extends Pizza {

	public SeafoodPizza(Cloth cloth, Sauce sauce) {
		super(cloth, sauce);
		this.setName("シーフードピザ");
		this.setDefaultToppings(new ArrayList<>(
				Arrays.asList(new Cheese(),new Shrimp(),new Squid())));
		setPriceByClothAndDefaultToppings(); 
	}
}
