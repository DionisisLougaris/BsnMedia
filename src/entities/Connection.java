package entities;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Connection extends Notification implements Serializable{

	private User firstUser;
	private User secondUser;
	
	
	//Constructor for Connection class
	public Connection(User firstUser, User secondUser) {
		this.firstUser = firstUser;
		this.secondUser = secondUser;
	}
	
	//Constructor for Connection as Notification
	public Connection(String notificationContent, User aboutThisUser) {
		super(notificationContent, aboutThisUser);
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
			
			String message = "You are no longer connected!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			String message = "You are not connected to each other!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//This is a method in which a connection request is sent to another user.
	public void sendConnectionRequest()
	{
		//firstUser, einai aytos pou esteile to aitima
		//secondUser einai autos pou to lamvanei
		
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
				secondUser.addPendingConnectionRequest(firstUser);
				Connection connectionRequest = new Connection(firstUser.firstName+"(New Connection Request)", firstUser);
				secondUser.listOfNotifications.add(connectionRequest);
				
				String message = "Successful connection request sent!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				String message = "There is already an outstanding connection request!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			String message = "You are already connected to each other!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//This is a method in which the connection request is accepted or is canceled.
	//firstUser, einai aytos pou esteile to aitima
	//secondUser einai autos pou to lamvanei
	public void manageConnectionRequest(boolean manageCR, Notification theRequestNotification)
	{
		if(manageCR)
		{
			if(!this.areConnected())
			{
				firstUser.getListOfConnections().add(secondUser);
				secondUser.getListOfConnections().add(firstUser);
				
				privateConversation newConversation = new privateConversation(firstUser, secondUser);
				firstUser.addConversation(newConversation);
				secondUser.addConversation(newConversation);
				//When two users log in, they need to have a chat of their own, and a file to be saved there
				File file = new File("Conversations/"+(firstUser.getMyAccount().getUsername()+"_"+(secondUser.getMyAccount().getUsername()+".txt")));
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String message = "Successful connection between you!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		}
		firstUser.getPendingConnectionRequests().remove(secondUser);
		secondUser.listOfNotifications.remove(theRequestNotification);
	}
	
	//This method returns the mutual connections between two users.
	public ArrayList<User>  mutualConnections ()
	{
		ArrayList<User> listOfMutualConnections = new ArrayList<User>();
		ArrayList<User> firstUserConnection = firstUser.getListOfConnections();
		ArrayList<User> secondUserConnection = secondUser.getListOfConnections();
		
		for (User firstConnection: firstUserConnection) {
			if (secondUserConnection.contains(firstConnection) && !listOfMutualConnections.contains(firstConnection)) {
				listOfMutualConnections.add(firstConnection);
			}
		}
		
	 return listOfMutualConnections;
	}
	
	
	
	public User getFirstUser() {
		return firstUser;
	}
	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
	}
	public User getSecondUser() {
		return secondUser;
	}
	public void setSecondUser(User secondUser) {
		this.secondUser = secondUser;
	}
	
}
