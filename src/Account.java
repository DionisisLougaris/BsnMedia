import javax.swing.JOptionPane;

public class Account {
	
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
	
	//This is a method that runs through the list of Users of the company checking whether everyone's email coincides with the potential email type String which is considered  as a parameter. Returns a reasonable value (boolean) depending on the availability or not of the email  that the user wishes to use.
	public boolean emailAvailability (String desiredEmail)
	{
		for(int i=0; i<myCompany.getCompanyMembers().size(); i++)
		{
			if(desiredEmail == email)
			{
				return true;
			}
		}
		return false;
	}
	
	//This is a method that allows or does not allow the User to access in Bsn Media. Initially it calls isCompanyMember () with the username given by the potential User as a parameter, it checks the password (It mediates the decryption of the password entered by the user, as the password is stored encrypted from the beginning). The user's backend Profile window on  network then opens. In case of any discrepancies in any of the identification steps, a message is displayed and entry is denied.
	public void loginAttempt (String typedUsername, String typedPassword)
	{
		if(myCompany.isCompanyMember(typedUsername) != null)
		{
			String decryptedPassword = Encryption.decryptPassword(myPassword.getPassword(), myPassword.getAccountCreationTime().getSecond() + 1);
			if(decryptedPassword == typedPassword)
			{
				new userBackendProfile();// prepei na mpei kai o user
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Failed Login",typedPassword , 0);
			}
			

	}
	
	
	}
	
}
