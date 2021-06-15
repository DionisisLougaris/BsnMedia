package entities;

import java.io.Serializable;

public class privateConversation extends Conversation implements Serializable{
	
	private User discussant1; //Συνομιλιτης 1
	private User discussant2; //Συνομιλιτης 2
	
	
	//Constructor for private Conversation
	public privateConversation(User discussant1, User discussant2) {
		super();
		this.discussant1 = discussant1;
		this.discussant2 = discussant2;
	}
	
	
	public User getDiscussant1() {
		return discussant1;
	}
	public void setDiscussant1(User discussant1) {
		this.discussant1 = discussant1;
	}
	public User getDiscussant2() {
		return discussant2;
	}
	public void setDiscussant2(User discussant2) {
		this.discussant2 = discussant2;
	}


	@Override
	public void addMessage(Message aMessage) {
		Storage.saveMessage(aMessage, this);
		
	}
}
