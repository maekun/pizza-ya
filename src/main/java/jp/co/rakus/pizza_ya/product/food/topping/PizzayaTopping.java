package jp.co.rakus.pizza_ya.product.food.topping;

/**
 * ピザーヤのトッピングを表すクラス.
 * @author hiroki.mae
 *
 */
public abstract class PizzayaTopping extends Topping {
	
	/** トッピング名*/
	private String name;
	/** 価格*/
	private final int PRICE = 200;
	/** 商品の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;

	public PizzayaTopping() {}

	@Override
	public void rot() { this.isRotten = true ; }

	/** getter/setter*/
	@Override
	public String getName() {return this.name;}

	@Override
	public void setName(String name) {this.name = name;}

	@Override
	public int getPrice() {return this.PRICE;}

	@Override
	public String getDescription() {	return this.description;}

	@Override
	public void setDescription(String description) {this.description = description;}
	
	@Override
	public boolean isRotten() {return this.isRotten;}

}
