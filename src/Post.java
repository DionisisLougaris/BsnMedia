import java.time.*;

public class Post {
	
	private User creator;
	private String content;
	private String postScope; //Εμβελεια
	private LocalDateTime timestamp;
	
	
	//Constructor for Post class
	public Post(User creator, String content, String postScope) {
		this.creator = creator;
		this.content = content;
		this.postScope = postScope;
		this.timestamp = LocalDateTime.now();
	}
	
}
