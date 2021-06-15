package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class Chief extends User implements Serializable{
	
	private ArrayList<Group> groupsSupervising = new ArrayList<Group>();
	
	
	//Constructor for Chief class
	public Chief(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	
	//This is a method that adds a Group object to the list of Groups that the Supervisor oversees.
	public void addGroupToSupervise(Group addingGroup)
	{
		groupsSupervising.add( addingGroup);
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
		
		for(Group supervisingGroup: groupsSupervising) {
			TreeSet<Post> supervisingGroupPosts = supervisingGroup.getGroupPosts();
			for (Post groupPost: supervisingGroupPosts) {
				postForBackEndProfile.add(groupPost); /*Addition of publications, which have as their scope 
														Group which are supervised by the specific Chief*/
			}
		}
		
		return postForBackEndProfile;
	}
	
	@Override //Users that are in the same Group with him and Friends of Friends
	public TreeSet<User> suggestedConnections() {
		// TODO Auto-generated method stub
		
		TreeSet<User> listWithSuggestedConnections = new TreeSet<User>(myUserComparator);
		
		for(User connectedUser: listOfConnections) {
			ArrayList<User> connectedUserConnections = connectedUser.getListOfConnections();
			for(User suggestedUser: connectedUserConnections) {
				Connection areAlreadyConnected = new Connection(this, suggestedUser);
				if (!areAlreadyConnected.areConnected() && !suggestedUser.equals(this))
					listWithSuggestedConnections.add(suggestedUser);
			}
		}
		
		//For users that are in the same Group with him
		for(Group myGroup: groupsSupervising) {
			for(Employee otherGroupMember: myGroup.getGroupMembers()) {
				Connection areAlreadyConnected = new Connection(this, otherGroupMember);
				if(!areAlreadyConnected.areConnected())
					listWithSuggestedConnections.add(otherGroupMember);
			}
		}
		
		
		//The Boss is suggested for everyone
		Connection connectedWithTheBoss = new Connection(this, this.getMyAccount().getMyCompany().getBoss());
		if (!connectedWithTheBoss.areConnected()) {
			listWithSuggestedConnections.add(this.getMyAccount().getMyCompany().getBoss()); //Adding Company Boss to the suggested list
		}
		
		return listWithSuggestedConnections;
	}
	
	public ArrayList<Group> getGroups() {
		return groupsSupervising;
	}

}
