import java.util.*;

abstract public class User {
	
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
	protected ArrayList<Post> listOfPosts = new ArrayList<Post>();
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>();
	protected TreeSet<Conversation> listOfConversations = new TreeSet<Conversation>();
	
	//Complete constructor for user
	public User(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, String image, Account myAccount) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.companyPost = companyPost;
		this.image = image;
		this.myAccount = myAccount;
	}
	
	//Simplified constructor of user
	public User(String firstName, String lastName, String birthday, String companyPost, Account myAccount) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.companyPost = companyPost;
		this.myAccount = myAccount;
	}
	
	
	
}
