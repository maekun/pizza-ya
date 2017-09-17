package jp.co.rakus.pizza_ya.product.food.topping;

/**
 * トッピングメニュー.
 * @author hiroki.mae
 *
 */
public enum ToppingMenu {

	CHEESE(0,"チーズ",200,"トロトロのチーズ"),
	PEPPERONI(1,"ペパロニ",200,"スパイスの効いたサラミソーセージ"),
	SHRIMP(2,"エビ",200,"身がギュッと締まったエビ"),
	TOMATO(3,"トマト",200,"赤い宝石のような新鮮トマト");
	
	
	/** 上記に挙げた定数をここから下で定義しているイメージ*/
	
	
	/** トッピングid*/
	private final int id;
	/** トッピング名*/
	private final String name;
	/** 価格*/
	private final int price;
	/** 特徴の説明*/
	private final String description;
	
	
	private ToppingMenu(int id, String name, int price, String description) { 
		this.id = id ; 
		this.name = name;
		this.price = price ;
		this.description = description;
		}
	
	/** トッピングメニューを開く.*/
	public static void open() {
		System.out.println("====================");
		System.out.println("追加トッピングメニュー");
		System.out.println("====================");
		for (ToppingMenu topping : ToppingMenu.values()) {
			System.out.println("ご注文No." + topping.getId() + ":【 " + topping.getName() + " 】"+ ": " + topping.getDescription());
		}
	}
	
	public int getId() { return this.id; }
	public String getName(){ return this.name; }
	public int getPrice(){ return this.price; }
	public String getDescription() { return this.description; }
}