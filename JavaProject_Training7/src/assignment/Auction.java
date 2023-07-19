package assignment;

import java.util.ArrayList;
import java.util.List;

public class Auction {
	private static Auction instance=null;
	private List<Item> items;
	/**
	 * Auction class constructor of items in ArrayList
	 */
	private Auction() {
		items = new ArrayList<>();
	}
	
	/**
	 * Get the instance method 
	 * @return
	 * return the instance method of Auction class
	 */
	public static Auction getInstance() {
		if (instance == null) {
			instance = new Auction();
		}
		return instance;
	}
	
	/**
	 * add the item
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}
}
