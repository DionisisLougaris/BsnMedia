import java.awt.EventQueue;
import java.util.ArrayList;

import GUI.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		//The company that is being hosted on BSN media.
		Company theCompany = new Company("DPM development", "Full Stack Development", "18062021", "2310891101", "Egnatias 156, Thessaloniki", "dpm@uom.gr");
		
		                                 //Password    Username    Firstname     Lastname
		Password password1 = new Password("12345678", "ics20044", "Panagiotis", "Machairas"); 
		Account account1 = new Account("ics20044", "ics20044@uom.edu.gr", theCompany, password1);
		Boss boss = new Boss("Panagiotis", "Machairas", "6900020044", "Thessaloniki", "male", "15/11/2001", "Programmer", account1);
		theCompany.setBoss(boss);
		                                 //Password    Username    Firstname          Lastname
		Password password2 = new Password("12345678", "ics20072", "Minas-Theodoros", "Charakopoulos"); 
		Account account2 = new Account("ics20072", "ics20072@uom.edu.gr", theCompany, password2);
		Chief chief1 = new Chief("Minas-Theodoros", "Charakopoulos", "6900020072", "Thessaloniki", "male", "25/1/2001", "Programmer", account2);
		
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

