package jp.co.rakus.pizza_ya.human;

import java.util.List;
import java.util.Random;
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
	
	/** お店に入ったら客になるコンストラクタ*/
	public Guest(Human human) {
		super(human.getName());
		this.possessionMoney = new Random().nextInt(10000) + 40000;
	}
	
	/** 全てのメニューを見る*/
	public void viewMenu() { PizzaMenu.open(); ToppingMenu.open();}
	
	/** 店員を呼んで注文する.*/
	public void order() {
		Employee selectedEmployee = shop.employeeIsChosen();
		selectedEmployee.receiveOrder(this);
	}
	
	/** テーブルの伝票を確認する.*/
	public void viewSlip() {
		int  subTotalPrice = 0 ;
		if(0 == slips.size()) System.out.println("(まだ何も注文していません。)\n\n");
		else for (Slip slip : table.getSlip()) { subTotalPrice += slip.showOrdered();}
		System.out.println("++++++++++++++++++++\n全伝票の総小計額 : " + subTotalPrice + " 円\n++++++++++++++++++++\n");
	}
	
	/** 自身の所持金を確認する*/
	public void showPossessionMoney() {
		System.out.println("現在の所持金 : " + this.possessionMoney + " 円");}
	
	/** 会計へ進む.(未注文なら戻る)*/
	public void proceedToAccounting() throws Exception{
		this.slips = this.table.getSlip(); //テーブルから伝票を取る
		if( 0 == slips.size() ) {
			System.out.println("(まだ何も注文していません。)\n\n");
			throw new Exception();
		}else {
			System.out.println("(テーブルから伝票を取り、レジへ向かう)");
			for (int i = 0; i < 3; i++) {
				try{
					Thread.sleep(1000); 
					System.out.print("スタ・・　");}
				catch(InterruptedException e){
					System.out.print("スタ・・　");}
			}
			Employee selectedEmployee = shop.employeeIsChosen();
			selectedEmployee.toAccount(this);
		}
	}
	
	/**
	 * 請求された額を支払う.
	 * @param billingAmount 請求額
	 * @return 請求に対して渡すお金
	 */
	public int payBillAmount(int billingAmount) {
		
		if(this.possessionMoney < billingAmount) {
			System.out.println("(持ち合わせがない。。。)");
			kuinige(); //食い逃げする
		}
		int payAmount = 0;
		System.out.println("(いくら渡しますか？)");
		while (true) {
			payAmount = scanner.nextInt();
			
			if(this.possessionMoney < payAmount) {
				System.out.println("(そこまでの所持金はありません)");
				continue;
			}
			
			if(payAmount < billingAmount) {
				System.out.println("合計金額に届いていません。");
				continue;
			}
			break;
		}
		this.possessionMoney -= payAmount; //所持金が減る
		return payAmount;
	}
	
	/**
	 * お金を獲得し、所持金を増やす.
	 * @param money お金
	 */
	public void toGetMoney(int money) { this.possessionMoney += money; }
	
	/**
	 * 食い逃げする.
	 */
	public void kuinige(){
		System.out.println(this.getName() + "は店から逃げた。。。");
		System.exit(1); //処理を完全終了する
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
