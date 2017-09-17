package jp.co.rakus.pizza_ya.product.food.pizza;

/**
 * ピザーヤの生地を表す抽象クラス.
 * @author hiroki.mae
 *
 */
public abstract class PizzayaCloth extends Cloth {

	/** 生地名*/
	private String name;
	/** 価格*/
	private final int PRICE = 1000;
	/** 生地の特徴*/
	private String description;
	/** 腐っているか判定するフラグ*/
	private boolean isRotten;
	
	
	public PizzayaCloth() {
	}
	

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
