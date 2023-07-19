package assignment;

public class ItemFactory {
	/**
     * Creates an Item object with the specified the @param name of the item, 
     * the @param description of the @param starting bid for the item and starting bid.
     * @return 
     * the created Item object.
     */
	public static Item createItem(String name, String description, double startingBid) {
		return new Item(name, description, startingBid);
	}
}
