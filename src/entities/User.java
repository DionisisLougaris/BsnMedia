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
    protected postComparator myPostComp = new postComparator();
	protected TreeSet<Post> listOfPosts = new TreeSet<Post>(myPostComp); //Only his Posts
	protected NotificationsComparator myNotificationComp = new NotificationsComparator();
	protected UserComparator myUserComparator = new UserComparator();
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>(); //The pending requests he has sent to others
	protected ArrayList<Conversation> listOfConversations = new ArrayList<Conversation>();
	
	//Initial constructor for user.
	public User(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.image = "default photo/defaultProfilePhoto.png";
		this.companyPost = companyPost;
		this.myAccount = myAccount;
	}
	
	/*Returns to the user who is logged in to his account all the posts 
	 * of another user whose public profile has been visited.*/
	public TreeSet<Post> returnVisiblePosts(User visitedUser) {
		
		TreeSet<Post> visitedUserAllPosts = visitedUser.getListOfPosts(); //List of Posts of the user who visited his public profile.
		TreeSet<Post> visiblePostsToBeReturned = new TreeSet<Post>(myPostComp);
		
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
		
		TreeSet<Notification> generalNotifications = new TreeSet<Notification>(myNotificationComp);
		
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
		
		TreeSet<Notification> connectionsRequest = new TreeSet<Notification>(myNotificationComp);
		
		//Adds notifications that belong to the special category "Connections Request (Class Connection)"
		for(Notification myNotification: listOfNotifications) {
			if (myNotification instanceof Connection) 
					connectionsRequest.add(myNotification);
		}
		
		return connectionsRequest;
	}
	
	
	//This is a method that modifies the user's public information.
	public boolean editPublicInfo(String firstName, String lastName, String email, String telephone,
					String address, String speciality, String gender, String birthday) {
		
		boolean everythingChanged = true;
		//Fields that do not require some checks will change directly
		//Checking to see if there is a change in every single field to not overwrite the information with empty fields
		if(!firstName.isEmpty()) {
			this.firstName = firstName;
		}else {
			everythingChanged = false;
		}
		
		if(!lastName.isEmpty()) {
			this.lastName = lastName;
		}else {
			everythingChanged = false;
		}
		
		if(!telephone.isEmpty()) {
			this.telephone = telephone;
		}else {
			everythingChanged = false;
		}
		
		if(!address.isEmpty()) {
			this.address = address;
		}else {
			everythingChanged = false;
		}
		
		if(!speciality.isEmpty()) {
			this.companyPost = speciality;
		}else {
			everythingChanged = false;
		}
		
		if(!gender.isEmpty()) {
			this.gender = gender;
		}else {
			everythingChanged = false;
		}
		
		if(!birthday.isEmpty()) {
			this.birthday = birthday;
		}else {
			everythingChanged = false;
		}
		
		//Field that requires control
		if((this.myAccount.emailAvailability(email) && !email.isEmpty()) || email.equalsIgnoreCase(this.getMyAccount().getEmail())) {
			this.myAccount.setEmail(email); //The email is updated
		}else {
			everythingChanged = false;
		}
		
		return everythingChanged;
	}
	
	
	//This is a method that modifies the user's private information.
	public void editPrivateInfo(String currPassword, String newPassword, String confirmedPassword) {
		
		//To change Password (If everything is blank, it means that the user does not want to change the password)
		if (!currPassword.equals("") || !newPassword.equals("") || !confirmedPassword.equals("")) 
			this.myAccount.getMyPassword().changePassword(currPassword, newPassword, confirmedPassword, this);
		else {
			String message = "You must fill in the fields for the codes!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
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
	
	public void addConversation(Conversation theConvo) {
		listOfConversations.add(theConvo);
	}

	//*************** Getters and Setters *************
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

	public ArrayList<Conversation> getListOfConversations() {
		return listOfConversations;
	}

	public void setListOfConversations(ArrayList<Conversation> listOfConversations) {
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
class NotificationsComparator implements Comparator<Notification>, Serializable {

	@Override
	public int compare(Notification o1, Notification o2) {
		
		if (o1.getTimestamp().isBefore(o2.getTimestamp()))
			return 1;
		else 
			return -1;
	 }
}

class UserComparator implements Comparator<User>, Serializable {

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
}
