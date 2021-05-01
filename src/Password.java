import java.time.LocalDateTime;

public class Password {
	
	private String password;
	// (!) private String encryptedPassword;
	private LocalDateTime accountCreationTime;
	
	//Constructor for Password
	public Password(String password, LocalDateTime accountCreationTime) {
		
		this.password= password;
		this.accountCreationTime = accountCreationTime;
		
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getAccountCreationTime() {
		return accountCreationTime;
	}
	
	

}
