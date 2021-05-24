import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		Password testPassword = new Password("bsnMedia!4322", "Minas", "Charakopoulos", "ics20072");
		
		String encryptedPassword = Encryption.encryptPassword(testPassword.getPassword(), testPassword.getAccountCreationTime().getSecond());
		System.out.println(encryptedPassword);
		testPassword.setPassword(encryptedPassword); //The field that holds the password is now stored encrypted
		System.out.println(Encryption.decryptPassword(testPassword.getPassword(), testPassword.getTimestamp().getSecond())); /*Recover the encrypted code, 
																															in normal format, possible for access control.*/	
	}
	
}

