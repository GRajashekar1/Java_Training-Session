package assignment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet {
	
	private String id;
	private String content;
	private String author;
	private LocalDateTime timestamp;
	private int likecount;
	private List<String> likedusers;
	private List<Tweet> retweets;
	private List<Tweet> replies;
	private User currentuser;
	
	/**
	 * Constructor for creating tweter object
	 * 
	 * @param id of the tweter
	 * @param content of the tweer
	 * @param author of the tweter
	 * @param timestamp of the tweter
	 */
	public Tweet(String id, String content,String author,LocalDateTime timestamp) {
		this.id=id;
		this.content=content;
		this.author=author;
		this.timestamp=timestamp;
		this.likecount=0;
		this.likedusers=new ArrayList<>();
		this.retweets=new ArrayList<>();
		this.replies=new ArrayList<>();
		this.currentuser=null;
		
	}
	
	/**
	 * Getting the id of the tweet
	 * @return
	 * Returning the id of the tweter
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 * Setting the id of tweet
	 */
	public void setId(String id) {
		this.id=id;
		
	}
	/**
	 * Getting the current user from the tweet class
	 * @return
	 * Returning the current user
	 */
	public User getCurrentUser() {
		return currentuser;
	}
	
	/**
	 * Setting value for current user
	 * @param currentuser
	 */
	public void setCurrentUser(User currentuser) {
		this.currentuser=currentuser;
	}
	/**
	 * Getting the content from the tweet class
	 * 
	 * @return
	 * Returning the content of the tweter
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Setting the content for the tweet class
	 * @param content
	 */
	public void setContent(String content) {
		this.content=content;
	}
	
	/**
	 * Getting author from the tweet class
	 * @return
	 * Return the author of the tweeter
	 */
	public String getAuthor() {
		return author;
	}
	
	
	/**
	 * Set the author from tweet class
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author=author;
	}
	
	
	/**
	 * Getting the time stamp from the tweet class
	 * 
	 * @return
	 * Returning the time stamp from tweet class
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	
	
	/**
	 * Setting the time stamp of tweet class
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp=	timestamp;
	}
	
	/**
	 * Getting the like count of the tweter
	 *
	 * @return
	 *  Returning the like count to the tweter
	 */
	public int getLikeCount(){
		return likecount;
	}
	
	/**
	 * Setting the like count of the tweter
	 * @param likecount
	 */
	public void setLikeCount(int likecount) {
		this.likecount=likecount;
	}
	
	
	/**
	 * Getting the likes for the tweet from the user
	 * 
	 * @return
	 * Returning the likes of the users for the tweet
	 */
	public List<String> getLikeUser() {
		return likedusers;
	}
	
	/**
	 * Setting the likes for the tweet from the user
	 * @param likeduser
	 */
	public void setLikedUser(List<String> likeduser) {
		this.likedusers=likeduser;
	}
	
	/**
	 * Getting the retweets for the tweter
	 * 
	 * @return
	 * Returning the retweets of the tweter
	 */
	public List<Tweet> getRetweets() {
		return retweets;
	}
	
	/**
	 * Setting the parameter of retweets in the tweet class and stored tweets in a list
	 * @param retweets
	 */
	public void setRetweets(List<Tweet> retweets) {
		this.retweets=retweets;
	}
	
	
	/**
	 * Getting the replies for the tweets which stored tweets in a list
	 * 
	 * @return
	 * Returning the replies for the tweet from the tweet class
	 */
	public List<Tweet> getReplies() {
		return replies;
	}
	
	/**
	 * Setting the replies for the tweets which is stored tweets in a list 
	 * @param replies
	 */
	public void setReplies(List<Tweet>replies) {
		this.replies=replies;
	}
	
	/**
	 * Increases the like count if the current user likes the tweet
	 */
	public void like() {
		likecount++;
		likedusers.add(currentuser.getUserName());
		System.out.println("Tweet liked successfully");
		
	}
	
	/**
	 * user has to give retweet for a tweet by passing the parameter in tweet constructor
	 */
	public void retweet() {
		Tweet retweet=new Tweet(id,content, currentuser.getUserName(),LocalDateTime.now());
		retweets.add(retweet);
		System.out.println("tweet Retweeted successfully");
		
	}
	
	/**
	 * user has to give reply for the content
	 * @param replycontent
	 */
	public void reply(String replycontent) {
		Tweet reply=new Tweet(id,replycontent, currentuser.getUserName(),LocalDateTime.now());
		replies.add(reply);
		System.out.println("replied to the tweet successfully");
	}

	@Override
	public String toString() {
		return "Tweet [content=" + content + ", author=" + author + ", timestamp=" + timestamp
				+  "]";
	}
	
	
	
}
