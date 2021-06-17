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
		Boss first2 = new Boss("Dionisis", "Lougaris", "6971657008", "Valtetsiou", "male", "19/12/2001", "Programmer", theAccount2);
		
		Password thePassword3 = new Password("12345678", "panos", "Panos", "Maxairas");
		Account theAccount3 = new Account("panos", "ics20044@uom.edu.gr", theCompany, thePassword3);
		Employee first3 = new Employee("Panos", "Maxairas", "6971657008", "Valtetsiou", "male", "19/12/2001", "Programmer", theAccount3);
		
		Password thePassword4 = new Password("12345678", "Eleni", "Eleni", "Maz");
		Account theAccount4 = new Account("eleni", "eleni@gmail.com", theCompany, thePassword4);
		Chief first4 = new Chief("Eleni", "Maz", "6971657008", "Valtetsiou", "female", "19/12/2001", "Programmer", theAccount4);
		
		Password thePassword5 = new Password("12345678", "elenikos", "Eleni", "Kosmidou");
		Account theAccount5 = new Account("elenikos", "elenikos01@gmail.com", theCompany, thePassword5);
		Employee first5 = new Employee("Eleni", "Kosmidou", "6939445593", "Dervenakion", "female", "26/08/2001", "Programmer", theAccount5);
		
		theCompany.setBoss(first2);
		
		Connection c = new Connection(first, first3);
		Connection c1 = new Connection(first, first4);
		Connection c2 = new Connection(first, first2);
		Connection c3 = new Connection(first3, first2);
		Connection c4 = new Connection(first5, first);
		c.manageConnectionRequest(true, null);
		c1.manageConnectionRequest(true, null);
		c2.manageConnectionRequest(true, null);
		c3.manageConnectionRequest(true, null);
		c4.manageConnectionRequest(true, null);
		first.addPost(new Post(first,"Γειά","public"));
		
		Project p1= new Project("project name","this is the Description","deadline");
		Group g1= new Group("group name",p1,first4);
		Group g2= new Group("omada9",p1,first4);
		first.addGroupToEmployeesList(g2);
		first.addGroupToEmployeesList(g1);
		first4.addGroupToSupervise(g1);
		first4.addGroupToSupervise(g2);
		groupConversation groupConversation = new groupConversation(g1);
		groupConversation groupConversation1 = new groupConversation(g2);
		first.addConversation(groupConversation);
		first4.addConversation(groupConversation);
		first.addConversation(groupConversation1);
		first4.addConversation(groupConversation1);
		g1.setMyConversation(groupConversation);
		g2.setMyConversation(groupConversation1);
		
		theCompany.addCompanyGroups(g1);
		theCompany.addCompanyGroups(g2);
		
		theCompany.addUser(first);
		theCompany.addUser(first2); //prepei kai o Boss na prostethei
		theCompany.addUser(first3);
		theCompany.addUser(first4);
		theCompany.addUser(first5); 
		
		//Εδω γίνεται η συζήτηση και η αποθήκευση της συνομιλίας (Αυτή την λογική θα κρατήσουμε)
		privateConversation conversation = new privateConversation(first, first2);
		Message firstMessage = new Message("Geiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", first);
		conversation.addMessage(firstMessage);
		Message firstMessage1 = new Message("Geiaaa", first2);
		conversation.addMessage(firstMessage1);
		Message firstMessage2 = new Message("Ti kaneis", first);
		conversation.addMessage(firstMessage2);
		Message firstMessage3 = new Message("Ola kala esy?", first2);
		conversation.addMessage(firstMessage3);


		//Εδώ γίνεται η ανάκτηση της συνομιλίας από το αρχείο
		/*ArrayList<String> theConversation = new ArrayList<String>();
		
		theConversation = Storage.retrieveConversation(conversation);
		for (String line: theConversation) {
			System.out.println(line);
		}*/
		
		
		//Company theCompany=Storage.retrieveFromBinaryFile();
		
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

