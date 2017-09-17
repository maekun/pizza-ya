package jp.co.rakus.pizza_ya.shop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.rakus.pizza_ya.equipment.Cashier;
import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.human.Employee;
import jp.co.rakus.pizza_ya.human.Guest;
import jp.co.rakus.pizza_ya.human.Human;
import jp.co.rakus.pizza_ya.product.food.pizza.ThinCloth;
import jp.co.rakus.pizza_ya.product.food.sauce.TomatoSauce;

/**
 * ピザーヤのニューヨーク店を表すクラス.
 * @author hiroki.mae
 *
 */
@Component
public class PizzayaNewYork extends Shop{
	
	private static Cashier cashier;
	
	public PizzayaNewYork() {
		cashier = new Cashier();
		List<Table>tables = new ArrayList<>();
		for (int i = 0; i < 16; i++) { tables.add(new Table()); }
		this.setTables(tables);
		
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 16; i++) { employees.add(new Employee(this)); }
		this.setEmployees(employees);
		
		this.setCloth(new ThinCloth());
		this.setSauce(new TomatoSauce());
	}
	
	@Override
	public Guest passTheTableToTheGuest(Human human) {
		System.out.println("いらっしゃいませ！　ピザーヤ、ニューヨーク店へようこそ！");
		return super.passTheTableToTheGuest(human);
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	
}
