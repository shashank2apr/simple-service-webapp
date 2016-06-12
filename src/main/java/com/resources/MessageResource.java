package main.java.com.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import main.java.com.model.Message;
import main.java.com.resources.beans.MessageFilterBean;
import main.java.com.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
		
	/**
	 * This method uses BeanParams to return:
	 * 	1- Messages by year when year filter is applied
	 * 	2- Messages by pages when start and size are mentioned, hence pagination is applied
	 * 	3- Otherwise return ALL messages.
	 * **/
	@GET
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear()>0){
			return messageService.getMessagesByYear(filterBean.getYear());
		}
		else if(filterBean.getStart() >= 0 && filterBean.getSize()> 0){
			return messageService.getMessagesPaginated(filterBean.getStart(),filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long id){
		return messageService.removeMessage(id);
	}
	
}
