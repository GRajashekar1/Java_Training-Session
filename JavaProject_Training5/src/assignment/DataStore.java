package assignment;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataStore {
	
	private static final String USERS_FILE = "users.txt";
	private static final String TWEETS_FILE = "tweets.txt";

	/**
	 * Save the data of the users and tweets 
	 * @param users
	 * @param tweets
	 */
	public static void saveData(Map<String, User> users, List<Tweet> tweets) {
	    saveUsers(users);
	    saveTweets(tweets);
	}
	
	/**
	 * Return the loaded data of the users 
	 * @return
	 */
	public static Map<String, User> loadDataUsers() {
	    return loadUsers();
	}
	
	/**
	 * Return Load data tweets which is stored in a list 
	 * @return
	 */
	public static List<Tweet> loadDataTweets() {
	    return loadTweets();
	}
	
	/**
	 * Save all the users in the users file who are registered, in future if want the data is saved 
	 * 
	 * @param users
	 */
	public static void saveUsers(Map<String, User> users) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
	        oos.writeObject(users);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * All the data of users are loaded
	 * @return
	 * Return the load users which is stored in the users file in future if wants
	 */
	public static Map<String, User> loadUsers() {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
	        return (Map<String, User>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        return new HashMap<>();
	    }
	}
	/**
	 * Save all the tweets in the tweets file
	 * @param tweets
	 */
	public static void saveTweets(List<Tweet> tweets) {
	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TWEETS_FILE))) {
	        oos.writeObject(tweets);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	/**
	 * Load the tweets from tweets file
	 *  
	 * @return
	 * Return the loaded tweets from a tweets file 
	 */
	public static List<Tweet> loadTweets() {
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TWEETS_FILE))) {
	        return (List<Tweet>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        return new ArrayList<>();
	    }
	}
	
}
