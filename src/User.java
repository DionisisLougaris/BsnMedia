import java.util.ArrayList;

abstract public class User {
	
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected String email;
	protected String telephone;
	protected String address;
	protected String gender;
	protected String birthday;
	protected String companyPost;
	protected String image;
	protected ArrayList<User> listOfConnections = new ArrayList<User>();
	protected ArrayList<Post> listOfPosts = new ArrayList<Post>();
	protected Company myCompany;
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>();
	
	public User(String firstName, String lastName, String username, String password, String email, String telephone,
			String address, String gender, String birthday, String companyPost, String image, Company myCompany) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.gender = gender;
		this.birthday = birthday;
		this.companyPost = companyPost;
		this.image = image;
		this.myCompany = myCompany;
		
	}
	
	
}
