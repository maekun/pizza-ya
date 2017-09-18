package jp.co.rakus.pizza_ya.equipment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jp.co.rakus.pizza_ya.human.Employee;
import jp.co.rakus.pizza_ya.order.Order;

/**
 * レシートを表すクラス.
 * @author hiroki.mae
 *
 */
public class Receipt {

	/** 店舗名*/
	private String shopName;
	/** 清算日時*/
	private LocalDateTime dateOfPayment;
	/** 担当者*/
	private String employeeName;
	/** 注文内容*/
	private List<Order> orders;
	/** 小計*/
	private int subTotalPrice;
	/** 合計*/
	private int totalPrice;
	
	/**
	 * レシートを作成する.
	 * @param orders 注文リスト
	 */
	public Receipt(Employee employee, List<Order> orders,int subTotalPrice, int totalPrice) {
		this.shopName = employee.getShop().getName();
		dateOfPayment = LocalDateTime.now();
		this.employeeName = employee.getName();
		this.orders = orders;
		this.subTotalPrice = subTotalPrice;
		this.totalPrice = totalPrice;
	}
	
	/**
	 * レシートの内容を確認する.
	 */
	public void show() {
		System.out.println("-----------------------------------------------");
		System.out.println("********* 【 "+ this.shopName + " 】 *********");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y年M月d日 HH:mm:ss");
		System.out.println("来店日時 : " + formatter.format(dateOfPayment));
		System.out.println("担当店員 : " + employeeName);
		System.out.println("注文内容 : ");
		
		
		System.out.println("====================");
		System.out.println("小計金額 : " + this.subTotalPrice + " 円");
		System.out.println("合計金額 : " + this.totalPrice + " 円");
		System.out.println("====================\n");
		System.out.println("**********またのご来店、おまちしております**********");
		System.out.println("-----------------------------------------------");
	}

	
	/** getter/setter*/
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(int subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDateTime dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
	
}
