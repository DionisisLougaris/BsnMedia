package entities;

import java.io.File;

public class privateConversation extends Conversation{
	
	private User discussant1; //����������� 1
	private User discussant2; //����������� 2
	
	
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
}
