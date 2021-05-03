import java.util.ArrayList;

public class Company {
	
	private String name;
	private String info;
	private Boss boss;
	private String image;
	private String verificationCode;
	private String telephone;
	private String address;
	private String email;
	private ArrayList<User> companyMembers = new ArrayList<User>();
	private ArrayList<Group> companyGroups = new ArrayList<Group>();
	
	public Company(String name, String info) {
		this.name = name;
		this.info = info;
	}
	
}
