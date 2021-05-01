import java.util.ArrayList;

 abstract public class User {
	
	protected ArrayList<User> listOfConnections = new ArrayList<User>();
	protected ArrayList<Post> listOfPosts = new ArrayList<Post>();
	protected ArrayList<Notification> listOfNotifications = new ArrayList<Notification>();
	protected ArrayList<User> pendingConnectionRequests = new ArrayList<User>();
			
}
