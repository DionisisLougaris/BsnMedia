import GUI.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		Company theCompany = new Company("IT Intelligence", "A Technology Company", "25012001", "6971657008", "Thessaloniki", "itintelligenceuom@gmail.com");
		
		WelcomeScreen_GUI window = new WelcomeScreen_GUI(theCompany);
	}
	
}

