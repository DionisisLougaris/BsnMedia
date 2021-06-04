package entities;

import java.io.Serializable;

public class Project implements Serializable{
	
	private String name;
	private String description;
	private String deadline;
	private String status; //only values "ongoing" or "done"
	private Group myGroup;
	
	
	//Constructor for Project class
	public Project(String name, String description, String deadline, Group myGroup) {
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.myGroup = myGroup;
		this.status = "ongoing";
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Group getMyGroup() {
		return myGroup;
	}

	public void setMyGroup(Group myGroup) {
		this.myGroup = myGroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
			
}