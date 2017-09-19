package jp.co.rakus.pizza_ya.shop;

import java.util.ArrayList;
import java.util.List;

import jp.co.rakus.pizza_ya.equipment.Cashier;
import jp.co.rakus.pizza_ya.equipment.Handy;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.human.Employee;
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

		this.setCloth(new ThickCloth());
		this.setSauce(new MariaraSauce());
		
		this.setName("ピザーヤ、シカゴ店");
		cashier = new Cashier();
		
		List<Table>tables = new ArrayList<>();
		for (int i = 0; i < 16; i++) { tables.add(new Table()); }
		this.setTables(tables);
		
		List<Handy> handyList = new ArrayList<>();
		for (int i = 0; i < 16; i++) { handyList.add(new Handy(this)); }
		this.setHandyList(handyList);
		
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 16; i++) { employees.add(new Employee(this, this.getHandyList().get(i))); }
		this.setEmployees(employees);
		
	}

	public Cashier getCashier() {
		return cashier;
	}

	
}
