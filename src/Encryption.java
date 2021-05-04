
public class Encryption {
	
	//Ceaser cipher encryption based on time!
	public static int encryptMessage(Message aMessage)
	{
		char[] chars = aMessage.getContent().toCharArray();
		
		//prepei na allaksei to key den einai swsto
		int key= (aMessage.getTimesent().getSecond()+1);
		
		for(char c : chars)
		{
			c+=key;
			//edw krutpografeite to pedio kai oxi mono gia na perastei sto arxeio(anti gia syso tha ginetai eggrafh sto arxeio)
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
	
	public static void decryptPassword(String encryptedString,int key)
	{
		char[] chars = encryptedString.toCharArray();
		for(char c : chars)
		{
			c-=key;
			//prepei na doume pws tha sundesoume thn klash password me tis 2 methodous kruptografishs
			System.out.print(c);
		}
		
	}
}
