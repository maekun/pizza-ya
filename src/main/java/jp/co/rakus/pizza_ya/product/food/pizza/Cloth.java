package jp.co.rakus.pizza_ya.product.food.pizza;

import jp.co.rakus.pizza_ya.product.food.Food;

/**
 * 生地を表すクラス.
 * @author hiroki.mae
 *
 */
public abstract class Cloth implements Food {

	/** 生地名*/
	private String name;
	/** 価格*/
	private int price;
	/** 生地の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	
	public Cloth() {
		this.isRotten = false;
	}

	@Override
	public void rot() { this.isRotten = true ; }

	/** getter/setter*/
	@Override
	public String getName() {return this.name;}

	@Override
	public void setName(String name) {this.name = name;}

	@Override
	public int getPrice() {return this.price;}

	@Override
	public void setPrice(int price) {this.price = price;}

	@Override
	public String getDescription() {	return this.description;}

	@Override
	public void setDescription(String description) {this.description = description;}
	
	@Override
	public boolean isRotten() {return this.isRotten;}
}
