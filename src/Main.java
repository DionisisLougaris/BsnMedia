import java.awt.EventQueue;

import GUI.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		//************************Meloi tis omadas 9 pou prosferontai gia tin ektelesi tou programmatos********************************************
		//Sas parotrinoume na dimiourgisete kai ton diko sas logariasmo meso tis efarmogis. (Na gnorizete oti to Company verification code einai: 18062021)
		
		//The company that is being hosted on BSN media.
		/*Company theCompany = new Company("DPM development", "Full Stack Development", "18062021", "2310891101", "Egnatias 156, Thessaloniki", "dpm@uom.gr");
		
		                                 //Password    Username    Firstname     Lastname
		Password password1 = new Password("12345678", "ics20044", "Panagiotis", "Machairas"); 
		Account account1 = new Account("ics20044", "ics20044@uom.edu.gr", theCompany, password1);
		Boss boss = new Boss("Panagiotis", "Machairas", "6900020044", "Thessaloniki", "male", "15/11/2001", "Programmer", account1);
		theCompany.setBoss(boss);
		                                 //Password    Username    Firstname          Lastname
		Password password2 = new Password("12345678", "ics20072", "Minas-Theodoros", "Charakopoulos"); 
		Account account2 = new Account("ics20072", "ics20072@uom.edu.gr", theCompany, password2);
		Chief chief1 = new Chief("Minas-Theodoros", "Charakopoulos", "6900020072", "Thessaloniki", "male", "25/1/2001", "Programmer", account2);
		
		        						//Password    Username    Firstname    Lastname
		Password password3 = new Password("12345678", "ics20058", "Dionisis", "Lougaris"); 
		Account account3 = new Account("ics20058", "ics20058@uom.edu.gr", theCompany, password3);
		Chief chief2 = new Chief("Dionisis", "Lougaris", "6900020058", "Thessaloniki", "male", "19/12/2001", "Programmer", account3);
		
										 //Password    Username    Firstname   Lastname
		Password password4 = new Password("12345678", "ics20109", "Antonis", "Mertzanis"); 
		Account account4 = new Account("ics20109", "ics20109@uom.edu.gr", theCompany, password4);
		Employee employee1 = new Employee("Antonis", "Mertzanis", "6900020109", "Thessaloniki", "male", "1/1/2001", "Project Manager", account4);
		
				 						  //Password    Username   Firstname  Lastname
		Password password5 = new Password("12345678", "ics20064", "Eleni", "Kosmidou"); 
		Account account5 = new Account("ics20064", "ics20064@uom.edu.gr", theCompany, password5);
		Employee employee2 = new Employee("Eleni", "Kosmidou", "6900020064", "Thessaloniki", "female", "1/1/2001", "Programmer - Tester", account5);
		
				  						 //Password    Username   Firstname  Lastname
		Password password6 = new Password("12345678", "ics20055", "Eleni", "Mazaraki"); 
		Account account6 = new Account("ics20055", "ics20055@uom.edu.gr", theCompany, password6);
		Employee employee3 = new Employee("Eleni", "Mazaraki", "6900020055", "Thessaloniki", "female", "1/1/2001", "Programmer - Tester", account6);
		
					 					//Password    Username   Firstname  Lastname
		Password password7 = new Password("12345678", "ics20051", "Giwrgos", "Stefou"); 
		Account account7 = new Account("ics20051", "ics20051@uom.edu.gr", theCompany, password7);
		Employee employee4 = new Employee("Giwrgos", "Stefou", "6900020051", "Thessaloniki", "male", "1/1/2001", "Reasercher - Designer", account7);
		
										//Password    Username     Firstname    Lastname
		Password password8 = new Password("12345678", "ics20085", "Eleutheria", "Nanou"); 
		Account account8 = new Account("ics20085", "ics20085@uom.edu.gr", theCompany, password8);
		Employee employee5 = new Employee("Eleutheria", "Nanou", "6900020085", "Thessaloniki", "female", "1/1/2001", "Reasercher - Writter", account8);
		
										//Password    Username    Firstname    Lastname
		Password password9 = new Password("12345678", "ics20140", "Styliana", "Konstantinidi"); 
		Account account9 = new Account("ics20140", "ics20140@uom.edu.gr", theCompany, password9);
		Employee employee6 = new Employee("Styliana", "Konstantinidi", "6900020140", "Thessaloniki", "female", "1/1/2001", "Reasercher - Writter", account9);
		
										 //Password     Username    Firstname     Lastname
		Password password10 = new Password("12345678", "ics20092", "Konstantina", "Melissanidou"); 
		Account account10 = new Account("ics20092", "ics20092@uom.edu.gr", theCompany, password10);
		Employee employee7 = new Employee("Konstantina", "Melissanidou", "6900020092", "Thessaloniki", "female", "1/1/2001", "Reasercher - Assistant", account10);
		
		theCompany.addUser(boss);
		theCompany.addUser(chief1);
		theCompany.addUser(chief2);
		theCompany.addUser(employee1);
		theCompany.addUser(employee2);
		theCompany.addUser(employee3);
		theCompany.addUser(employee4);
		theCompany.addUser(employee5);
		theCompany.addUser(employee6);
		theCompany.addUser(employee7); */
		
		Company theCompany;
		theCompany = Storage.retrieveFromBinaryFile();
		
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

