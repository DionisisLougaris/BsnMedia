import java.util.ArrayList;

public class Group {
	private String name;
	private Project myProject;
	private Chief supervisor;
	private int rating;
	private ArrayList<Employee> groupMembers;
	
	public Group(String name, Project myProject, Chief supervisor) {
		this.name = name;
		this.myProject = myProject;
		this.supervisor = supervisor;
	}
	
	

}
