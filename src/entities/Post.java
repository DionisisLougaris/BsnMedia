package entities;

import java.io.Serializable;
import java.time.*;
import java.util.Comparator;


public class Post implements Serializable{
	
	private User creator;
	private String content;
	private String postScope; //Scope: (Public or Connections or Group)
	private LocalDateTime timestamp; //Holds exact time post was created
	
	
	//Constructor for Post class
	public Post(User creator, String content, String postScope) {
		this.creator = creator;
		this.content = content;
		this.postScope = postScope;
		this.timestamp = LocalDateTime.now();
	}
	
	
   /*The methods addLike , removelike and sharetoconversation removed due to panel issues  */ 
	
	//*************** Getters and Setters *************
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostScope() {
		return postScope;
	}

	public void setPostScope(String postScope) {
		this.postScope = postScope;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}

//Comparator so newer posts appear first
class postComparator implements Comparator<Post>, Serializable {

	@Override
	public int compare(Post o1, Post o2) {
		
		if (o1.getTimestamp().isBefore(o2.getTimestamp()))
			return 1;
		else  
			return -1;
	}
	
}
