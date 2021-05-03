import java.util.*;

public class Employee extends User{

	private ArrayList<Group> listOfGroups = new ArrayList<Group>();
	
	public Employee(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, String image, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, image, myAccount);
		// TODO Auto-generated constructor stub
	}

}
