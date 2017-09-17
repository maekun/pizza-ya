package jp.co.rakus.pizza_ya;

import jp.co.rakus.pizza_ya.product.menu.PizzaMenu;
import jp.co.rakus.pizza_ya.product.menu.ToppingMenu;

/**
 * pizza-yaシステム起動.
 * @author hiroki.mae
 *
 */
public class App {
	public static void main(String[] args) {
		
		PizzaMenu.open();
		ToppingMenu.open();
		
		
		
	}
}
