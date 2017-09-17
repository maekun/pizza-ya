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
	/** セットのトッピング*/
	private List<Topping> toppings;

	public Pizza(Cloth cloth, Sauce sauce) {
		this.cloth = cloth;
		this.sauce = sauce;
		setToppings(new ArrayList<>());
	}

	
	/**
	 * 追加で単品トッピングを乗せる.
	 * @param topping 追加トッピング
	 */
	public void addTopping(Topping topping) { this.toppings.add(topping); }
	
	/**
	 * 追加で複数トッピングを乗せる.
	 * @param toppings 追加トッピングのリスト
	 */
	public void addToppings(List<Topping> toppings) {
		for (Topping topping : toppings) { this.toppings.add(topping); }
	}
	
	/**
	 * トッピング込みのピザ単品価格(税別)を取得する.
	 * @return トッピング込みのピザ単品価格(税別)
	 */
	public int getSubTotalPrice() {
		this.price += this.cloth.getPrice();
		for (Topping topping : toppings) {
			this.price += topping.getPrice();
		}
		return this.price;
	}
	
	@Override
	public void rot() {
		this.isRotten = true ;
	}
	
	
	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
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

	

	public List<Topping> getToppings() {
		return toppings;
	}


	public Sauce getSauce() {
		return sauce;
	}


	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	
	

	
	
}
