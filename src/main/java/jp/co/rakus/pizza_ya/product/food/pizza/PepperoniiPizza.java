package jp.co.rakus.pizza_ya.product.food.pizza;

import java.util.ArrayList;
import java.util.Arrays;

import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Cheese;
import jp.co.rakus.pizza_ya.product.food.topping.Pepperoni;

/**
 * ペパロにピザを表すクラス.
 * @author hiroki.mae
 *
 */
public class PepperoniiPizza extends Pizza {

	public PepperoniiPizza(PizzayaCloth cloth, Sauce sauce) {
		super(cloth,sauce);
		this.setName("ペパロニピザ");
		this.addToppings(new ArrayList<>(
				Arrays.asList(new Cheese(),new Pepperoni())));
		setPriceByClothAndDefaultToppings(); 
	}
}
