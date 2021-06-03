package entities;

public class groupConversation extends Conversation{

	private Group theGroup; //The group for which the group chat corresponds

	
	
	public Group getTheGroup() {
		return theGroup;
	}
	public void setTheGroup(Group theGroup) {
		this.theGroup = theGroup;
	}
	
}
