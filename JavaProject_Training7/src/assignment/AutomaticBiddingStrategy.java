package assignment;

public class AutomaticBiddingStrategy implements BiddingStrategy {
	/**
     * create double bid method with @param item, user and amount
     */
	@Override
	public double bid(Item item, User user, double amount) {
		//Implement automatic bidding strategy
		double currentbid=item.getCurrentHighestBid();
		//Place a bid that is 10 units higher than the current highestbid
		double automaticbid=currentbid+1.0;
		item.placeBid(user, automaticbid);
		return automaticbid;
		
     }
}