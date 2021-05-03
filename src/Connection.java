
public class Connection extends Notification{

	private User firstUser;
	private User secondUser;
	
	
	//Constructor for Connection class
	public Connection(String notificationContent, User firstUser, User secondUser) {
		super(notificationContent);
		this.firstUser = firstUser;
		this.secondUser = secondUser;
	}

}
