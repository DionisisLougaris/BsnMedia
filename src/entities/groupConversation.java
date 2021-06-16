package entities;

import java.io.Serializable;

public class groupConversation extends Conversation implements Serializable{

	private Group theGroup; //The group for which the group chat corresponds

	
	
	//This method with the help of the Storage class ,adds a messages to the unique group convo file
	public void addMessage(Message aMessage) {
			
			Storage.saveMessage(aMessage, this);
		}
	
	
	//*************** Getters and Setters *************
	public groupConversation(Group theGroup) {
		super();
		this.theGroup = theGroup;
	}
	
	public Group getTheGroup() {
		return theGroup;
	}
	public void setTheGroup(Group theGroup) {
		this.theGroup = theGroup;
	}
	

	
}
