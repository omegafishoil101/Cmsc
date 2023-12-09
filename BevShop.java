package Beveragefiles;
import java.util.ArrayList;

public class BevShop extends Object implements BevShopInterface {
	private int alcoholNo =0;
	private ArrayList<Order>orders = new ArrayList<Order>();
	Order order;
	//private final static int MIN_AGE = 21;

	
	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMaxNumOfFruits(){
		return MIN_AGE_FOR_ALCOHOL;
	}
	public int getMinAgeForAlcohol(){
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT)? true:false;
	}
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public boolean isEligibleForMore() {
		return (alcoholNo < MAX_ORDER_FOR_ALCOHOL)? true:false;
	}
	
	public int getNumOfAlcoholDrink() {
		return alcoholNo;
	}
	public boolean isValidAge(int age) {
		return (age >= MIN_AGE_FOR_ALCOHOL)? true:false;
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer cust = new Customer(customerName, customerAge);
		order = new Order(time, day, cust);
		orders.add(order);
	}
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		order.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	public void processAlcoholOrder(String bevName, Size size) {
		order.addNewBeverage(bevName, size);
		alcoholNo++;
	}
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		order.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if( orders.get(i).getOrderNo() == orderNo) {
				return i;
				
			}
		}
		return -1;
	}
 public double totalOrderPrice(int orderNo) {
	for(int i = 0; i < orders.size(); i++) {
		if( orders.get(i).getOrderNo() == orderNo) {
			return orders.get(i).calcOrderTotal() ;
			
		}
	}
	return -1;
}
 public double totalMonthlySale() {
	 double totalSale = 0;
	 for(int i = 0; i < orders.size(); i++) {
		 totalSale += orders.get(i).calcOrderTotal();
	 }
	 return totalSale;
 }
	 public int totalNumOfMonthlyOrders() {
		return orders.size();
		
	 
 }
	 public Order getCurrentOrder() {
		 for(int i = 0; i < orders.size(); i++) {
				if( orders.get(i).getOrderNo() == order.getOrderNo()) {
					return orders.get(i);
					
				}
			}
		 return null;
	 }
	 public Order getOrderAtIndex(int index) {
		 return orders.get(index);
	 }
	 public void sortOrders() {
		 for(int i = 0; i < orders.size(); i++) {
			 int min = i;
			 for(int j = i +2; j < orders.size(); j++) {
				 if(orders.get(j).getOrderNo() < orders.get(min).getOrderNo()) {
					 min = j;
				 }
			 }
			 Order temp = orders.get(min);
			 orders.set(min, orders.get(i));
			 orders.set(i, temp);
		 
		 }
	 }

}