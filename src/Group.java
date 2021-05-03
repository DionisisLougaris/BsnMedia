import java.util.*;

public class Group {
	
	private String name;
	private Project myProject;
	private int rating;
	private Chief supervisor;
	private ArrayList<Employee> groupMembers = new ArrayList<Employee>();
	private TreeSet<Post> groupPosts = new TreeSet<Post>();
	private groupConversation myConversation; //field for chatting between group members
	
	
	//Constructor for class "Group". The field "rating", will be updated via set only.
	public Group(String name, Project myProject, Chief supervisor) {
		this.name = name;
		this.myProject = myProject;
		this.supervisor = supervisor;
	}
	

	//Checks if a user is a member of the Group for which the method is called
	public boolean isMember(User theUser) {
		
		for(User groupMember: groupMembers) 
			if (groupMember.myAccount.getUsername().equalsIgnoreCase(theUser.myAccount.getUsername()))
				return true;
		return false;
	}
	
	
	//Added an employee to the list of Group employees
	public void addMember(Employee userToAdd) {
		
		groupMembers.add(userToAdd);
	}
	
	
	//Remove an employee from the Group's list of employees
	public void removeUserFromGroup(Employee userToRemove) {
		
		groupMembers.remove(userToRemove);
	}
	
	
	//Add a Post to the list of Posts addressed to the Group
	public void addPostToGroupList(Post postForGroup) {
		
		groupPosts.add(postForGroup);
	}
	
}
