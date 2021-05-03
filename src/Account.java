
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
	
}
