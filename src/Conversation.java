import java.util.ArrayList;
//This class might not be used later!

public class Conversation {
	ArrayList<Message> allMessages= new ArrayList<Message>();
	User sender;
	User reciever;
	
	public Conversation(ArrayList<Message> allMessages, User sender, User reciever) {
		this.allMessages = allMessages;
		this.sender = sender;
		this.reciever = reciever;
	}
	
	
}
