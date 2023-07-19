package assignment;

public class UserObserver implements Observer{
	private User user;
		
	/**
	 * Constructor a userobserver object with a specified user
	 * @param user
	 */
	public UserObserver(User user) {
		this.user=user;
	}
	
	/**
	 * get the user
	 * @return
	 * the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Sets the user
	 * @param user
	 */
	public void setUser(User user) {
		this.user=user;
	}
	
	/**
	 * Notifies the user of being outbid on the item with update 
	 * @param item
	 */
	public void update(Item item) {
		  //Notify user of being outbid
		if(item.getHighestBidder()!=null && !item.getHighestBidder().equals(user)) {
			System.out.println("You have been outbid on item :"+item.getName());
		}
	}

}
