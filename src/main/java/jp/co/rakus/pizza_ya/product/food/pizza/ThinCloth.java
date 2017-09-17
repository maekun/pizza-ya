package jp.co.rakus.pizza_ya.product.food.pizza;

/**
 * ピザーヤの薄い生地を表すクラス.
 * @author hiroki.mae
 *
 */
public class ThinCloth extends PizzayaCloth {

	/** 生地名*/
	private String name;
	/** 価格*/
	private final int PRICE = 1000;
	/** 生地の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	
	
	public ThinCloth() {
		this.name = "ピザーヤ特製 薄め生地";
		this.description = "サクサクパリパリ！";
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


	@Override
	public int getSubTotalPrice() {
		return PRICE;
	}

	
}
