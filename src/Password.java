import java.io.Serializable;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Password implements Serializable
{
	
	private String password;
	private LocalDateTime timestamp;
	
	//Constructor for Password
	public Password(String password) {
		
		if (password.length()>=8) { //check if the code is accepted
			//Πριν οριστει τιμη στο πεδιο, θα μεσολαβει η κρυπτοφραφιση του κωδικου
			this.password = password;
			this.timestamp = LocalDateTime.now(); //takes the current time the object is to be created
		}
		else {
			String message = "Password is weak! Try a stronger one";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}

	
	
	public String getPassword() {
		return password;
	}

	public LocalDateTime getAccountCreationTime() {
		return timestamp;
	}
	
	
	
	
}
