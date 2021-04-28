import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		//Dhmiourgia User,Mhnhmatos gia testing stis methodous kruptografishs
		User u1 = new User("Dionisis");
		Message m1 = new Message("You should not be able to read this!",LocalDateTime.now(),u1);
		int key=encryptMessage(m1);
		// estw oti "u??<??????<???<~?<}~??<??<??}?<????=" einai to String pou diavasthke apo to arxeio
		decryptMessage("u??<??????<???<~?<}~??<??<??}?<????=",key);
	}
	public static int encryptMessage(Message aMessage)
	{
		
		char[] chars = aMessage.getContent().toCharArray();
		
		int key= (aMessage.getTimesent().getSecond()+1);
		
		for(char c : chars)
		{
			// kanonika prepei c+=key alla exw ena thema ston periorismo mesa ston pinaka ascii
			c+=5;
			//anti gia syso tha ginetai eggrafh sto arxeio
			System.out.print(c);	
		}
		
		return key;
	}
	public static void decryptMessage(String encryptedString,int key)
	{
		char[] chars = encryptedString.toCharArray();
		for(char c : chars)
		{
			c-=key;
			//anti gia syso tha ginetai eggrafh tou minimatos sto TextArea ths sunomilias
			System.out.print(c);
			
			
		}
		
	}
}

