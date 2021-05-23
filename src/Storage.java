import java.io.*;

public class Storage {

	
	//Keeping all data by saving the company object in a binary file
	public static void saveInBinaryFile(Company theCompany) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("bsnmedia.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(theCompany);
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
		
		// nomizw xreiazetai giati logo twn try catch isws den parei timh to theCompany kai xtypaei error
		Company theCompany=null;
		try {
			FileInputStream fileIn = new FileInputStream("bsnmedia.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			theCompany = (Company)in.readObject();
			in.close();
			fileIn.close();
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
		return theCompany;
	}
	
	//Saving each conversation in a unique file
	public static void saveConversation(Conversation aConversation) {
		try {
			FileWriter writer= new FileWriter(aConversation.conversationName);
			for(int i=0;i<aConversation.allMessages.size();i++)
			{
				writer.write(aConversation.allMessages.get(i).getContent());
				writer.write(aConversation.allMessages.get(i).getTimesent().toString());
				writer.write(aConversation.allMessages.get(i).getSender().toString());
				writer.write(aConversation.allMessages.get(i).getReciever().toString());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	//Retrieving each conversation for a unique file
	public static void retrieveConversation() {
		
		
	}
}
