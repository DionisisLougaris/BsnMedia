package entities;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Storage implements Serializable{

	
	//Keeping all data by saving the company object in a binary file
	public static void saveInBinaryFile(Company theCompany) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("bsnmedia.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(theCompany); //Saves the Company object because all other entities are included in it
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Getting all data by retrieving the company object from the binary file
	public static Company retrieveFromBinaryFile() {
		
		try {
			FileInputStream fileIn = new FileInputStream("bsnmedia.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Company theCompany;
			theCompany = (Company)in.readObject();
			in.close();
			fileIn.close();
			return theCompany; //The Company object retrieved from the binary file is returned
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*This is a static method which is called every time a message is sent. Its responsibility is to save the 
	 * message in the appropriate file, so that it is not lost, and can be retrieved by users associated with the conversation.
	 */
	public static void saveMessage(Message aMessage,Conversation aConversation) 
	{
		
		String conversationName;
		if (aConversation instanceof groupConversation) {
			//The name of a group chat is the Group name, and the conversation is stored in a text file with the corresponding name. The group name is unique, and cannot be changed.
			conversationName = "Conversations/"+((groupConversation) aConversation).getTheGroup().getName()+".txt";
		}else {
			/*The name of a personal conversation is the username of the first interlocutor + the Username of the second. A file with this name is created 
			 * during the first connection of two users if it does not already exist (They could stop being friends and then become again, so the old messages are not lost)
			 */
			conversationName = "Conversations/"+((privateConversation)aConversation).getDiscussant1().getMyAccount().getUsername()+
					"_"+((privateConversation)aConversation).getDiscussant2().getMyAccount().getUsername()+".txt";
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = aMessage.getTimesent().format(formatter);
        
		String messageModel = aMessage.getContent()+" | Date:"+formatDateTime+" | "+aMessage.getSender().getMyAccount().getUsername()+" | "; //The message as we get it
		String encryptedMessaModel = Encryption.encryptMessage(messageModel, aMessage.getTimesent().getSecond()); //The encrypted message
		
		//What we finally save. (In the encrypted message we add in normal form the seconds that are the key, so that the decryption can be done)
		encryptedMessaModel = encryptedMessaModel + "|" + aMessage.getTimesent().getSecond() + "/";
		try {
			FileWriter fw = new FileWriter(conversationName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(encryptedMessaModel); //Save the message in encrypted form
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	//Retrieving each conversation for a unique file
	public static ArrayList<String> retrieveConversation(Conversation retrievedConversation) {
		
		ArrayList<String> convInString = new ArrayList<>();
		
		try {
			File conversationName;
			if (retrievedConversation instanceof groupConversation) {
				conversationName = new File("Conversations/"+((groupConversation) retrievedConversation).getTheGroup().getName()+".txt");
			}else {
				conversationName = new File("Conversations/"+((privateConversation)retrievedConversation).getDiscussant1().getMyAccount().getUsername()+
						"_"+((privateConversation)retrievedConversation).getDiscussant2().getMyAccount().getUsername()+".txt");
			}
			BufferedReader reader = new BufferedReader(new FileReader(conversationName));
			try {
				String line;
				line = reader.readLine();
				while(line!=null) {
					int key = Storage.returnTheMessageKey(line); // We got the key for decrypt
					
					String decryptedMessage = Encryption.decryptMessage(line, key); //Decrypt the Message
					String finalDecryptedString = decryptedMessage.substring(0, decryptedMessage.length()-6); //We remove the last characters that were the key to decryption
					convInString.add(finalDecryptedString);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convInString; //We return what was read from the file, decrypted
	}
	
	
	//This method returns the key to decrypt a stored Message
	public static int returnTheMessageKey(String theMessage) {
		
		int theKey = -1;
		String theKeyString;
		
		//We know that the seconds will always be between these two characters. So we take their posstion
		int firstCharSignPosition = theMessage.lastIndexOf("|");
		int secondCharSignPosition = theMessage.lastIndexOf("/");
		
		//We take only one position for the seconds
		if (secondCharSignPosition - firstCharSignPosition == 2) { //It means that there is only one character between them
			theKeyString = String.valueOf(theMessage.charAt(firstCharSignPosition+1));
		}else {//We take two positions for the seconds because two characters mediate between them
			theKeyString = String.valueOf(theMessage.charAt(firstCharSignPosition+1)) + String.valueOf(theMessage.charAt(firstCharSignPosition+2));
		}
		
		theKey = Integer.parseInt(theKeyString); //We want the key as Integer
		
		return theKey;
	}
	
}
