import java.io.Serializable;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Password implements Serializable
{
	
	private String password;
	private LocalDateTime timestamp;
	
	//Constructor for Password
	public Password(String password, String username, String firstName, String lastName) {
		//The fields username, firstName and lastName are usefull for the password strength
		//check if the code is accepted
		if (password.length()>=8 && !password.equalsIgnoreCase(username) 
								 && !password.equalsIgnoreCase(firstName)
								 && !password.equalsIgnoreCase(lastName)) { 
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
	
	
	//This is a method that allows the user to save the saved password
	public void newPassword(String newPass, String confirmedPass, User theUser) {
		
		if (newPass.length()>=8 && !newPass.equalsIgnoreCase(theUser.firstName)
								&& !newPass.equalsIgnoreCase(theUser.myAccount.getUsername())
								&& !newPass.equalsIgnoreCase(theUser.lastName)) {
			if (newPass.equalsIgnoreCase(confirmedPass)) {
				//Εδω θα κληθει μεθοδος για κρυπρογραφιση του καινουργιου κωδικού
				this.password = newPass; //the code is updated
				String message = "The code has updated succesfully";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String message = "The code and the confirmed code are not the same!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			String message = "Password is weak! Try a stronger one";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	//This is a method through which the user can change his password provided he knows his current one.
	public void changePassword(String currentPass, String newPass, String comfirmedNewPass, User theUser) {
		
		//Θα κληθει μεθοδος για αποκρυπτογραφιση του τωρινου κωδικου
		if (currentPass.equalsIgnoreCase(this.password)) 
			this.newPassword(newPass, comfirmedNewPass, theUser);
		else {
			String message = "The current password you entered is incorrect!";
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
