package jp.co.rakus.pizza_ya.product.food.pizza;

import java.util.ArrayList;
import java.util.List;

import jp.co.rakus.pizza_ya.product.food.Food;
import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;
import jp.co.rakus.pizza_ya.product.food.topping.Topping;

/**
 * ピザを表すクラス.
 * @author hiroki.mae
 *
 */
public abstract class Pizza implements Food {

	/** ピザ名*/
	private String name;
	/** 価格*/
	private int price;
	/** 特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	/** 使用した生地*/
	private Cloth cloth;
	/** 使用したソース*/
	private Sauce sauce;
	/** デフォルトのトッピング*/
	private List<Topping> defaultToppings;
	/** 追加のトッピング*/
	private List<Topping> addToppings;

	public Pizza(Cloth cloth, Sauce sauce) {
		this.cloth = cloth;
		this.sauce = sauce;
		setDefaultToppings(new ArrayList<>());
		setAddToppings(new ArrayList<>());
	}

	
	/**
	 * 追加で単品トッピングを乗せる.
	 * @param topping 追加トッピング
	 */
	public void addTopping(Topping topping) { this.addToppings.add(topping); }
	
	/**
	 * 追加で複数トッピングを乗せる.
	 * @param toppings 追加トッピングのリスト
	 */
	public void addToppings(List<Topping> toppings) {
		for (Topping topping : toppings) { this.addToppings.add(topping); }
	}
	
	/**
	 * トッピング込みのピザ単品価格(税別)を取得する.
	 * @return トッピング込みのピザ単品価格(税別)
	 */
	public int getSubTotalPrice() {
		int subTotalPrice = this.price;
		for (Topping topping : addToppings) {
			subTotalPrice += topping.getPrice();
		}
		return subTotalPrice;
	}
	
	/** デフォルトの単品価格を自身にセットする*/
	public void setPriceByClothAndDefaultToppings() {
		int clothPrice = this.cloth.getPrice();
		int toppingsPrice = 0 ;
		for (Topping topping : defaultToppings) {
			toppingsPrice += topping.getPrice();
		}
		setPrice( clothPrice + toppingsPrice);
	}
	
	@Override
	public void rot() {
		this.isRotten = true ;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Cloth getCloth() {
		return cloth;
	}

	


	

	public List<Topping> getDefaultToppings() {
		return defaultToppings;
	}


	public void setDefaultToppings(List<Topping> defaultToppings) {
		this.defaultToppings = defaultToppings;
	}


	public List<Topping> getAddToppings() {
		return addToppings;
	}


	public void setAddToppings(List<Topping> addToppings) {
		this.addToppings = addToppings;
	}


	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}


	public Sauce getSauce() {
		return sauce;
	}


	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	
	

	
	
}
