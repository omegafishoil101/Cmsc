package Beveragefiles;

import java.util.Random;
import java.util.ArrayList;

public class Order extends Object implements OrderInterface, Comparable<Order> {

	private int orderTime, orderNo;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverage = new ArrayList<Beverage>();
	
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		super();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}


	public int generateOrder() {
		Random random = new Random();
		orderNo = random.nextInt((90000 - 10000)+1) + 10000;
		return orderNo;
	}


	public int getOrderTime() {
		return orderTime;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public Day getOrderDay() {
		return orderDay;
	}
	public Day getDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return cust;
	}
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY ) {
			return true;
		}else {
			return false;
		}
	}
	public Beverage getBeverage(int itemNo) {
		return beverage.get(itemNo);
	}
	public int getTotalItems() {
			return beverage.size();
	}
	
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverage.add(coffee);
	}
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size,  numOfFruits, addProtein);
		beverage.add(smoothie);
	}
	public void addNewBeverage(String bevName, Size size) {
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		beverage.add(alcohol);
	}
	public double calcOrderTotal() {
		double totalPrice = 0;
		for(int i = 0; i < beverage.size() ; i++) {
		totalPrice += beverage.get(i).calcPrice();
		}
		return totalPrice;
	}
	public int findNumOfBeveType(Type type) {
		int typeNum = 0;
		for(int i = 0; i < beverage.size() ; i++) {
			if(beverage.get(i).getType() == type) {
				typeNum++;
			}
			
		}
		return typeNum;
	}
	
	@Override
	public String toString(){
		return orderNo + ", " + orderTime + ", " + orderDay + ", " + cust + ", " + beverage;
	}
	
	public int compareTo(Order anotherOrder) {
		if(this.orderNo > anotherOrder.getOrderNo()) {
			return 1;
		} else if(this.orderNo < anotherOrder.getOrderNo()) {
			return -1;
	} else {
		return 0;
	}
	}

}

