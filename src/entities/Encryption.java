package entities;

public class Encryption {
	

	//Message encryption algorithm
	public static String encryptMessage(String originalMessage, int key) {
		   
		String encrypted = ""; //The encrypted message to be saved
	       
		for (int i = 0; i < originalMessage.length(); i++) {
	    	   
			int c = originalMessage.charAt(i) + key; //We modify each character of the alphanumeric
	           
			if (c > 126) {
				c -= 95; //If the ascii table maximum is exceeded
			} 
			else if (c < 32) {
				c += 95; //If it is less than the allowable limit of the ASCII table
			}
			encrypted += (char) c;
		}
		return encrypted;
	}

	 
	//Method of decrypting an encrypted message
	public static String decryptMessage(String encryptedMessage, int shift) {
		   
		return encryptMessage(encryptedMessage, -shift);  //The method of encryption is called with the parameter of the encrypted message and the reverse of the key used for encryption
	}
	   
	      
	//Password encryption algorithm
	public static String encryptPassword(String originalPassword, int key) {
		
		String encrypted = ""; //The encrypted password to be saved
	       
		for (int i = 0; i < originalPassword.length(); i++) {
	    	   
			int c = originalPassword.charAt(i) + key; //We modify each character of the alphanumeric
	           
			if (c > 126) {
				c -= 95; //If the ascii table maximum is exceeded
			} 
			else if (c < 32) {
				c += 95; //If it is less than the allowable limit of the ASCII table
			}
			encrypted += (char) c;
		}
		return encrypted;
	}
	
	
	//Method of decrypting an encrypted Password
	public static String decryptPassword(String encryptedPassword, int key) {
		
		return encryptMessage(encryptedPassword, -key);
	}
	
	
}
