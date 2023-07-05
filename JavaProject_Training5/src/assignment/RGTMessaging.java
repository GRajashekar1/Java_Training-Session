package assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RGTMessaging {
	private Map<String, User> users;

	private List<Tweet> tweets;

	private User currentUser;
	
	/**
	 * Get the users using map 
	 * @return
	 * Return the users
	 */
	public Map<String, User> getUsers() {
		return users;
	}
	/**
	 * Set the users in a hashmap
	 * @param users
	 */
	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}
	
	/**
	 * Get the tweets stored in a list
	 * @return
	 * return the tweets of users
	 */
	public List<Tweet> getTweets() {
		return tweets;
	}
	
	/**
	 * Set all the tweets using list for tweet class
	 * @param tweets
	 */
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	/**
	 * get the current user
	 * @return
	 * return the current user who is logged in
	 */
	public User getCurrentUser() {
		return currentUser;
	}
	/**
	 * Set the current user from user class
	 * @param currentUser
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
	/**
	 * Constructor for creating object of RGT Messaging class using hashmap, arraylist
	 */
	public RGTMessaging() {
		this.users = new HashMap<String, User>();
		this.tweets = new ArrayList<Tweet>();
		this.currentUser = null;
        this.loadData(); 
		
	}
	/**
	 * User want to register 
	 * @param scanner
	 * Having username, 
	 * password, 
	 * name and 
	 * bio
	 */
	public void registerUser(Scanner scanner) {
		System.out.println("Enter a username: ");
		String username = scanner.next();
		if (users.containsKey(username)) {
			System.out.println("username already exists.. ");
			return;
		}
		System.out.println("Enter a password: ");
		String password = scanner.next();

		System.out.println("Enter a name: ");
		String name = scanner.next();

		System.out.println("Enter a bio: ");
		String bio = scanner.next();

		User newUser = new User(username, password, name, bio);
		users.put(username, newUser);

		System.out.println("User Registered Successfully.. ");
	}
	/**
	 * User want to login 
	 * After login user want to post the tweet, view the timeline, search the users, search the tweets, user wants to see his profile details, load the data, save the data and user can logout
	 * @param scanner
	 * Using scanner class
	 */
	public void login(Scanner scanner) {

		System.out.println("Enter a username: ");
		String username = scanner.next();

		System.out.println("Enter a password: ");
		String password = scanner.next();

		User user = users.get(username);
		if (user != null && user.getPassword().equals(password)) {
			currentUser = user;
			System.out.println("Welcome " + "["+currentUser.getName() + "]");
			boolean logout = false;
			while (!logout) {
				System.out.println(" 1. Post a tweet \n 2. View your  timeline \n 3. Search for users \n 4. Search for tweets \n 5. View your profile \n 6. Load Data \n 7. Save Data \n 8. Logout");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					postTweet(scanner);
					break;
				case 2:
					getTimeline(scanner);
					break;
				case 3:
					searchUser(scanner);
					break;
				case 4:
					searchTweet(scanner);
					break;
				case 5:
					getProfile(scanner);
					break;
				case 6:
					loadData();
					break;
				case 7:
					saveData();
					break;
				case 8:
					logout = true;
					System.out.println("Logging out user: " + currentUser.getUserName());
					currentUser = null;
					System.out.println("Logged out successfully.");
					break;

				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			}
		} else {
			System.out.println("Entered Username or passord Invalid. Please try again.");
		}
	}
	
	/**
	 * User want to logout
	 */
	public void logout() {

		System.out.println("Logging out user: " + currentUser.getUserName());
		currentUser = null;
		System.out.println("Logged out successfully.");
	}
	
	/**
	 * User want to search the users
	 * @param scanner
	 */
	public void searchUser(Scanner scanner) {
		System.out.println("Enter the username to search for:");
		String username = scanner.next();

		if (users.containsKey(username)) {
			User user = users.get(username);
			System.out.println("User found:");
			System.out.println("Username: " + user.getUserName());
			System.out.println("Name: " + user.getName());
			System.out.println("Bio: " + user.getBio());
		} else {
			System.out.println("User not found.");
		}
	}
	
	/**
	 * User want to search the tweets
	 * @param scanner
	 */
	public void searchTweet(Scanner scanner) {
		System.out.println("Enter the tweet ID to search for:");
		String tweetId = scanner.next();

		for (Tweet tweet : tweets) {
			if (tweet.getId().equals(tweetId)) {
				System.out.println("Tweet found:");
				System.out.println("ID: " + tweet.getId());
				System.out.println("Content: " + tweet.getContent());
				System.out.println("Author: " + tweet.getAuthor());
				System.out.println("Timestamp: " + tweet.getTimestamp());
				return;
			}
		}

		System.out.println("Tweet not found.");
	}
	
	/**
	 * getting the timeline of the post, 
	 * using id of the tweet, author, timesstamp, likes of the user, replies of the tweet, retweets.
	 * then we have to select the options to like, retweets and replies of the tweet.
	 * 
	 * @param scanner
	 */
	public void getTimeline(Scanner scanner) {

		System.out.println("Timeline for user: " + currentUser.getUserName());
		for (Tweet tweet : tweets) {
			if (currentUser.getTweets().contains(tweet.getId())) {
				System.out.println("ID: " + tweet.getId());
				System.out.println("Content: " + tweet.getContent());
				System.out.println("Author: " + tweet.getAuthor());
				System.out.println("Timestamp: " + tweet.getTimestamp());
				System.out.println("Likes: " + tweet.getLikeUser().size());
				System.out.println("Retweets: " + tweet.getRetweets().toString());
				System.out.println("Replies: " + tweet.getReplies().toString());
				System.out.println();
			}
			boolean back = false;
			while (!back) {
				System.out.println("User want to like, retweet, reply to the tweet and if user want to go back");
				System.out.println(" 1. Like a tweet \n 2. Retweet \n 3. Reply to tweet \n 4. Back to menu");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the tweetId of the tweet you want to like: ");
					String tweetId = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getId().equals(tweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.like();
						}
					}
					break;
				case 2:
					System.out.println("Enter the tweetId of the tweet you want to retweet: ");
					String retweetId = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getId().equals(retweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.retweet();
						}
					}
					break;
				case 3:
					System.out.println("Enter the tweetId of the tweet you want to reply to: ");
					String replyTweetId = scanner.next();
					// scanner.next();
					System.out.println("Enter your reply: ");
					String replyContent = scanner.next();
					for (Tweet tweet2 : tweets) {
						if (tweet2 != null && tweet2.getId().equals(replyTweetId)) {
							tweet2.setCurrentUser(currentUser);
							tweet2.reply(replyContent);
						}
					}
					break;
				case 4:
					back = true;
					System.out.println("Returning to the menu.");
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
				}
			}
		}
	}
	
	/**
	 * get the profile of the current user using scanner class
	 * profile having details like 
	 * user name, name, bio, followers, followings and tweets
	 * @param scanner
	 */
	public void getProfile(Scanner scanner) {

		System.out.println("Profile details of the current user: " + currentUser.getUserName());
		System.out.println("Name: " + currentUser.getName());
		System.out.println("Bio: " + currentUser.getBio());
		System.out.println("Followers: " + currentUser.getFollowers().size());
		System.out.println("Following: " + currentUser.getFollowings().size());
		System.out.println("Tweets: " + currentUser.getTweets().toString());

		boolean back = false;
		while (!back) {
			System.out.println("If user want to follow or unfollow the users");
			System.out.println(" 1. follow \n 2. unfollow \n 3. back ");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your username: ");
				String username = scanner.next();

				User user = users.get(username);

				if (user != null) {
					currentUser.follow(user);
				}

				break;
			case 2:
				System.out.println("Enter your username: ");
				String username2 = scanner.next();

				User user1 = users.get(username2);
				if (user1 != null) {
					currentUser.unfollow(user1);
				}
				break;
			case 3:
				back = true;
				System.out.println("back the profile.");
				break;

			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}

	}
	/**
	 * User want to post the tweet using scanner class using tweet id content 
	 * @param scanner
	 */
	public void postTweet(Scanner scanner) {

		System.out.println("Enter your tweetId: ");
		String tweetId = scanner.next();

		System.out.println("Enter your tweet content: ");
		String content = scanner.next();

		Tweet tweet = new Tweet(tweetId, content, currentUser.getUserName(), LocalDateTime.now());
		tweets.add(tweet);
		currentUser.postTweet(tweetId);

	}
	
	/**
	 * Read the data from of the users and tweets and load the data of users and tweets in future which is stored in the data store class
	 */
	public void loadData() {
	    users = DataStore.loadUsers();
	    tweets = DataStore.loadTweets();
	    System.out.println("Data loaded successfully....");
	}
	/**
	 * Save all the data of the users and tweets in users file and tweets file
	 */
	public void saveData() {
	    DataStore.saveUsers(users);
	    DataStore.saveTweets(tweets);
	    System.out.println("Data saved successfully.");
	}


	
	
}
