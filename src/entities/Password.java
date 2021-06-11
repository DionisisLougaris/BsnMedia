package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Password implements Serializable
{
	
	private String password; //The password stored encrypted
	private LocalDateTime timestamp;
	
	//Constructor for Password
	public Password(String password, String username, String firstName, String lastName) {
		//The fields username, firstName and lastName are usefull for the password strength
		//check if the code is accepted
		if (password.length()>=8 && !password.equalsIgnoreCase(username) 
								 && !password.equalsIgnoreCase(firstName)
								 && !password.equalsIgnoreCase(lastName)) { 
			this.timestamp = LocalDateTime.now(); //takes the current time the object is to be created
			//The password is stored encrypted
			this.password = Encryption.encryptPassword(password, timestamp.getSecond());
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
			if (newPass.equals(confirmedPass)) {
				//The new password is stored encrypted
				this.password = Encryption.encryptPassword(newPass, timestamp.getSecond());
				String message = "The code has updated succesfully";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.INFORMATION_MESSAGE);
				System.out.println("fdsfsd: "+newPass);
			}
			else {
				String message = "The code and the confirmed code are not the same!";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",
				        JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			String message = "Password is weak! Try a stronger one";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//This is a method through which the user can change his password provided he knows his current one.
	public void changePassword(String currentPass, String newPass, String comfirmedNewPass, User theUser) {
		
		String decryptedStoredPassword = Encryption.decryptPassword(password, timestamp.getSecond());
		if (currentPass.equals(decryptedStoredPassword)) 
			theUser.getMyAccount().getMyPassword().newPassword(newPass, comfirmedNewPass, theUser);
		else {
			String message = "The current password you entered is incorrect!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
	public String getPassword() {
		return password;
	}
	public LocalDateTime getAccountCreationTime() {
		return timestamp;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
