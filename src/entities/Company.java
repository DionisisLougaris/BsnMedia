package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Company implements Serializable{
	
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
	
	
	//Initial Constructor for Company class
	public Company(String name, String info, String verificationCode, String telephone, String address, String email) {
		this.name = name;
		this.info = info;
		this.verificationCode = verificationCode;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
	}
	

	
	//This method checks if a User exists based on his firstname or lastname or username or email
	public User isCompanyMember(String aString)
	{
		for(int i=0;i<this.companyMembers.size();i++)
			if(this.companyMembers.get(i).firstName.equals(aString) 
					|| this.companyMembers.get(i).lastName.equals(aString)
					|| this.companyMembers.get(i).myAccount.getUsername().equals(aString)
					|| this.companyMembers.get(i).myAccount.getEmail().equals(aString))
							return this.companyMembers.get(i);
		
		return null;
	}
	
	public ArrayList<Group> getCompanyGroups()
	{
		return companyGroups; 
	}
	
	
	public ArrayList<String> suggestedSearchOption(String aString)
	{
		ArrayList<String> suggestedOptions = new ArrayList<String>();
		
		char[] givenString = aString.toCharArray();
		
		//Checking if the User tried searching the Company
		int charsMatchingForCompany=0;
		char[] companyName = this.name.toCharArray();
		for(int i=0;i<companyName.length;i++) {
			if(charactersEqualIgnoringCase(companyName[i],givenString[i]))
				charsMatchingForCompany++;
		}
		/*If the given String is at most 2 characters off the company name,
		  the company entity is added on the suggested search list */
		if(charsMatchingForCompany>=companyName.length-2)
			suggestedOptions.add(this.name);
			
		//Checking if the User tried searching for any of the active Groups
		for(int i=0;i<this.companyGroups.size();i++)
		{
			int charsMatchingForGroup=0;
			char[] groupName = this.companyGroups.get(i).getName().toCharArray();
			for(int j=0;j<groupName.length;j++)
				if(charactersEqualIgnoringCase(groupName[i],givenString[i]))
					charsMatchingForGroup++;
			
			/*If the given String is at most 2 characters off a Group name,
			  the group entity is added on the suggested search list */
			if(charsMatchingForGroup>=groupName.length-2)
				suggestedOptions.add(this.companyGroups.get(i).getName());	
		}
		
		//Checking if the User tried searching for any of the active Users by Full name
		for(int i=0;i<this.companyMembers.size();i++)
		{
			int charsMatchingForUserFullName=0;
			//Connecting users First and Last name in one String and converting it to char array
			char[] userFullName = (this.companyMembers.get(i).getFirstName()+ " " +  this.companyMembers.get(i).getLastName()).toCharArray();
			for(int j=0;j<userFullName.length;j++)
				if(charactersEqualIgnoringCase(userFullName[i],givenString[i]))
					charsMatchingForUserFullName++;
					
			/*If the given String is at most 3 characters off a User's Full name,
				 the User entity is added on the suggested search list */
			if(charsMatchingForUserFullName>=userFullName.length-3)
				suggestedOptions.add(this.companyMembers.get(i).getFirstName()+ " " +  this.companyMembers.get(i).getLastName());
					
		}
				
		return suggestedOptions;
	}
	
	
	public void searchObject(String aString)
	{
		boolean found=false;
		
		//Searching for the company
		if(aString.equals(this.name))
		{
			found=true;
			//new companyProfile();
		}
		
		//Searching for a group
		for(int i=0;i<this.companyGroups.size();i++)
			if(this.companyGroups.get(i).getName().equals(aString))
			{
				found=true;
				//new groupProfile();
			}
		//Searching for a User by Full name or email
		for(int i=0;i<this.companyMembers.size();i++)
		{
			if((this.companyMembers.get(i).getFirstName()+ " " +  this.companyMembers.get(i).getLastName()).equals(aString)
					||this.companyMembers.get(i).myAccount.getEmail().equals(aString))
			{
				found=true;
				//new userBackendProfile();
			}
		}
		//No entity was found so suggested search options appear to User
		if (found=false)
			this.suggestedSearchOption(aString);
	}
	
	
	//This methods returns if a Group Name is taken or not
	public boolean groupNameAvailability(String aString)
	{
		boolean available=true;
		for(int i=0;i<this.companyGroups.size();i++)
			if(this.companyGroups.get(i).getName().equalsIgnoreCase(aString))
				available=false;
		return available;
	}
	
	//This method seperates and collects Chiefs from all Users
	public ArrayList<Chief> returnChiefs()
	{
		ArrayList<Chief> allChiefs = new ArrayList<Chief>();
		for(int i=0; i<this.companyMembers.size();i++) {
			if (this.companyMembers.get(i) instanceof Chief) {
				allChiefs.add((Chief)(companyMembers.get(i)));
			}
		}
		return allChiefs;
	}
	
	//This method seperates and collects Employees from all Users
	public ArrayList<Employee> returnEmployees()
	{
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		for(int i=0; i<this.companyMembers.size();i++) {
			if (this.companyMembers.get(i) instanceof Employee) {
				allEmployees.add((Employee)(companyMembers.get(i)));
			}
		}
		return allEmployees;
	}
	
	
	//This static method checks if two characters are equal ignoring case
	static boolean charactersEqualIgnoringCase(char c1, char c2) {
		
		  if (c1 == c2) return true;
		  char u1 = Character.toUpperCase(c1);
		  char u2 = Character.toUpperCase(c2);
		  if (u1 == u2) return true;

		  return Character.toLowerCase(u1) == Character.toLowerCase(u2);
	}
	
	
	
	public ArrayList<User> getCompanyMembers()
	{
		return companyMembers;
	}
	
	public String getVerificationCode() 
	{
		return verificationCode;
	}
	
	public void setVerificationCode(String s) 
	{
		 verificationCode = s;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setTelephone(String t) 
	{
		telephone = t;
	}
	
	public void setEmail(String e) 
	{
		email = e;
	}
	
	public void setAddress(String a) 
	{
		address = a;
	}
	
	public void setInfo(String i) 
	{
		info = i;
	}
	
	public void setImage(String i) 
	{
		image = i;
	}
	
		

}