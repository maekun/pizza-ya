package jp.co.rakus.pizza_ya.human;

import java.util.List;
import java.util.Scanner;

import jp.co.rakus.pizza_ya.equipment.Table;
import jp.co.rakus.pizza_ya.order.Slip;
import jp.co.rakus.pizza_ya.product.menu.PizzaMenu;
import jp.co.rakus.pizza_ya.product.menu.ToppingMenu;
import jp.co.rakus.pizza_ya.shop.Shop;

/**
 * 客を表すクラス.
 * @author hiroki.mae
 *
 */
public class Guest extends Human {
	
	Scanner scanner = new Scanner(System.in);
	
	/** 入ったお店*/
	private Shop shop;
	/** 所持金*/
	private int possessionMoney;
	/** 席に着いたテーブル*/
	private Table table;
	/** 注文内容の記載された伝票*/
	private List<Slip> slips;
	
	public Guest() {
		this.possessionMoney = 50000;
	}
	
	public Guest(Human human) {
		this.possessionMoney = 50000;
	}
	
	
	
	/** 全てのメニューを見る*/
	public void viewMenu() {
		PizzaMenu.open();
		ToppingMenu.open();
	}
	
	/** 店員を呼んで注文する.*/
	public void order() {
		Employee selectedEmployee = shop.employeeIsChosen();
		selectedEmployee.receiveOrder(this);
	}
	/** 伝票を見る.*/
	public void viewSlip() {
		List<Slip> slips = table.getSlip();
		int  subTotalPrice = 0 ;
		if(0 == slips.size()) {
			System.out.println("まだ注文していません。\n");
		}else {
			for (Slip slip : slips) { subTotalPrice += slip.showOrdered(); }
		}
		System.out.println("++++++++++++++++++++\n全伝票の総小計額 : " + subTotalPrice + " 円\n++++++++++++++++++++\n");
	}
	
	/** 自身の所持金を確認する*/
	public void showPossessionMoney() {
		//所持金を確認する振る舞いを実行する
		System.out.println("現在の所持金 : " + this.possessionMoney + " 円");
	}
	
	/** 会計へ進む.*/
	public void proceedToAccounting() {
		this.slips = this.table.getSlip(); //テーブルから伝票を取る
		System.out.println("(テーブルから伝票を取り、レジへ向かう)");
		for (int i = 0; i < 3; i++) {
            try{
                Thread.sleep(1000); 
                System.out.print("スタ・・　");
            }
            catch(InterruptedException e){
	            	System.out.print("スタ・・　");
            }
        }
		Employee selectedEmployee = shop.employeeIsChosen();
		selectedEmployee.toAccount(slips);
	}
	
	
	/** getter/setter */
	public int getPossessionMoney() {
		return possessionMoney;
	}
	public void setPossessionMoney(int possessionMoney) {
		this.possessionMoney = possessionMoney;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}


	public List<Slip> getSlips() {
		return slips;
	}

	public void setSlips(List<Slip> slips) {
		this.slips = slips;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	
}
