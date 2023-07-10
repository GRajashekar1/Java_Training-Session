package assignment;

import java.util.HashMap;

public class Order {
	
	private static final long serialVersionUID = 1L;
	
	private static int nextConfirmationNumber=1;
	
	private int confirmationNumber;
	
	private HashMap<Product,Integer> items;
	private double totalprice;
	/**
	 * Constructor for creating object of Order calss for initializing the values from shoppingcart class getting items and total price. 
	 * @param items
	 * @param totalprice
	 */
	public Order(HashMap<Product,Integer> items, double totalprice) {
		this.confirmationNumber=nextConfirmationNumber++;
		this.items=items;
		this.totalprice=totalprice;
			
	}
	/**
	 * Getting the confirmation number 
	 * @return
	 * return the confirmation number
	 */
	public int getConfirmationNumber() {
		return confirmationNumber;
	}
	
	/**
	 * getting all the items from the shopping cart
	 * @return
	 * return all the items from the shopping cart
	 */
	public HashMap<Product, Integer> getItems() {
		return items;
	}
	/**
	 * get the total price of all the products from the shopping cart
	 * @return
	 * return the total price of all the products
	 */
	public double getTotalPrice() {
		return totalprice;
	}
	
	public String toString() {
		return "Order confirmation number : "+confirmationNumber+", Items: "+items+", Total price : $"+totalprice;
	}
}
