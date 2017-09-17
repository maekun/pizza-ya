package jp.co.rakus.pizza_ya.shop;

import java.util.ArrayList;
import java.util.List;

import jp.co.rakus.pizza_ya.equipment.Cashier;
import jp.co.rakus.pizza_ya.equipment.Handy;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.human.Employee;
import jp.co.rakus.pizza_ya.human.Guest;
import jp.co.rakus.pizza_ya.human.Human;
import jp.co.rakus.pizza_ya.product.food.pizza.ThickCloth;
import jp.co.rakus.pizza_ya.product.food.sauce.MariaraSauce;

/**
 * ピザーヤのシカゴ店を表すクラス.
 * @author hiroki.mae
 *
 */
public class PizzayaChicago extends Shop {

	private static Cashier cashier;
	
	public PizzayaChicago() {
		cashier = new Cashier();
		
		List<Table>tables = new ArrayList<>();
		for (int i = 0; i < 16; i++) { tables.add(new Table()); }
		this.setTables(tables);
		
		List<Handy> handyList = new ArrayList<>();
		for (int i = 0; i < 16; i++) { handyList.add(new Handy(this)); }
		
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 16; i++) { employees.add(new Employee(this)); }
		this.setEmployees(employees);
		
		this.setCloth(new ThickCloth());
		this.setSauce(new MariaraSauce());
	}
	
	@Override
	public Guest passTheTableToTheGuest(Human human) {
		System.out.println("いらっしゃいませ！　ピザーヤ、シカゴ店へようこそ！");
		return super.passTheTableToTheGuest(human);
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	
}
