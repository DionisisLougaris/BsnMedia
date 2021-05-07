

import java.util.*;



public class Boss extends User{

	
	//Constructr for Boss class
	public Boss(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	
	//It is a method that modifies the fields that concern the elements of the company. No check is performed for correct data entry.
	public void changeVerificationCode (String potentialVerificationCode)
	{
		if(potentialVerificationCode.length()>=16 && !potentialVerificationCode.equals(myAccount.getMyCompany().getVerificationCode()))
		{
			myAccount.getMyCompany().setVerificationCode(potentialVerificationCode);
		}
	}
	
	
	
}
