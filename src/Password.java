import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Password {
	
	private String password;
	// (!) private String encryptedPassword;
	private LocalDateTime accountCreationTime;
	
	//Constructor for Password
	public Password(String password) {
		
		if (password.length()>=8) { //check if the code is accepted
			this.password = password;
			this.accountCreationTime = LocalDateTime.now(); //takes the current time the object is to be created
		}
		else {
			String message = "Ο κωδικός είναι αδύναμος! Δοκιμάστε ένα πιο ισχυρό";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}

	
	
	public String getPassword() {
		return password;
	}

	public LocalDateTime getAccountCreationTime() {
		return accountCreationTime;
	}
	
}
