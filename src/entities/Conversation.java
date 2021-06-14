package entities;

import java.io.File;
import java.util.*;

abstract public class Conversation extends Notification{
	
	protected ArrayList<Message> allMessages = new ArrayList<Message>();
	
	
	//Add a message to the message List
	abstract public void addMessage(Message aMessage);


	public ArrayList<Message> getAllMessages() {
		return allMessages;
	}
	public void setAllMessages(ArrayList<Message> allMessages) {
		this.allMessages = allMessages;
	}
	
}
