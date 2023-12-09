package Beveragefiles;
import java.util.Scanner;
import java.util.ArrayList;
public class BevShopDriverApp {
	public static BevShop bev = new BevShop();
public static void main(String []args) {
	String newOrder;
	double totalOrdersAmount=0;
	int numOfOrders = 0;
	int time= 5;
	Day day = Day.SATURDAY;
	Scanner input = new Scanner(System.in);
	Scanner input2 = new Scanner(System.in);
	System.out.println("the minimum age to order alcohol is " + bev.getMinAgeForAlcohol());
	System.out.println("please Start a new order: ");
	System.out.println("your Total Order for now is" + 0.0);
	System.out.println("please enter your name ");
	String name = input.nextLine();
	System.out.println("please enter you age");
	int age = input.nextInt();
	do {
	bev.startNewOrder(time, day, name, age);
	 bev.startNewOrder(time, day, name, age);
	    numOfOrders++;
	    if (bev.isValidAge(age)) {
	        System.out.println("would you like to add an alcoholic beverage?. y/n");
	        String alcoholAnswer = input2.nextLine();
	        while ("y".equals(alcoholAnswer) && bev.isEligibleForMore()) {
	            System.out.println("what is the name of the drink? ");
	            String bevName = input2.nextLine();
	            System.out.println("what size drink would you like? ");
	            Size size = Size.valueOf(input2.nextLine().toUpperCase());
	            bev.processAlcoholOrder(bevName, size);
	            System.out.println("would you like to add another alcoholic drink? y/n");
	            alcoholAnswer = input2.nextLine();
	        }
	    } else {
	        System.out.println("You are not old enough to order alcoholic beverages");
	    }
	    System.out.println("would you like to add a smoothie?. y/n");
	    input.nextLine();
	    String answer = input.nextLine();
	    while ("y".equals(answer)) {
	        System.out.println("what is the name of the drink? ");
	        String bevName = input.nextLine();
	        System.out.println("what size drink would you like? ");
	        Size size = Size.valueOf(input.nextLine().toUpperCase());
	        System.out.println("how many fruits would you like to add? ");
	        int fruitNum = input.nextInt();
	        input.nextLine(); 
	        System.out.println("would you like to add protein? y/n ");
	        String add = input.nextLine();
	        boolean protein = "y".equals(add);
	        bev.processSmoothieOrder(bevName, size, fruitNum, protein);
	        System.out.println("would you like to add another drink?");
	        answer = input.nextLine();
	    }
	    System.out.println("would you like to add a coffee?. y/n");
	    input2.nextLine();
	    answer = input.nextLine();
	    while ("y".equals(answer)) {
	        System.out.println("what is the name of the drink? ");
	        String bevName = input.nextLine();
	        System.out.println("what size drink would you like? ");
	        Size size = Size.valueOf(input.nextLine().toUpperCase());
	        System.out.println("would you like to add an extra shot? y/n ");
	        String addShot = input.nextLine();
	        boolean extraShot = "y".equals(addShot);
	        System.out.println("would you like to add extra syrup? y/n ");
	        String addSyrup = input.nextLine();
	        boolean extraSyrup = "y".equals(addSyrup);
	        bev.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
	        System.out.println("would you like to add another drink?");
	        answer = input.nextLine();
	    }

	 System.out.println("your " + numOfOrders + "'th order is " + bev.order.toString());
	    System.out.println("the total cost of your order is " + bev.order.calcOrderTotal());
	    totalOrdersAmount += bev.order.calcOrderTotal();
	    System.out.println("would you like to start a new order? y/n ");
	    newOrder = input2.nextLine();
	} while ("y".equals(newOrder));

	System.out.println("the total amount for all your orders is: " + totalOrdersAmount);
}
}
