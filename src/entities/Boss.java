package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class Boss extends User{

	
	//Constructr for Boss class
	public Boss(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	
	//It is a method that modifies the fields that concern the elements of the company. No check is performed for correct data entry.
	public void changeVerificationCode (String potentialVerificationCode)
	{
		if(potentialVerificationCode.length()>=16 && !potentialVerificationCode.equals(myAccount.getMyCompany().getVerificationCode()))
		{
			myAccount.getMyCompany().setVerificationCode(potentialVerificationCode);
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
		
		this.myAccount.getMyCompany().setName(newName);
		this.myAccount.getMyCompany().setInfo(newInfo);
		this.myAccount.getMyCompany().setTelephone(newTelephone);
		this.myAccount.getMyCompany().setAddress(newAddress);
		this.myAccount.getMyCompany().setEmail(newEmail);
		String message = "Your business public information has been updated!";
		JOptionPane.showMessageDialog(new JFrame(), message, "Message",
		        JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/*This is a method by which Boss has the ability to change the photo that appears on the 
	public profile of the Company hosted on Bsn Media*/
	public void changeCompanyPhoto(String photoUrl) throws IOException {
		
			
			if(photoUrl != " ")
			{
				
			     BufferedImage companyimage = ImageIO.read(new File(photoUrl));
				 int height = companyimage.getHeight();
				 int width = companyimage.getWidth();
				 File imageofcompany; 
				 if(height>60 && width>80)
				 {
					 ImageIcon imagec = new ImageIcon(companyimage);
					 Image imagerisize = imagec.getImage().getScaledInstance(50, 40, 70) ;
					 
					imagec.setImage(imagerisize);
					 imageofcompany = new File("companyimage.png");
	                 ImageIO.write((RenderedImage) imagerisize, "png", imageofcompany) ;
				}
				 myAccount.getMyCompany().setImage("companyimage.png");
				 
			}
			
		
	}

	
	@Override
	public TreeSet<Post> returnAllPosts() {
		// TODO Auto-generated method stub
		
		TreeSet<Post> postForBackEndProfile = new TreeSet<Post>(); //List of Posts that will appear in the User's Back-End Profile
		
		for(Post hisPost: listOfPosts) 
			postForBackEndProfile.add(hisPost); //Initially, his own are added
		
		for(User connectedUser: listOfConnections) {
			TreeSet<Post> friendsPosts = connectedUser.getListOfPosts();
			for(Post friendsPost: friendsPosts) 
				if (friendsPost.getPostScope().equalsIgnoreCase("friends")) 
					postForBackEndProfile.add(friendsPost); //The Posts of connected users with whom he has the opportunity to see
		}
		
		for(User otherCompanyMember: this.myAccount.getMyCompany().getCompanyMembers()) {
			TreeSet<Post> otherUsersPosts = otherCompanyMember.getListOfPosts();
			for(Post otherUserPost: otherUsersPosts)
				if (otherUserPost.getPostScope().equalsIgnoreCase("public"))
					postForBackEndProfile.add(otherUserPost); //Posts from members of the company that have a universal scope
		}
		
		return postForBackEndProfile;
	}

	@Override //Friends of friends only
	public TreeSet<User> suggestedConnections() {
		// TODO Auto-generated method stub
		
		TreeSet<User> listWithSuggestedConnections = new TreeSet<User>();
		
		for(User connectedUser: listOfConnections) {
			ArrayList<User> connectedUserConnections = connectedUser.getListOfConnections();
			for(User suggestedUser: connectedUserConnections) {
				Connection areAlreadyConnected = new Connection(this, suggestedUser);
				if (!areAlreadyConnected.areConnected())
					listWithSuggestedConnections.add(suggestedUser);
			}
		}
		
		return listWithSuggestedConnections;
	}
	
	// o boss den exei na kanei kati me ta group den kserw ti na kanw me auth thn methodo
	public ArrayList<Group> getGroups() {
		return null;
	}
	
	
}
