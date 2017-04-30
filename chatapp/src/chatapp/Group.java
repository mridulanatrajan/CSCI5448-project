package chatapp;

import java.util.ArrayList;

public class Group {
	
	public static String groupid;
	public static String groupname;
	public static ArrayList<String> groupmembers;
	
	public static String getGroupid() {
		return groupid;
	}
	
	public static void setGroupid(String groupid) {
		Group.groupid = groupid;
	}
	
	public static String getGroupname() {
		return groupname;
	}
	
	public static void setGroupname(String groupname) {
		Group.groupname = groupname;
	}

	public static ArrayList<String> getGroupmembers() {
		return groupmembers;
	}

	public static void setGroupmembers(ArrayList<String> groupmembers) {
		Group.groupmembers = groupmembers;
	}

}
