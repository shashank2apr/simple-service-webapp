/** 
	Perfect  example of Static class too !!!
  ____________
///          \\\
	 +     +
		_
	__	    __
	 \______/
**/
package main.java.com.database;

import java.util.HashMap;
import java.util.Map;

import main.java.com.model.Message;
import main.java.com.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long,Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
	

}
