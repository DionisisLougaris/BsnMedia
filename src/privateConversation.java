
public class privateConversation extends Conversation{
	
	private User discussant1; //Συνομιλιτης 1
	private User discussant2; //Συνομιλιτης 2
	
	
	//Constructor for private Conversation
	public privateConversation(User discussant1, User discussant2) {
		super();
		this.discussant1 = discussant1;
		this.discussant2 = discussant2;
	}
	
	
	
}
