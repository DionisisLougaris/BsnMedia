import java.util.*;

public class Employee extends User{

	private ArrayList<Group> listOfGroups = new ArrayList<Group>();
	
	
	//Constructor for Employee class
	public Employee(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}


	


}
