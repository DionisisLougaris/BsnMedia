package entities;

import java.io.Serializable;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

abstract public class User implements Serializable{
	
	protected String firstName;
	protected String lastName;
	protected String telephone;
	protected String address;
	protected String gender;
	protected String birthday;
	protected String companyPost;
	protected String image;
	protected Account myAccount;
	protected ArrayList<User> listOfConnections = new ArrayList<User>();
	protected TreeSet<Post> listOfPosts = new TreeSet<Post>(); //Only his Posts
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>(); //The pending requests he has sent to others
	protected TreeSet<Conversation> listOfConversations = new TreeSet<Conversation>();
	
	
	//Initial constructor for user
	public User(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.image = "";
		this.companyPost = companyPost;
		this.myAccount = myAccount;
	}
	
	
	/*Returns to the user who is logged in to his account all the posts 
	 * of another user whose public profile has been visited*/
	public TreeSet<Post> returnVisiblePosts(User visitedUser) {
		
		TreeSet<Post> visitedUserAllPosts = visitedUser.getListOfPosts(); //List of Posts of the user who visited his public profile
		TreeSet<Post> visiblePostsToBeReturned = new TreeSet<Post>();
		
		for (Post visitedUserPost: visitedUserAllPosts) {
			if(visitedUserPost.getPostScope().equalsIgnoreCase("public"))
				visiblePostsToBeReturned.add(visitedUserPost);
			else if(visitedUserPost.getPostScope().equalsIgnoreCase("friends")) {
				Connection areFriends = new Connection(this, visitedUser);
				if(areFriends.areConnected())
					visiblePostsToBeReturned.add(visitedUserPost);
			}
		}
		return visiblePostsToBeReturned;
	}
	
	
	/*This is a method that returns a TreeSet with all the posts that are visible to the logged in user. 
	 * Such posts are his own, his friends', from users who have set universal visibility in a Post, 
	 * as well as posts addressed to the Groups he is a member of.*/
	abstract public TreeSet<Post> returnAllPosts(); 
	
	
	/*Return notifications regarding the acceptance of a connection request from another user, 
	 * joining a group, a project that has been completed, as well as a Project that has been evaluated.*/
	public TreeSet<Notification> returnNotification() {
		
		TreeSet<Notification> generalNotifications = new TreeSet<Notification>();
		
		//Adds notifications that belong to the special category "General notifications"
		for(Notification myNotification: listOfNotifications) {
			if (myNotification instanceof GeneralNotification) {
				if(!(((GeneralNotification) myNotification).getTypeOfNotification().equalsIgnoreCase("connection request")))
					generalNotifications.add(myNotification);
			}
		}
		
		return generalNotifications;
	}
	
	
	//This is a method that returns a TreeSet with all connection requests to the user.
	public TreeSet<Notification> returnConnectionsRequest() {
		
		TreeSet<Notification> connectionsRequest = new TreeSet<Notification>();
		
		//Adds notifications that belong to the special category "Connections Request (Class Connection)"
		for(Notification myNotification: listOfNotifications) {
			if (myNotification instanceof Connection) 
					connectionsRequest.add(myNotification);
		}
		
		return connectionsRequest;
	}
	
	
	/*This is a method by which User has the ability to change the photo that appears his public Profile*/
	public void changeUsersPhoto(String photoPath) {
		
	}
	
	
	//This is a method that modifies the user's public information.
	public boolean editPublicInfo(String firstName, String lastName, String email, String telephone,
					String address, String speciality, String gender, String birthday) {
		
		//Fields that do not require some checks will change directly
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.companyPost = speciality;
		this.gender = gender;
		this.birthday = birthday;
		
		//Field that requires control
		if(this.myAccount.emailAvailability(email)) {
			this.myAccount.setEmail(email); //The email is updated
			return true; //True: It appears from Gui that all the algae were okay
		}
		else
			return false; /*False: The new email was not available. 
					Informs with false so that the field in Gui is empty, and blushes so that the user knows what went wrong*/
	}
	
	
	//This is a method that modifies the user's private information.
	public boolean editPrivateInfo(String username, String currPassword, String newPassword, String confirmedPassword) {
		
		boolean changeUsername = true;
		
		//To change Username
		if (!username.equalsIgnoreCase(this.myAccount.getUsername())) { //Check if JTextField has been modified
			
			ArrayList<User> allCompanyMembers = this.myAccount.getMyCompany().getCompanyMembers();
			
			for(User companyMember: allCompanyMembers) {
				if (username.equalsIgnoreCase(companyMember.myAccount.getUsername()))
						changeUsername = false; //The username he chose is not available
			}
			if (changeUsername == true)
				this.myAccount.setUsername(username);
			/*else { (Θα δουμε που βολευει να μπει η ειδοποιηση)
				String message = "The new username he chose is not available!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}*/
		}
		else {
			changeUsername = false;
		}
		
		//To change Password (If everything is blank, it means that the user does not want to change the password)
		if (!currPassword.equalsIgnoreCase("") || !newPassword.equalsIgnoreCase("") || !confirmedPassword.equalsIgnoreCase("")) {
			this.myAccount.getMyPassword().changePassword(currPassword, newPassword, confirmedPassword, this);
		}
		
		/*True or false: This way we will know how to display the changes in the GUI and how to notify the user*/
		if (changeUsername)
			return true; //Username changed and changes accepted
		else
			return false; //Username was not changed or changes were accepted
	}
	
	
	//This is a method that calculates and returns a list of suggested connections for a user.
	abstract public TreeSet<User> suggestedConnections();
	
	
	//This is a method that removes a User item from the list of requests sent by the logged in user.
	public void cancelPendingRequest(User requestToThisUser) {
		
		//The request is deleted and therefore removed from the list of requests sent by the user.
		if (pendingConnectionRequests.contains(requestToThisUser)) {
			requestToThisUser.pendingConnectionRequests.remove(this);
			
			/*The notification must now be removed from the user who get the connection request.*/
			for(Notification currNotification: this.listOfNotifications) {
				if (currNotification instanceof Connection) {
					if (currNotification.getAboutThisUser().getMyAccount().getUsername().equalsIgnoreCase(requestToThisUser.myAccount.getUsername()))
						this.listOfNotifications.remove(currNotification);
				}
			}
		}
		else {
			String message = "There is no pending connection request for this User!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	
	/*This is a method that examines whether the user logged in to the account 
	has chatted with the user or the group he searched for. */
	public Conversation searchConversation(String searchedConversation) {
		
		Conversation correctConversation = null;
		
		for(Conversation currConversation: listOfConversations) {
			if (currConversation instanceof privateConversation) {
				if (searchedConversation.equalsIgnoreCase(((privateConversation) currConversation).getDiscussant1().getFirstName())
						|| searchedConversation.equalsIgnoreCase(((privateConversation) currConversation).getDiscussant1().getLastName())
						|| searchedConversation.equalsIgnoreCase(((privateConversation) currConversation).getDiscussant2().getFirstName())
						|| searchedConversation.equalsIgnoreCase(((privateConversation) currConversation).getDiscussant2().getLastName())) {
					correctConversation = currConversation;
					break;
				}
			}
			else if(currConversation instanceof groupConversation){
				if(searchedConversation.equalsIgnoreCase(((groupConversation) currConversation).getTheGroup().getName())) {
					correctConversation = currConversation;
					break;
				}
			}
		}
		
		return correctConversation;	//If it returns null, then the appropriate notification will appear from Gui.
	}
	
	
	/*This is a method that adds a post to the list of user-maintained posts.*/
	public void addPost(Post thePost) {
		listOfPosts.add(thePost);
	}

	
	
	//*********************************************************************************************************************
	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCompanyPost() {
		return companyPost;
	}

	public void setCompanyPost(String companyPost) {
		this.companyPost = companyPost;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Account getMyAccount() {
		return myAccount;
	}

	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public ArrayList<User> getListOfConnections() {
		return listOfConnections;
	}

	public void setListOfConnections(ArrayList<User> listOfConnections) {
		this.listOfConnections = listOfConnections;
	}

	public void setListOfPosts(TreeSet<Post> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	public ArrayList<Notification> getListOfNotifications() {
		return listOfNotifications;
	}

	public void setListOfNotifications(ArrayList<Notification> listOfNotifications) {
		this.listOfNotifications = listOfNotifications;
	}

	public ArrayList<User> getPendingConnectionRequests() {
		return pendingConnectionRequests;
	}

	public void setPendingConnectionRequests(ArrayList<User> pendingConnectionRequests) {
		this.pendingConnectionRequests = pendingConnectionRequests;
	}

	public TreeSet<Conversation> getListOfConversations() {
		return listOfConversations;
	}

	public void setListOfConversations(TreeSet<Conversation> listOfConversations) {
		this.listOfConversations = listOfConversations;
	}

	public void addPendingConnectionRequest(User user) {
		pendingConnectionRequests.add(user);
	}

	public TreeSet<Post> getListOfPosts() {
		return listOfPosts;
	}
	
	abstract public ArrayList<Group> getGroups();
		
}
