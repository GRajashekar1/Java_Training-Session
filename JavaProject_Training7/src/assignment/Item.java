package assignment;

import java.util.List;

public class Item {
	private String name;
	private String description;
	private double currentHighestBid;
	private User highestBidder;
	private List<UserObserver> observers;

	// constructor, getters, and setters
	/**
	 * 
	 * @param name
	 * @param description
	 * @param startingBid
	 */
	public Item(String name, String description, double startingBid) {
		this.name = name;
		this.description = description;
		this.currentHighestBid = startingBid;
	}

	/**
	 * add the observer
	 * 
	 * @param observer
	 */
//	public void addObserver(UserObserver observer) {
//		observers.add(observer);
//	}

	/**
	 * remove the observer
	 * 
	 * @param observer
	 */
	public void removeObserver(UserObserver observer) {
		observers.remove(observer);
	}

	/**
	 * getting the item name
	 * 
	 * @return returning the item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setting the item name name @param
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Notify the observers using for loop observer to update
	 */
//	public void notifyObservers() {
//		for (UserObserver observer : observers) {
//			observer.update(this);
//		}
//	}

	/**
	 * user @param will bid amount, if condition of the @param bidAmount is greater
	 * than current highest bid bid amount assign to the current highest bid and
	 * given user assign to highest bid then calls notifyobserver method.
	 * 
	 */
	public void placeBid(User user, double bidAmount) {
		if (bidAmount > currentHighestBid) {
			currentHighestBid = bidAmount;
			highestBidder = user;
		}
	}

	/**
	 * get description
	 * 
	 * @return return description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * set the description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get highest bidder
	 * 
	 * @return return highest bidder
	 */
	public User getHighestBidder() {
		return highestBidder;
	}

	/**
	 * get current highest bid
	 * 
	 * @return return current highest bid
	 */
	public double getCurrentHighestBid() {
		return currentHighestBid;
	}
}
