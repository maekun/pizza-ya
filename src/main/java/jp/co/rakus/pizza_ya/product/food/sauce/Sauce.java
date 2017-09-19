package jp.co.rakus.pizza_ya.product.food.sauce;

/**
 * ピザソースを表す抽象クラス.
 * @author hiroki.mae
 *
 */
public abstract class Sauce {

	/** ソース名*/
	private String name;
	/** 特徴*/
	private String description;
	
	/** getter/setter */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
