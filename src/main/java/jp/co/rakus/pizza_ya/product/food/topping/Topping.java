package jp.co.rakus.pizza_ya.product.food.topping;

import jp.co.rakus.pizza_ya.product.food.Food;

public abstract class Topping implements Food {

	/** トッピング名*/
	private String name;
	/** 価格*/
	private int price;
	/** 商品の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	
	public Topping() {
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
