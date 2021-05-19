
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
	   
	   
	   
	
	public static int encryptPassword(Password aPassword)
	{
		char[] chars = aPassword.getPassword().toCharArray();
		
		//prepei na allaksei to key den einai swsto
		int key= (aPassword.getAccountCreationTime().getSecond()+1);
		
		for(char c : chars)
		{
			c+=key;
			//metatrepetai ksana se String kai epistrefetai
		}
		return key;
	}
	
	public static String decryptPassword(String encryptedString,int key)
	{
		char[] chars = encryptedString.toCharArray();
		for(char c : chars)
		{
			c-=key;
			//prepei na doume pws tha sundesoume thn klash password me tis 2 methodous kruptografishs
			System.out.print(c);
		}
		
		return  String.valueOf(chars); 
		
	}
}
