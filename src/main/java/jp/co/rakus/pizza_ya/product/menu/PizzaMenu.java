package jp.co.rakus.pizza_ya.product.menu;

/**
 * ピザのメニューを表すEnumクラス.
 * @author hiroki.mae
 *
 */
public enum PizzaMenu {
	
	CHEESE_PIZZA(1,"チーズピザ","¥1,800","チーズ * 2、ペパロニ、オニオン"),
	PEPPERONI_PIZZA(2,"ペパロニピザ","¥1,400","チーズ、ペパロニ"),
	SEAFOOD_PIZZA(3,"シーフードピザ","¥1,600","チーズ、エビ、イカ"),
	VEGETABLES_PIZZA(4,"野菜ピザ","¥1,600","チーズ、トマト、オニオン");
	
	
	/** 上記に挙げた定数をここから下で定義しているイメージ*/
	
	
	/** ピザid*/
	private final int id;
	/** 商品名*/
	private final String name;
	/** 価格*/
	private final String price;
	/** デフォルトトッピング内容*/
	private final String toppingsDescription;
	
	
	private PizzaMenu(int id, String name, String price, String toppingsDescription) { 
		this.id = id ; 
		this.name = name;
		this.price = price ;
		this.toppingsDescription = toppingsDescription;
		}
	
	/** ピザメニューを開く.*/
	public static void open() {
		System.out.println("========================================");
		System.out.println("【ピザメニュー】\n");
		for (PizzaMenu pizza : PizzaMenu.values()) {
			System.out.println("ご注文No." + pizza.getId() + ":【 " + pizza.getName() + " 】--- " + pizza.getPrice());
//			System.out.println("--------------------------------------");
			System.out.println("[トッピング内容] " + pizza.getToppingsDescription() + "\n");
		}
		System.out.println("========================================");

	}
	
	public int getId() { return this.id; }
	public String getName(){ return this.name; }
	public String getPrice(){ return this.price; }
	public String getToppingsDescription() {return this.toppingsDescription;}
}
