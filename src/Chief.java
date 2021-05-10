
import java.util.ArrayList;

public class Chief extends User{
	
	private ArrayList<Group> groupsSupervising = new ArrayList<Group>();
	
	
	//Constructor for Chief class
	public Chief(String firstName, String lastName, String telephone, String address, String gender, String birthday,
			String companyPost, Account myAccount) {
		super(firstName, lastName, telephone, address, gender, birthday, companyPost, myAccount);
	}
	
	public void addGroupToSupervise(Group addingGroup)
	{
		groupsSupervising.add( addingGroup);
	}
	
	public boolean editProjectAndGroupInfo(String ProjectName,String ProjectDescription,String ProjectDeadLine,String groupName, Group editableeGroup)
	{
		boolean findgroup = false ;
		for(int i=0; i<myAccount.getMyCompany().getCompanyGroups().size(); i++)
		{
			if(myAccount.getMyCompany().getCompanyGroups().get(i).getName().contentEquals(groupName))
			{
				findgroup = true;
				break;
			}
		}
		if(findgroup)
		{
			editableeGroup.getMyProject().setName(ProjectName);
			editableeGroup.getMyProject().setDescription(ProjectDescription);
			editableeGroup.getMyProject().setDeadline(ProjectDeadLine);
			return false;
		}
		else 
		{
			editableeGroup.getMyProject().setName(ProjectName);
			editableeGroup.getMyProject().setDescription(ProjectDescription);
			editableeGroup.getMyProject().setDeadline(ProjectDeadLine);
			editableeGroup.setName(groupName);
			return true;
		}
	}

}
