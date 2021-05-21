import GUI.*;

public class Main {

	public static void main(String[] args) {
		
		Message testMessage = new Message(" !Hallo World~");
		
		String encryptedMessage = Encryption.encryptMessage(testMessage.getContent(), testMessage.getTimesent().getSecond()+1);
		System.out.println(encryptedMessage);
		System.out.println(Encryption.decryptMessage(encryptedMessage, testMessage.getTimesent().getSecond()+1));
		System.out.println("Seconds: "+testMessage.getTimesent().getSecond());
		
	}
}

