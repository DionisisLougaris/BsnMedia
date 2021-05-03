import java.util.ArrayList;

public class Chief extends User{
	
	private ArrayList<Group> groupSupervising = new ArrayList<Group>();

	//Constructor from superclass User
	public Chief(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, String image, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, image, myAccount);
	}

}
