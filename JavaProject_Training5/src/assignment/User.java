package assignment;

import java.util.HashSet; 
import java.util.Set;

public class User {

	private String userName;
	private String password;
	private String name;
	private String bio;
	private Set<String> followings;
	private Set<String> followers;
	private Set<String> tweets;

	/**
	 * constructor for creating user object
	 * @param username
	 * @param pswrd
	 * @param nme
	 * @param bio
	 */
	public User(String username, String pswrd, String nme, String bio) {
		super();
		this.userName = username;
		this.password = pswrd;
		this.name = nme;
		this.bio = bio;
		this.followings = new HashSet<>();
		this.followers = new HashSet<>();
		this.tweets = new HashSet<>();

	}

	/**
	 * getting the username from the user class
	 * Returning the username from user class
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Set the username using parameters
	 * 
	 * @param username
	 */
	public void setUserName(String username) {
		this.userName = username;
	}

	/**
	 * Returning the password of the user
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set the password for the particular user
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * get the name of the user
	 * return the name of the user
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * set the name for the user from user class
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the bio of the user
	 * return the bio of the user from user class
	 * @return
	 */
	public String getBio() {
		return bio;
	}
	/**
	 * setting the bio of the users
	 * @param bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	/**
	 * get the followings of the users
	 * return how many followings of the users from users class
	 * @return
	 */
	public Set<String> getFollowings() {
		return followings;
	}
	
	/**
	 * Set the followings of the users
	 * @param followings
	 */
	public void setFollowings(Set<String> followings) {
		this.followings = followings;
	}
	
	/**
	 * get the followers
	 * Return the followers from user class 
	 * @return
	 */
	public Set<String> getFollowers() {
		return followers;
	}
	
	/**
	 * set the followers of the user 
	 * @param followers
	 */
	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}
	
	/**
	 * get the tweets of the user class
	 * return the tweets
	 * @return
	 */
	public Set<String> getTweets() {
		return tweets;
	}
	
	/**
	 * Set the tweets of the tweter
	 * @param tweets
	 */
	public void setTweets(Set<String> tweets) {
		this.tweets = tweets;
	}
	
	/**
	 * user want to follow 
	 * @param user
	 */
	public void follow(User user) {
		followings.add(user.getUserName());
		user.followers.add(userName);
		System.out.println("You successfully followed @" + user.getUserName());

	}
	
	/**
	 * User want to unfollow
	 * @param user
	 */
	public void unfollow(User user) {
		followers.remove(user.getUserName());
		user.followers.remove(userName);
		System.out.println("You successfully unfollowed @" + user.getUserName());
	}
	
	/**
	 * Post the tweet of user using id
	 * @param tweetid
	 */
	public void postTweet(String tweetid) {
		tweets.add(tweetid);
		System.out.println("Tweet posted successfully.");
	}
	
	/**
	 * delete the tweet of user using id
	 * @param tweetid
	 */
	public void deleteTweet(String tweetid) {
		tweets.remove(tweetid);
		System.out.println("Tweet deleteed successfully.");
	}

}
