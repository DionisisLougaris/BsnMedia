import java.util.*;

public class Employee extends User{

	private ArrayList<Group> listOfGroups = new ArrayList<Group>();
	
	
	//Constructor for Employee class
	public Employee(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}


	@Override
	public TreeSet<Post> returnAllPosts() {
		// TODO Auto-generated method stub
		
		TreeSet<Post> postForBackEndProfile = new TreeSet<Post>(); //List of Posts that will appear in the User's Back-End Profile
		
		for(Post hisPost: listOfPosts) 
			postForBackEndProfile.add(hisPost); //Initially, his own are added
		
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
		
		TreeSet<User> listWithSuggestedConnections = new TreeSet<User>();
		
		for(User connectedUser: listOfConnections) {
			ArrayList<User> connectedUserConnections = connectedUser.getListOfConnections();
			for(User suggestedUser: connectedUserConnections) {
				Connection areAlreadyConnected = new Connection(this, suggestedUser);
				if (!areAlreadyConnected.areConnected())
					listWithSuggestedConnections.add(suggestedUser);
			}
		}
		
		//For users that are in the same Group with him
		for(Group myGroup: listOfGroups) {
			for(Employee otherGroupMember: myGroup.getGroupMembers()) {
				Connection areAlreadyConnected = new Connection(this, otherGroupMember);
				if(!areAlreadyConnected.areConnected())
					listWithSuggestedConnections.add(otherGroupMember);
			}
			Connection areAlreadyConnected = new Connection(this, myGroup.getSupervisor());
			if (!areAlreadyConnected.areConnected()) 
				listWithSuggestedConnections.add(myGroup.getSupervisor()); //Add Group chief if they are not connected already
		}
		
		return listWithSuggestedConnections;
	}


	


}
