package jp.co.rakus.pizza_ya.product;

/**
 * 製品を表すインターフェース.
 * @author hiroki.mae
 *
 */
public interface Product {
	String getName();
	void setName(String name);
	int getPrice();
	void setPrice(int price);
	String getDescription();
	void setDescription(String description);
}
