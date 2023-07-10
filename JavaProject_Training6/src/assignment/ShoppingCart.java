package assignment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HashMap<Product, Integer> items;
	/**
	 * Shopping cart constructor is used for initialize.
	 */
	public ShoppingCart() {
		items=new HashMap<>();
		
	}
	/**
	 * Adding the product which user wants and how many qantities are required based on availability in the application
	 * @param product
	 * @param quantity
	 */
	public void addItem(Product product, int quantity) {
		if(items.containsKey(product)) {
			int currentQuantity=items.get(product);
			items.put(product, currentQuantity+quantity);
		}
		else {
			items.put(product, quantity);
		}
	}
	/** 
	 * remove the product from the shopping cart
	 * @param product
	 */
	public void removeProduct(Product product) {
		items.remove(product);
	}
	
	/**
	 * returns the total price of all the items in the shopping cart
	 * @return 
	 */
	public double getTotalPrice() {
		double totalprice = 0.0;
		for(Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product=entry.getKey();
			int quantity=entry.getValue();
			totalprice=product.getPrice()*quantity;
		}
		return totalprice;
	}
	/**
	 * getting the items from the cart
	 * @return
	 * Return the items
	 */
	public HashMap<Product, Integer> getItems() {
		return items;
	}
	
	/**
	 * Iterating the map and getting list of items and getting the item and using if condition according to key and name of item.
	 * @param name
	 * @return
	 * if the item is matching then return the item from shopping cart.
	 */
	public Product getItems(String name) {
		for(Map.Entry<Product, Integer> item:items.entrySet()) {
			if(item.getKey().getName().equals(name)) {
				return item.getKey();
			}
		}
		return null;
	}
	
	/**
	 * Clearing the cart items
	 */
	public void clearCart() {
		items.clear();
	}
	
	/**
	 * displaying the quantities of an item user want to add the product to cart.
	 */
	public void displayCart() {
		for(Map.Entry<Product, Integer> entry: items.entrySet()) {
			Product product=entry.getKey();
			int quantity=entry.getValue();
			System.out.println(" ");
			System.out.println(product +", Quantity you need : " +quantity);
		}
	}
	/**
	 * If the cart is having empty items.
	 * @return
	 * return the null items.
	 */
	public boolean isempty() {
		return items.isEmpty();
		
	}
	
	
}
