package assignment;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
	private List<User> users;

	public UserManagementService() {
		this.users = new ArrayList<>();
	}

	/**
	 * creates the user with the @param username and @param password
	 * coming from the user class. 
	 */
	public void createUser(String username, String password) {
		User user = new User(username, password);
		users.add(user);
		System.out.println("User created new account.");
	}

	/**
	 * authenticate the
	 * @param username
	 * @param password if the multiple users are present then login and
	 * @return
	 * the user
	 */
	public User authenticateUser(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				
				return user;
			}
		}
		return null;
	}

	/**
	 * Updates the password user a with the specified user
	 * @param user
	 * @param newPassword
	 */
	public boolean updatePassword(String Username, String newPassword) {
		for (User user : users) {
			if (user.getUsername().equals(Username)) {
				user.setPassword(newPassword);
				return true;
			}
		}
		return false;
	}
}
