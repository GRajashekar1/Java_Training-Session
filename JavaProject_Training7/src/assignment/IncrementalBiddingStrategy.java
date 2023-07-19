package assignment;

public class IncrementalBiddingStrategy implements BiddingStrategy {
	/**
	 * calling the bid method from the item class getting the current highest bid
	 * and assigning to currentbid object if the given amount is less than the
	 * current amount then it will 0 or if the given amount is greater than the
	 * current amount then it will return the given amount.
	 */
	@Override
	public double bid(Item item, User user, double amount) {
		double currentBid = item.getCurrentHighestBid();
		if (amount > currentBid) {
			item.placeBid(user, amount);
			Bid bid = new Bid(item, user, amount);
			user.addBid(bid);
			return amount;
		} else {
			System.out.println("Your amount is less than the current amount");
			NotificationService notificationservice = new NotificationService();
			notificationservice.notifyUser(user, item);
		}
		return 0;

	}
}