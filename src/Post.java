import java.time.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Post {
	
	private User creator;
	private String content;
	private String postScope; //Εμβελεια
	private LocalDateTime timestamp;
	private int numberOfLikes;
	private ArrayList<User> likers = new ArrayList<User>(); //All users who likes the post
	
	
	//Constructor for Post class
	public Post(User creator, String content, String postScope) {
		this.creator = creator;
		this.content = content;
		this.postScope = postScope;
		this.timestamp = LocalDateTime.now();
		this.numberOfLikes = 0; //initially the number of Likes is 0
	}
	
	
	/*method which adds Like to a Post
	Boolean to know if in Gui we will change the value with the Likes so that unnecessary procedures are not done in Gui*/
	public boolean addLike(User theUser) {
		
		if (likers.contains(theUser)) {
			String message = "You have already like this Post!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Message",
			        JOptionPane.INFORMATION_MESSAGE);
			return false; //Like couldn' t added
		}
		else {
			numberOfLikes++;
			likers.add(theUser);
			return true; //New like added
		}	
	}
	
	
}
