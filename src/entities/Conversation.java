package entities;

import java.io.File;
import java.util.*;

abstract public class Conversation extends Notification{
	
	protected ArrayList<Message> allMessages = new ArrayList<Message>();
	
	
	//Add a message to the message List
	public void addMesage(Message newMessage) {
		
		allMessages.add(newMessage);
	}


	public ArrayList<Message> getAllMessages() {
		return allMessages;
	}
	public void setAllMessages(ArrayList<Message> allMessages) {
		this.allMessages = allMessages;
	}
	
}
