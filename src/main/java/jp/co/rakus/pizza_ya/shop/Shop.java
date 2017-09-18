package jp.co.rakus.pizza_ya.shop;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.rakus.pizza_ya.equipment.Cashier;
import jp.co.rakus.pizza_ya.equipment.Handy;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.human.Employee;
import jp.co.rakus.pizza_ya.human.Guest;
import jp.co.rakus.pizza_ya.human.Human;
import jp.co.rakus.pizza_ya.product.food.pizza.Cloth;
import jp.co.rakus.pizza_ya.product.food.sauce.Sauce;

/**
 * 店舗を表すインターフェース.
 * @author hiroki.mae
 *
 */
public abstract class Shop {
	
	/** 店舗名*/
	private String name;
	/** 従業員*/
	private List<Employee> employees;
	/** ハンディ*/
	private List<Handy> handyList;
	/** レジ*/
	@Autowired
	private Cashier cashier;
	/** 店内のテーブル席*/
	private static List<Table> tables;
	/** その店の使用しているピザ生地*/
	private Cloth cloth;
	/** その店の使用しているピザソース*/
	private Sauce sauce;
	
	
	
	
	/**
	 * お客様を迎え入れる
	 * @param human 来店客
	 * @return 客にしてリターン
	 */
	public Guest toGreetCustomers(Human human) {
		Guest guest = new Guest(human);
		Employee selectedEmployee = this.employeeIsChosen();
		selectedEmployee.passTheTableToTheGuest(guest);
		guest.setShop(this);
		return guest;
	}


	/**
	 * ランダムで接客する店員が選ばれる.
	 * @return 接客を担当する店員
	 */
	public Employee employeeIsChosen() {
		return this.employees.get(new Random().nextInt(employees.size()));
	}

	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public List<Table> getTables() {
		return tables;
	}



	public void setTables(List<Table> tables) {
		Shop.tables = tables;
	}



	public Cloth getCloth() {
		return cloth;
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



	public Cashier getCashier() {
		return cashier;
	}



	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}


	public List<Handy> getHandyList() {
		return handyList;
	}


	public void setHandyList(List<Handy> handyList) {
		this.handyList = handyList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
