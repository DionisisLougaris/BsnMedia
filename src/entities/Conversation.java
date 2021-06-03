package entities;

import java.io.File;
import java.util.*;

abstract public class Conversation extends Notification{
	
	protected ArrayList<Message> allMessages = new ArrayList<Message>();
	File conversationName = new File("uniqueConversationFIleName.txt");
	
	
	//Add a message to the message List
	public void addMesage(Message newMessage) {
		
		allMessages.add(newMessage);
	}


	public File getConversationName() {
		return conversationName;
	}
	
	
}
