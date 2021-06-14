package entities;

import java.io.Serializable;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Employee extends User implements Serializable{

	private static final int limitOfGroups = 3; //The limit of Groups in which the employee can be a member at the same time.
	
	private ArrayList<Group> listOfGroups = new ArrayList<Group>();
	
	
	//Constructor for Employee class
	public Employee(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}


	@Override
	public TreeSet<Post> returnAllPosts() {
		// TODO Auto-generated method stub
		
		TreeSet<Post> postForBackEndProfile = new TreeSet<Post>(myPostComp); //List of Posts that will appear in the User's Back-End Profile
		
		for(Post hisPost: listOfPosts) 
		{
			if(hisPost.getPostScope().equals("Connections"))
				postForBackEndProfile.add(hisPost); //Initially, his own are added
		}
		for(User connectedUser: listOfConnections) {
			TreeSet<Post> friendsPosts = connectedUser.getListOfPosts();
			for(Post friendsPost: friendsPosts) 
				if (friendsPost.getPostScope().equalsIgnoreCase("friends")) 
					postForBackEndProfile.add(friendsPost); //The Posts of connected users with whom he has the opportunity to see
		}
		
		for(User otherCompanyMember: this.myAccount.getMyCompany().getCompanyMembers()) {
			TreeSet<Post> otherUsersPosts = otherCompanyMember.getListOfPosts();
			for(Post otherUserPost: otherUsersPosts)
				if (otherUserPost.getPostScope().equalsIgnoreCase("public"))
					postForBackEndProfile.add(otherUserPost); //Posts from members of the company that have a universal scope
		}
		
		for(Group myGroup: listOfGroups) {
			TreeSet<Post> myGroupPosts = myGroup.getGroupPosts();
			for(Post groupPost: myGroupPosts)
				postForBackEndProfile.add(groupPost); /*Addition of post, which have as their scope Group in which the 
														specific Employee is a member*/
		}
		
		return postForBackEndProfile;
	}


	@Override//Users that are in the same Group with him and Friends of Friends
	public TreeSet<User> suggestedConnections() {
		// TODO Auto-generated method stub
		
		TreeSet<User> listWithSuggestedConnections = new TreeSet<User>(myUserComparator);
		
		//Connections of this Connections if he isn't already connected
		for(User connectedUser: listOfConnections) {
			ArrayList<User> connectedUserConnections = connectedUser.getListOfConnections();
			for(User suggestedUser: connectedUserConnections) {
				Connection areAlreadyConnected = new Connection(this, suggestedUser);
				if (!areAlreadyConnected.areConnected() && !suggestedUser.equals(this))
					listWithSuggestedConnections.add(suggestedUser);
			}
		}
		
		//For users that are in the same Group with him
		for(Group myGroup: listOfGroups) {
			for(Employee otherGroupMember: myGroup.getGroupMembers()) {
				Connection areAlreadyConnected = new Connection(this, otherGroupMember);
				if(!areAlreadyConnected.areConnected() && !otherGroupMember.equals(this))
					listWithSuggestedConnections.add(otherGroupMember);
			}
			Connection areAlreadyConnected = new Connection(this, myGroup.getSupervisor());
			if (!areAlreadyConnected.areConnected()) 
				listWithSuggestedConnections.add(myGroup.getSupervisor()); //Add Group chief if they are not connected already
		}
		
		//The Boss is suggested for everyone
		Connection connectedWithTheBoss = new Connection(this, this.getMyAccount().getMyCompany().getBoss());
		if (!connectedWithTheBoss.areConnected()) {
			listWithSuggestedConnections.add(this.getMyAccount().getMyCompany().getBoss()); //Adding Company Boss to the suggested list
		}
		
		return listWithSuggestedConnections;
	}

	
	//This is a method that deletes a Group object from the list of Groups it is a member of.
	public void RemoveGroupFromUsersList(Group theGroup) {
		
		//There is a two-way deletion.
		listOfGroups.remove(theGroup);
		theGroup.removeUserFromGroup(this);
	}
	
	
	//This is a method that adds a Group item to the list of Groups that the employee is a member of
	public void addGroupToEmployeesList(Group theGroup) {
		
		if (listOfGroups.size() < limitOfGroups) {
			if (!theGroup.isMember(this)) {
				listOfGroups.add(theGroup);
				theGroup.addMember(this);
				//Creating and sending notification to Members
				GeneralNotification genNot = new GeneralNotification("You have been added to "+theGroup.getName(),theGroup,"addedToGroup");
				this.listOfNotifications.add(genNot);
			}
			else {
				String message = "The employee "+this.getFirstName()+" "+this.getLastName()+" is already member!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			String message = "The employee "+this.getFirstName()+" "+this.getLastName()+" has reached the limit of "+limitOfGroups+" Groups!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public ArrayList<Group> getGroups() {
		return listOfGroups;
	}

}
