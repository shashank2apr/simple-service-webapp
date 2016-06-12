package main.java.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.database.DatabaseClass;
import main.java.com.model.Message;


public class MessageService {
	
	Message message1 = new Message(1, "message1", "author1");
	Message message2 = new Message(2, "message2", "author2");
	/*	
	public List<Message> getAllMessages(){
		List<Message> list = new ArrayList<Message>();
		list.add(message1);
		list.add(message2);
		return list;
	}*/
	public MessageService(){
		messages.put(1L, message1);
		messages.put(2L, message2);
	}
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	
	/**
	 * Implementing "Filtering" by year
	 *  **/
	public List<Message> getMessagesByYear(int year) {

		List<Message> list = null;
		list = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();

		for (Message message : messages.values()) {
			
			cal.setTime(message.getCreated());

			if (cal.get(Calendar.YEAR) == year) {
				list.add(message);
			}
		}

		return list;
	}	
	
	/**
	 * Implementing "Pagination"
	 * **/
	public List<Message> getMessagesPaginated(int start, int size) {

		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		if(start+size > list.size()){
			return new ArrayList<Message>();
		}
			
		return list.subList(start, start + size);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(0==message.getId()){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	
	}
}
