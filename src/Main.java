import java.awt.EventQueue;
import java.util.ArrayList;

import GUI.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		Company theCompany = new Company("IT Intelligence", "A Technology Company", "25012001", "6971657008", "Thessaloniki", "itintelligenceuom@gmail.com");
		
		Password thePassword = new Password("12345678", "minasch", "Minas", "Charakopoulos");
		Account theAccount = new Account("minasch", "m.charakopoulos@gmail.com", theCompany, thePassword);
		Employee first = new Employee("Minas", "Charakopoulos", "6971657008", "Dervenakion", "male", "25/01/2001", "Programmer", theAccount);
		
		Password thePassword2 = new Password("12345678", "d.lougaris", "Dionisis", "Lougaris");
		Account theAccount2 = new Account("d.lougaris", "d.lougaris@gmail.com", theCompany, thePassword2);
		Employee first2 = new Employee("Dionisis", "Lougaris", "6971657008", "Valtetsiou", "male", "19/12/2001", "Programmer", theAccount2);
		
		Password thePassword3 = new Password("12345678", "panos", "Panos", "Maxairas");
		Account theAccount3 = new Account("panos", "ics20044@uom.edu.gr", theCompany, thePassword3);
		Employee first3 = new Employee("Panos", "Maxairas", "6971657008", "Valtetsiou", "male", "19/12/2001", "Programmer", theAccount3);
		
		Password thePassword4 = new Password("12345678", "Eleni", "Eleni", "Maz");
		Account theAccount4 = new Account("eleni", "eleni@gmail.com", theCompany, thePassword4);
		Chief first4 = new Chief("Eleni", "Maz", "6971657008", "Valtetsiou", "female", "19/12/2001", "Programmer", theAccount4);
		
		
		theCompany.addUser(first);
		theCompany.addUser(first2);
		theCompany.addUser(first3);
		theCompany.addUser(first4);
		
		/*privateConversation conversation = new privateConversation(first, first2);
		Message firstMessage = new Message("Geiaaa", first);
		Message firstMessage1 = new Message("Geiaaa", first2);
		Message firstMessage2 = new Message("Ti kaneis", first);
		Message firstMessage3 = new Message("Ola kala esy?", first2);
		conversation.addMesage(firstMessage);
		conversation.addMesage(firstMessage1);
		conversation.addMesage(firstMessage2);
		conversation.addMesage(firstMessage3);
		
		//Storage.saveConversation(conversation);
		
		Storage.retrieveConversation(conversation);
		
		//Πρεπει να δουμε αν θα μεινει το πεδιο ListOfConversations στον User και τι θα γινει με τι ανακτηση*/
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new WelcomeScreen_GUI(theCompany);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}

