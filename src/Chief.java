
import java.util.ArrayList;

public class Chief extends User{
	
	private ArrayList<Group> groupsSupervising = new ArrayList<Group>();
	
	
	//Constructor for Chief class
	public Chief(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	

}
