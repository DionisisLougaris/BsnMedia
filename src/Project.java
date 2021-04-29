
public class Project {
	private String name;
	private String description;
	private String deadline;
	private Group myGroup;
	
	public Project(String name, String description, String deadline, Group myGroup) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.myGroup = myGroup;
	}
	
	public void setName(String n) { name=n;}
	public void setDescription(String d) { description=d;}
	public void setDeadline(String d) { deadline=d;}
	public void setMyGroup(Group g) { myGroup=g;}
	
}
