package chatapp;

public class User {
	
	
	public static String username;
	public static String password;
	public static int userID;
	
	
	public static String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		User.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		User.password = password;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		User.userID = userID;
	}

}
