package jp.co.rakus.pizza_ya.product.menu;

public enum PizzaMenu {
	
	CHEESE_PIZZA(0,"チーズピザ","¥1,800"),
	PEPPERONI_PIZZA(1,"ペパロニピザ","¥1,400"),
	SEAFOOD_PIZZA(2,"シーフードピザ","¥1,600"),
	VEGETABLES_PIZZA(3,"野菜ピザ","¥1,600");
	
	
	/** 上記に挙げた定数をここから下で定義しているイメージ*/
	
	
	/** ピザid*/
	private final int id;
	/** 商品名*/
	private final String name;
	/** 価格*/
	private final String price;
	
	
	private PizzaMenu(int id, String name, String price) { 
		this.id = id ; 
		this.name = name;
		this.price = price ;
		}
	
	/** ピザメニューを開く.*/
	public static void open() {
		System.out.println("========================================");
		System.out.println("【ピザメニュー】\n");
		for (PizzaMenu pizza : PizzaMenu.values()) {
			System.out.println("ご注文No." + pizza.getId() + ":【 " + pizza.getName() + " 】");
		}
		System.out.println("========================================");

	}
	
	public int getId() { return this.id; }
	public String getName(){ return this.name; }
	public String getPrice(){ return this.price; }
}
