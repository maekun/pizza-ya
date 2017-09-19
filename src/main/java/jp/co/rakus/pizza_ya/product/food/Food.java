package jp.co.rakus.pizza_ya.product.food;

import jp.co.rakus.pizza_ya.product.FoodStuff;
import jp.co.rakus.pizza_ya.product.Product;

/**
 * 食品を表すインターフェース.
 * @author hiroki.mae
 *
 */
public interface Food extends FoodStuff, Product {
	/** 単品の税別価格を取得する.*/
	public int getSubTotalPrice();
}
