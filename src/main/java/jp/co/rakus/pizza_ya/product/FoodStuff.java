package jp.co.rakus.pizza_ya.product;

/**
 * 食材を表すインターフェース.
 * @author hiroki.mae
 *
 */
public interface FoodStuff {

	/**
	 * 腐る.
	 */
	void rot() ;
	
	String getName();
	/**
	 * 腐っているか確認する.
	 * @return 腐っていればtrue/腐っていなければfalse
	 */
	boolean isRotten();
}
