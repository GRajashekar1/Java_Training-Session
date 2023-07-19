package assignment;

public class Bid {
	private Item itemname;
	private User bidder;
	private double amount;
	private boolean winbid;

	/**
	 * 
	 * @param itemname
	 * @param bidder
	 * @param amount
	 */
	public Bid(Item itemname, User bidder, double amount) {
		this.itemname = itemname;
		this.bidder = bidder;
		this.amount = amount;
		this.winbid = false;
	}

	/**
	 * get item name
	 * 
	 * @return return the item name
	 */
	public Item getItemname() {
		return itemname;
	}

	/**
	 * get the bidder
	 * 
	 * @return return the bidder
	 */
	public User getBidder() {
		return bidder;
	}

	/**
	 * get the amount
	 * 
	 * @return return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * get the win bid
	 * 
	 * @return return the boolean statement
	 */
	public boolean isWinbid() {
		return winbid;
	}

	/**
	 * set the win bid
	 * 
	 * @param winbid
	 */
	public void setWinbid(boolean winbid) {
		this.winbid = winbid;
	}
}
