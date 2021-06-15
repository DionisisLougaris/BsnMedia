package entities;

import java.io.File;
import java.io.Serializable;

public class groupConversation extends Conversation implements Serializable{

	private Group theGroup; //The group for which the group chat corresponds

	
	
	public Group getTheGroup() {
		return theGroup;
	}
	public void setTheGroup(Group theGroup) {
		this.theGroup = theGroup;
	}
	
	public void addMessage(Message aMessage) {
		
		Storage.saveMessage(aMessage, this);
	}
	
	
}
