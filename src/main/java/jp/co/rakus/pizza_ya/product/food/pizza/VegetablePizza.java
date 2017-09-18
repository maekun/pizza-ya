package jp.co.rakus.pizza_ya.product.food.pizza;

import java.util.ArrayList;
import java.util.Arrays;

import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Cheese;
import jp.co.rakus.pizza_ya.product.food.topping.Onion;
import jp.co.rakus.pizza_ya.product.food.topping.Tomato;

/**
 * 野菜ピザを表すクラス.
 * @author hiroki.mae
 *
 */
public class VegetablePizza extends Pizza {

	public VegetablePizza(Cloth cloth, Sauce sauce) {
		super(cloth,sauce);
		this.setName("野菜ピザ");
		this.setDefaultToppings(new ArrayList<>(
				Arrays.asList(new Cheese(),new Tomato(),new Onion())));
		setPriceByClothAndDefaultToppings(); 
	}

}
