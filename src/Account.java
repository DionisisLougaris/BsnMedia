
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

}
