package entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.*;

public class Company implements Serializable{
	
	//This constant shows how many characters off are allowed for suggested search option to find results
	private static final int limitOfDifferentChars = 2;
	
	private String name;
	private String info;
	private Boss boss;
	//Company image will and can only be set by the boss
	private String image;
	/*The verification code is another way of securing the BSN network. It is only known by the boss.
	  Members willing to join the company's network shall ask the boss about the verificatio code in order to sign up */
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
		this.image = "default photo/defaultCompanyPhoto.png";
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
	
	
	//This is a method that adds a User to the members of the company.
	public void addUser(User theUser) {
			
		companyMembers.add(theUser);
	}
	
	
	/*This is a method that allows or does not allow the User to access in Bsn Media. If all checks are finished without 
	any error the user's backend Profile window on  network  opens.*/ 
	public boolean loginAttempt (String inputUsername, String inputPassword) throws IOException {
		
		for (User member: companyMembers) {
			String memberDecryptedPassword = Encryption.decryptPassword(member.getMyAccount().getMyPassword().getPassword(), 
														member.getMyAccount().getMyPassword().getTimestamp().getSecond());
			if (member.getMyAccount().getUsername().equals(inputUsername) && memberDecryptedPassword.equals(inputPassword)) {
				
				//Opening user's backend profile depending on company post
				if (member instanceof Employee) {
					new BackendProfileEmployeeGUI(member);
					return true;
				}else if (member instanceof Chief) {
					new BackendProfileChiefGUI(member);
					return true;
				}else {
					new BackendProfileBossGUI(member);
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Group> getCompanyGroups()
	{
		return companyGroups; 
	}
	
	//This method returns suggested search option for user's input at the search bar
	public ArrayList<String> suggestedSearchOption(String aString)
	{
		ArrayList<String> suggestedOptions = new ArrayList<String>();
		
		char[] givenString = aString.replaceAll("\\s+","").toCharArray(); //The input String without spaces
		
		
		//Checking if the User tried searching for the Company Profile
		char[] companyName = this.name.replaceAll("\\s+","").toCharArray();
		
		if (Company.calculateCommonCharacters(companyName, givenString)) {
			
			suggestedOptions.add(this.name);
		}
	
		//Checking if the User tried searching for any of the company Groups
		for(int i=0;i<this.companyGroups.size();i++) {
			
			char[] groupName = this.companyGroups.get(i).getName().replaceAll("\\s+","").toCharArray();
			
			if (Company.calculateCommonCharacters(groupName, givenString)) {
				suggestedOptions.add(companyGroups.get(i).getName());
			}	
		}
		
		//Checking if the User tried searching for any of the active Users by Full name
		for(int i=0;i<this.companyMembers.size();i++)
		{
			//Suggested Searching using user's full name, firstname, lastname or email
			char[] userFullName = (this.companyMembers.get(i).getFirstName()+this.companyMembers.get(i).getLastName()).replace("\\s+","").toCharArray();
			char[] firstName = (this.companyMembers.get(i).getFirstName().replaceAll("\\s+","").toCharArray());
			char[] lastName = (this.companyMembers.get(i).getLastName().replaceAll("\\s+","").toCharArray());
			char[] email = (this.companyMembers.get(i).getMyAccount().getEmail().replaceAll("\\s+","").toCharArray());
			
			if (Company.calculateCommonCharacters(userFullName, givenString) || Company.calculateCommonCharacters(firstName, givenString) 
					|| Company.calculateCommonCharacters(lastName, givenString) ||Company.calculateCommonCharacters(email, givenString)) {
				
				suggestedOptions.add(this.companyMembers.get(i).getFirstName()+" "+this.companyMembers.get(i).getLastName());
			}		
		}
		aString="";
				
		return suggestedOptions;
	}
	
	
	
	public boolean searchObject(String aString, User theUser) throws IOException {
		
		boolean found = false;
		
		//Searching for the company
		if(aString.equalsIgnoreCase(this.name)) {
			
			found = true;
			//Opening company profile when found
			new CompanyProfileGUI(theUser,this);
		}
		//Search for Group
		if (!found) {
			for(Group theGroup: companyGroups) {
				if (theGroup.getName().equalsIgnoreCase(aString)) {
					found = true;
					new GroupProfileGUI(theUser, theGroup);
					break;
				}
			}
		}
		//Searching for a User by FirstName, Surname, Full name or email
		if (!found) {
			
			for(int i=0;i<this.companyMembers.size();i++)
			{
				//checking if given String is off by maximum of limitOfDifferentChars(2) for a users Full name or email or first name or last name
				if((this.companyMembers.get(i).getFirstName()+ " " + this.companyMembers.get(i).getLastName()).equalsIgnoreCase(aString)
						||this.companyMembers.get(i).myAccount.getEmail().equals(aString) || this.companyMembers.get(i).getFirstName().equalsIgnoreCase(aString)
						|| this.companyMembers.get(i).getLastName().equalsIgnoreCase(aString)) {
					
					found = true;
					try {
						//Opening users profile if found!
						new FrontEndProfileGUI(theUser, companyMembers.get(i));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}	
		}
		//No entity was found so suggested search options appear to User
		return found;
	}
	
	
	
	//This methods returns if a Group Name is taken or not
	public boolean groupNameAvailability(String aString)
	{
		for(int i=0;i<this.companyGroups.size();i++)
			if(this.companyGroups.get(i).getName().equalsIgnoreCase(aString)) {
				return false;
			}
		return true;
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
	
	static boolean calculateCommonCharacters(char [] theOriginal, char [] userInput) {
		
		int charsMatchingForCompany = 0;
		
		if (theOriginal.length <= userInput.length) {
			
			for(int i=0;i<theOriginal.length;i++) {
				if(charactersEqualIgnoringCase(theOriginal[i],userInput[i]))
					charsMatchingForCompany++;
			}
			/*If the given String is at most 6 characters off the Original,
			  the String is added on the suggested search list */
			if(charsMatchingForCompany>=theOriginal.length-limitOfDifferentChars) {
				return true;
			}
		}else {
			for(int i=0;i<userInput.length;i++) {
				if(charactersEqualIgnoringCase(theOriginal[i],userInput[i]))
					charsMatchingForCompany++;
			}
			/*If the given String is at most 6 characters off the Original,
			  the String is added on the suggested search list */
			if(charsMatchingForCompany>=theOriginal.length-limitOfDifferentChars) {
				return true;
			}
		}
		
		return false;
	}
	
//*************** Getters and Setters ***************
	
	public String getInfo() {
		return info;
	}
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
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
	public String getTelephone() {
		return telephone;
	}
	public String getAddress() {
		return address;
	}
	public String getImage() {
		return image;
	}
	public String getEmail() {
		return email;
	}
	public void addCompanyGroups(Group g)
	{
		companyGroups.add(g);
	}
	public String getName() {
		return name;
	}
	public void setCompanyMembers(ArrayList<User> companyMembers) {
		this.companyMembers = companyMembers;
	}
	public void setCompanyGroups(ArrayList<Group> companyGroups) {
		this.companyGroups = companyGroups;
	}

	
}
