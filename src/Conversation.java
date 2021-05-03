import java.util.ArrayList;

abstract public class Conversation {
	
	ArrayList<Message> allMessages= new ArrayList<Message>();
	
	public void addMesage(Message newMessage) {
		
		allMessages.add(newMessage);
	}
	
}
