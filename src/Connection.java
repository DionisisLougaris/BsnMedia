import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Connection extends Notification{

	private User firstUser;
	private User secondUser;
	
	
	//Constructor for Connection class
	public Connection(User firstUser, User secondUser) {
		this.firstUser = firstUser;
		this.secondUser = secondUser;
	}
	
	
	//This is a method that checks if two users are connected to each other.
	public boolean areConnected() {
		
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
	
	//This is a method in which a connection request is sent to another user.
	public void  sendConnectionRequest()
	{
		boolean pendingConnectionRequest = false;
		if(!areConnected())
		{
			for(int i=0; i<secondUser.getPendingConnectionRequests().size(); i++)
			{
				if(firstUser == secondUser.getPendingConnectionRequests().get(i))
				{
					pendingConnectionRequest = true;
					break;
				}
			}
			if(!pendingConnectionRequest)
			{
				firstUser.addPendingConnectionRequest(secondUser);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Failed to pending connection request because the request all ready be pended. ");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Failed to pending connection request because you are all ready connected. ");
		}
	}
	
	//This is a method in which the connection request is accepted or is canceled.
	public void manageConnectionRequest(boolean manageCR)
	{
		if(manageCR)
		{
			if(!areConnected())
			{
				firstUser.getListOfConnections().add(secondUser);
				secondUser.getListOfConnections().add(firstUser);
			}
		}
		else
		{
			firstUser.getPendingConnectionRequests().remove(secondUser);
			firstUser.getListOfNotifications(); // diagrafh toy notification
		}
	}
	
	
	

}
