import java.util.*;
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
	public void changeCompanyPhoto(String photoUrl) {
		
	}
	
	
}
