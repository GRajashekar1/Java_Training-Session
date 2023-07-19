package assignment;

import java.util.ArrayList;
import java.util.List;

public class User {
	// User class
		private String username;
		private String password;
		private List<Bid> biddingHistory;

		/**
		 * Constructor for user class getters, and setters
		 * @param username
		 * @param password
		 */
		public User(String username, String password) {
			this.username=username;
			this.password=password;
			this.biddingHistory=new ArrayList<>();
		}
		
		/**
		 * Get the username for the user
		 * @return
		 * return the username for the user
		 */
		public String getUsername() {
			return username;
		}
		
		/**
		 * Set the username for the user
		 * @param username
		 * return the username for the user
		 */
		public void setUsername(String username) {
			this.username = username;
		}
		
		/**
		 * Get the password for the user
		 * @return
		 * Return the password for the user
		 */
		public String getPassword() {
			return password;
		}
		
		/**
		 * Set the password for the user
		 * @param password
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		
		/**
		 * Get the bidding history 
		 * @return
		 * return the bidding history
		 */
		public List<Bid> getBiddingHistory() {
			return biddingHistory;
		}
		
		/**
		 * Set the bidding history
		 * biddingHistory @param 
		 */
		public void setBiddingHistory(List<Bid> biddingHistory) {
			this.biddingHistory = biddingHistory;
		}
		
		/**
		 * Adding the bid
		 * @param bid
		 */
		public void addBid(Bid bid) {
			biddingHistory.add(bid);
		}
}
