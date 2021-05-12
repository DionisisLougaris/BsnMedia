import java.io.Serializable;
import java.util.*;

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
	protected TreeSet<Post> listOfPosts = new TreeSet<Post>(); //Εδω θα έχει μονο τα δικα του Post ή ολα οσα μπορει να δει
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>();
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
		
		TreeSet<Post> visitedUserAllPosts = visitedUser.returnAllPosts(); //List of Posts of the user who visited his public profile
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
	
	
	
	public TreeSet<Post> returnAllPosts() {
			return listOfPosts;
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
	
	
}
