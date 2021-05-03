import java.util.*;

abstract public class Conversation {
	
	TreeSet<Message> allMessages = new TreeSet<Message>();
	
	
	//Add a message to the message List
	public void addMesage(Message newMessage) {
		
		allMessages.add(newMessage);
	}
	
}
