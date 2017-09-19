package jp.co.rakus.pizza_ya.equipment;

import java.util.ArrayList;
import java.util.List;

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
	private int createdCount;

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
	private List<Slip> slips;
	
	
	public Table() {
		slips = new ArrayList<>();
		createdCount++;
		this.guests = new Guest[MAX_HUMAN]; //４人席
		this.tableNumber = createdCount;
	}
	public Table(int tableNumber) {
		this.guests = new Guest[MAX_HUMAN]; //４人席
		this.tableNumber = tableNumber;
	}
	
	/**
	 * 追加伝票を受け付ける.
	 * @param slip 追加伝票
	 */
	public void addSlip(Slip slip) { this.slips.add(slip); }
	
	
	
	
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
	public List<Slip> getSlip() {
		return slips;
	}
	public void setSlip(List<Slip> slips) {
		this.slips = slips;
	}
	
	
	
}
