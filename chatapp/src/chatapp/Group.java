package chatapp;

import java.util.ArrayList;
import java.util.HashSet;

public class Group {
	
	public static int groupid;
	public static String groupname;
	public static HashSet<String> groupmembers;
	
	public static int getGroupid() {
		return groupid;
	}
	
	public static void setGroupid(int groupid) {
		Group.groupid = groupid;
	}
	
	public static String getGroupname() {
		return groupname;
	}
	
	public static void setGroupname(String groupname) {
		Group.groupname = groupname;
	}

	public static HashSet<String> getGroupmembers() {
		return groupmembers;
	}

	public static void setGroupmembers(HashSet<String> groupmembers) {
		Group.groupmembers = groupmembers;
	}


}
