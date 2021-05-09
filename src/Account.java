import java.io.Serializable;

import javax.swing.JOptionPane;

public class Account implements Serializable{
	
	private String username;
	private String email;
	private Password myPassword;
	private Company myCompany;
	
	
	//Constructor for Account
	public Account(String username, String email, Company myCompany, Password myPassword) {
		
		this.username = username;
		this.email = email;
		this.myCompany = myCompany;
		this.myPassword = myPassword;
	}
	
	
	
	/*This is a method that runs through the list of Users of the company checking whether everyone's email coincides with the potential email type String which is considered  
	 as a parameter. Returns a reasonable value (boolean).*/
	public boolean emailAvailability (String desiredEmail)
	{
		for(int i=0; i<myCompany.getCompanyMembers().size(); i++)
		{
			if(desiredEmail.equalsIgnoreCase(email))
			{
				return true;
			}
		}
		return false;
	}
	
	/*This is a method that allows or does not allow the User to access in Bsn Media. If all checks are finished without 
	any error the user's backend Profile window on  network  opens.*/ 
	public void loginAttempt (String inputUsername, String inputPassword)
	{
		if(myCompany.isCompanyMember(inputUsername) != null)
		{
			String decryptedPassword = Encryption.decryptPassword(myPassword.getPassword(), myPassword.getAccountCreationTime().getSecond() + 1);
			if(decryptedPassword.equals(inputPassword) )
			{
				// prepei me instance of the doume pio apo ta 3 gui xrhstwn tha anoiksoume
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Failed Login",inputPassword , 0);
			}
			

	      }
	
	
	}
	
	/*This is a method that changes or not a user's password in case he has forgotten the previous one.
	 If all checks are finished without any error the creators of application sends email to user.*/
	public User forgotPassword (String inputUsername, String inputEmail, String desiredPassword)
	{
	  if(myCompany.isCompanyMember(inputUsername) != null)
		{
			if(!emailAvailability(inputEmail))
			{
				for(int i=0; i<myCompany.getCompanyMembers().size(); i++)
				{
						if(inputEmail.equalsIgnoreCase(myCompany.getCompanyMembers().get(i).getMyAccount().getEmail()))
						{
							User user = myCompany.getCompanyMembers().get(i);
							Help.sendGmail("itintelligenceuom@gmail.com",email, myPassword.getPassword(),"Verification code");
							return user;
						}
				}
			}
		}
		return null;
	}
	

	//This is a method that deletes the user account.
	public void deleteAccount(String inputPassword , String confirmedPassword, User deletedUser)
	{
		String decryptPassword = Encryption.decryptPassword(myPassword.getPassword(), myPassword.getAccountCreationTime().getSecond() + 1);
		if(decryptPassword.equals(inputPassword)   && inputPassword.equals(confirmedPassword) )
		{
			
			myCompany.getCompanyMembers().remove(deletedUser);
		}
		else
		{
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
