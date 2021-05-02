import java.util.ArrayList;

public class Company {
	
	private String name;
	private String info;
	private ArrayList<User> companyMembers = new ArrayList<>();
	
	public Company(String name, String info) {
		this.name = name;
		this.info = info;
	}
	
}
