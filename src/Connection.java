
public class Connection extends Notification{

	private User firstUser;
	private User secondUser;
	
	
	//Constructor for Connection class
	public Connection(String notificationContent, User firstUser, User secondUser) {
		super(notificationContent);
		this.firstUser = firstUser;
		this.secondUser = secondUser;
	}
	
	//This is a method that checks if two users are connected to each other.
	private boolean areConnected() {
		
		if(firstUser.getListOfConnections().contains(secondUser) || secondUser.getListOfConnections().contains(firstUser))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//This is a method of deleting a connection between two users.
	public void removeConnection()
	{
		if(areConnected())
		{
			firstUser.getListOfConnections().remove(secondUser);
			secondUser.getListOfConnections().remove(firstUser);
		}
	}

	

}
