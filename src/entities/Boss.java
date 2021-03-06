package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Boss extends User implements Serializable{

    //Constructor for Boss class
	public Boss(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	
	//It is a method that modifies the fields that concern the elements of the company. No check is performed for correct data entry.
	public void changeVerificationCode (String potentialVerificationCode)
	{
		if(potentialVerificationCode.length()>=8 && !potentialVerificationCode.equals(myAccount.getMyCompany().getVerificationCode()))
		{
			myAccount.getMyCompany().setVerificationCode(potentialVerificationCode);
			
			String message = "Password updated successfully!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",JOptionPane.INFORMATION_MESSAGE);
		}
		else 
		{
			String message = "The password is weak or the same as the previous one";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/*This is a method by which the Company Manager is able to evaluate a Group for the performance 
	it had after the completion of the Project assigned to it.*/
	public void rateGroup(int rating, Group theGroup ) {
		
		if (theGroup.getMyProject().getStatus().equalsIgnoreCase("ongoing")) {
			String message = "The Group "+theGroup.getName()+" has not yet completed the Project "
					+ "it has undertaken. It is not possible to evaluate.";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			theGroup.setRating(rating); //Rate the Group
			//The process of updating those who are members of the Group follows
			String content = "The Group "+theGroup.getName()+" was rated";
			GeneralNotification rateGroupNotification = new GeneralNotification(content, theGroup, "Group rating");
			ArrayList<Employee> groupMembers = theGroup.getGroupMembers();
			
			for(Employee groupMember: groupMembers) {
				groupMember.listOfNotifications.add(rateGroupNotification); //add notification about the group rating
			}
			theGroup.getSupervisor().listOfNotifications.add(rateGroupNotification);
		}
	}
	
	
	//It is a method that modifies the fields that concern the elements of the company
	public void editCompanyInfo(String newName, String newInfo, String newTelephone, String newAddress, String newEmail) {
		
		boolean emptyFields = false;
		
		if (!newName.equalsIgnoreCase("")) {
			this.myAccount.getMyCompany().setName(newName);
		}else {
			emptyFields = true;
		}
		
		if (!newInfo.equals("")) {
			this.myAccount.getMyCompany().setInfo(newInfo);
		}else {
			emptyFields = true;
		}
		
		if (!newTelephone.equalsIgnoreCase("")) {
			this.myAccount.getMyCompany().setTelephone(newTelephone);
		}else {
			emptyFields = true;
		}
		
		if (!newAddress.equalsIgnoreCase("")) {
			this.myAccount.getMyCompany().setAddress(newAddress);
		}else {
			emptyFields = true;
		}
		
		if (!newEmail.equalsIgnoreCase("")) {
			this.myAccount.getMyCompany().setEmail(newEmail);
		}else {
			emptyFields = true;
		}
		
		if (!emptyFields) {
			String message = "All your business public information has been updated!"; 
			JOptionPane.showMessageDialog(new JFrame(), message, "Message", JOptionPane.INFORMATION_MESSAGE);
		}else {
			String message = "All information that was not empty was updated"; 
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",  JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public TreeSet<Post> returnAllPosts() {
		// TODO Auto-generated method stub
		
		TreeSet<Post> postForBackEndProfile = new TreeSet<Post>(myPostComp); //List of Posts that will appear in the User's Back-End Profile.
		
		for(Post hisPost: listOfPosts)
		{
			if(hisPost.getPostScope().equals("Connections"))
				postForBackEndProfile.add(hisPost); //Initially, his own are added.
		}
		for(User connectedUser: listOfConnections)
		{
			TreeSet<Post> friendsPosts = connectedUser.getListOfPosts();
			for(Post friendsPost: friendsPosts) 
				if (friendsPost.getPostScope().equalsIgnoreCase("Connections")) 
					postForBackEndProfile.add(friendsPost); //The Posts of connected users with whom he has the opportunity to see.
		}
		
		for(User otherCompanyMember: this.myAccount.getMyCompany().getCompanyMembers())
		{
			TreeSet<Post> otherUsersPosts = otherCompanyMember.getListOfPosts();
			for(Post otherUserPost: otherUsersPosts)
				if (otherUserPost.getPostScope().equalsIgnoreCase("Public"))
					postForBackEndProfile.add(otherUserPost); //Posts from members of the company that have a universal scope.
		}
		
		return postForBackEndProfile;
	}

	@Override //Friends of friends only
	public TreeSet<User> suggestedConnections() {
		// TODO Auto-generated method stub
		
		TreeSet<User> listWithSuggestedConnections = new TreeSet<User>(myUserComparator);
		
		for(User connectedUser: listOfConnections) {
			ArrayList<User> connectedUserConnections = connectedUser.getListOfConnections();
			for(User suggestedUser: connectedUserConnections) {
				Connection areAlreadyConnected = new Connection(this, suggestedUser);
				if (!areAlreadyConnected.areConnected() && !suggestedUser.equals(this)) {
					listWithSuggestedConnections.add(suggestedUser);
				}
			}
		}
		
		return listWithSuggestedConnections;
	}
	
	
	public ArrayList<Group> getGroups() {
		
		return null;
	}
	
}
