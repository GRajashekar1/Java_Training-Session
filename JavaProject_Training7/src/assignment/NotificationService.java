package assignment;

public class NotificationService {
	/**
	 * Send the notification by passing 
	 * @param user and
	 * @param message from user class get the username
	 */
	public void sendNotification(User user, String message) {
		System.out.println("Sending notification to user " + user.getUsername() + ": " + message);
	}
	/**
	 * Notifies the user observer by passing 
	 * @param user and
	 * @param item
	 * from the user observer class call update method using parameter item and get the name of item
	 * which user want to update.
	 */
	public void notifyUser(User user, Item item) {
		UserObserver observer = new UserObserver(user);
		observer.update(item);
		//System.out.println("You have been outbid on item :" + item.getName());
	}
}
