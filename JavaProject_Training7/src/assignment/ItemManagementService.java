package assignment;

import java.util.ArrayList;
import java.util.List;

public class ItemManagementService {
	private Auction auction;
	private List<Item> items;

	/**
	 * Constructor for a ItemManagementService class having the items 
	 */
	public ItemManagementService() {
		this.auction = Auction.getInstance();
		this.items=new ArrayList<>();
		Item item = ItemFactory.createItem("Men's North Face jacket", "A waterproof jacket for men", 1000.0);
		Item item1 = ItemFactory.createItem("Womens columbia jacket", "A warm and stylish jacket for women", 750.0);
		Item item2 = ItemFactory.createItem("Men slim mid rise light blue jeans",
				"A skinny fit with a waist & comfortably", 600.0);
		Item item3 = ItemFactory.createItem("Men slim mid rise light black jeans", "This fits snug on the thights",
				700.0);
		items.add(item);
		items.add(item1);
		items.add(item2);
		items.add(item3);

	}

	/**
	 * from Item factory class, call createitem method to add the item using auction class using 
	 * @param name
	 * @param description
	 * @param startingBid
	 */
	public void addItem(String name, String description, double startingBid) {
		Item item = ItemFactory.createItem(name, description, startingBid);
		auction.addItem(item);
	}

	
	/**
	 * Item as list and using for loop multiple items to single item search the result of item 
	 * based on the condition if the 
	 * @param keyword
	 * @return
	 * the search results 
	 */
	public List<Item> searchItems(String keyword) {
		List<Item> searchResults = new ArrayList<>();
		for (Item item : items) {
			if (item.getName().toLowerCase().contains(keyword.toLowerCase())
					|| item.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
				searchResults.add(item);
			}
		}
		return searchResults;
	}
	// **********Other methods for managing items and bids
	/**
	 * getting the 
	 * @param ItemByName from the list of items based on the condition the item will return if the itemname is present
	 *  
	 * @return
	 * the item which item user want.
	 */
	public Item getItemByName(String itemName){
		for(Item item: items) {
			if(item.getName().equalsIgnoreCase(itemName)) {
				return item;
			}
		}
		return null;
	}
}
