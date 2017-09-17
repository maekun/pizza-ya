package jp.co.rakus.pizza_ya.equipment;

import jp.co.rakus.pizza_ya.human.Guest;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.menu.PizzaMenu;
import jp.co.rakus.pizza_ya.product.menu.ToppingMenu;

/**
 * テーブルを表すクラス.
 * @author hiroki.mae
 *
 */
public class Table {
	
	/** 生成されたテーブルの数*/
	private static int createdCount;

	/** 席ナンバー*/
	private int tableNumber;
	/** 席につける最大人数*/
	static final int MAX_HUMAN = 4 ;
	/** 席に着いた客*/
	private Guest[] guests;
	/** 備え付けのピザメニュー*/
	private PizzaMenu pizzaMenu;
	/** 備え付けのトッピングメニュー*/
	private ToppingMenu toppingMenu;
	/** 伝票*/
	private Slip slip;
	
	
	public Table() {
		createdCount++;
		this.guests = new Guest[MAX_HUMAN]; //４人席
		this.tableNumber = createdCount;
	}
	public Table(int tableNumber) {
		this.guests = new Guest[MAX_HUMAN]; //４人席
		this.tableNumber = tableNumber;
	}
	
	/** getter/setter*/
	public Guest[] getGuests() {
		return guests;
	}

	public void setGuests(Guest[] guests) {
		this.guests = guests;
	}

	public static int getMaxHuman() {
		return MAX_HUMAN;
	}

	public PizzaMenu getPizzaMenu() {
		return pizzaMenu;
	}

	public void setPizzaMenu(PizzaMenu pizzaMenu) {
		this.pizzaMenu = pizzaMenu;
	}

	public ToppingMenu getToppingMenu() {
		return toppingMenu;
	}

	public void setToppingMenu(ToppingMenu toppingMenu) {
		this.toppingMenu = toppingMenu;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public Slip getSlip() {
		return slip;
	}
	public void setSlip(Slip slip) {
		this.slip = slip;
	}
	
	
}
