package jp.co.rakus.pizza_ya.product.food.pizza;

/**
 * ピザーヤの厚い生地を表すクラス.
 * @author hiroki.mae
 *
 */
public class ThickCloth extends PizzayaCloth {

	/** 生地名*/
	private String name;
	/** 価格*/
	private final int PRICE = 1000;
	/** 生地の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	
	
	public ThickCloth() {
		this.name = "ピザーヤ特製 厚め生地";
		this.description = "もちもちボリューミー！";
	}


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


	public boolean isRotten() {
		return isRotten;
	}


	public void setRotten(boolean isRotten) {
		this.isRotten = isRotten;
	}


	public int getPRICE() {
		return PRICE;
	}

	
}
