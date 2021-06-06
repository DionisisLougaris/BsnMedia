package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Account implements Serializable{
	
	private String username;
	private String email;
	private Password myPassword;
	private Company myCompany; 
	
	
	//Constructor for Account
	public Account(String username, String email, Company myCompany, Password myPassword) {
		/*A prerequisite for the creation of the object is the email and the Username that 
		 * will be given not to be used already, for this reason the following checks also occur.*/
		this.myCompany = myCompany;
		if(this.emailAvailability(email)){//Check if email is used
			if (myCompany.isCompanyMember(username)==null) { //Check if username is used
				this.username = username;
				this.email = email;
				this.myPassword = myPassword;
			}
			else {
				String message = "The username you selected is already in use!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			String message = "The email you selected is already in use!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//Constructor for Account Recovery
	public Account(String username, String Email, Company myCompany) {
		
		this.myCompany = myCompany;
		this.username = username;
		this.email = Email;
	}
	
	
	/*This is a method that goes through the list of Users of the company checking if everyone's email 
	 * coincides with the potential email of type String that is taken as a parameter. 
	 * Returns a reasonable value (boolean)*/
	public boolean emailAvailability (String desiredEmail) {
		
		ArrayList<User> companyMembers = myCompany.getCompanyMembers();
		for(User companyMember: companyMembers) {
			if (companyMember.myAccount.getEmail().equalsIgnoreCase(desiredEmail))
				return false;
		}
		return true;
	}
	
	
	/*This is a method that changes or not a user's password in case he has forgotten the previous one.
	 If all checks are finished without any error the creators of application sends email to user.*/
	public User forgotPassword (String inputUsername, String inputEmail, String textForEmailBody) {
		
	  String [] recievers = new String[1];
	  recievers[0] = inputEmail;
	  
	  if( this.myCompany.isCompanyMember(inputUsername) != null)
		{
			if(!emailAvailability(inputEmail))
			{
				for(int i=0; i<myCompany.getCompanyMembers().size(); i++)
				{
						if(inputEmail.equalsIgnoreCase(myCompany.getCompanyMembers().get(i).getMyAccount().getEmail()))
						{
							User user = myCompany.getCompanyMembers().get(i);
							Help.sendGMail("itintelligenceuom@gmail.com", "ITintelligence2001", recievers, "Account Recovery", textForEmailBody);
							return user;
						}
				}
			}
		}
		return null;
	}
	

	//This is a method that deletes the user account.
	public void deleteAccount(String inputPassword , String confirmedPassword, User deletedUser) {
		
		//The stored code must first be decrypted to verify that there is a correct match.
		String decryptedSoredPassword = Encryption.decryptPassword(this.myPassword.getPassword(), this.myPassword.getTimestamp().getSecond());
		if(decryptedSoredPassword.equals(inputPassword) && inputPassword.equals(confirmedPassword)) {
			
			myCompany.getCompanyMembers().remove(deletedUser);
		}
		else {
			JOptionPane.showMessageDialog(null, "Failed to delete User",deletedUser.getLastName() , 0);
		}
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Password getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(Password myPassword) {
		this.myPassword = myPassword;
	}


	public Company getMyCompany() {
		return myCompany;
	}


	public void setMyCompany(Company myCompany) {
		this.myCompany = myCompany;
	}
	
	
}
