import java.io.Serializable;
import java.time.*;

abstract public class Notification implements Serializable{
	
	private String notificationContent;
	private LocalDateTime timestamp;
	private Group aboutThisGroup;
	private User aboutThisUser;
	private Conversation aboutThisConversation;
	
	
	//Constructor for Notification class when a notification is about Group
	public Notification(String notificationContent, Group aboutThisGroup) {
		this.notificationContent = notificationContent;
		this.timestamp = LocalDateTime.now();
		this.aboutThisGroup = aboutThisGroup;
		this.aboutThisUser = null;
		this.aboutThisConversation = null;
	}
	
	//Constructor for Notification class when a notification is about User
	public Notification(String notificationContent, User aboutThisUser) {
		this.notificationContent = notificationContent;
		this.timestamp = LocalDateTime.now();
		this.aboutThisGroup = null;
		this.aboutThisUser = aboutThisUser;
		this.aboutThisConversation = null;
	}
	
	//Constructor for Notification class when a notification is about a message
	public Notification(String notificationContent, Conversation aboutThisConversation) {
		this.notificationContent = notificationContent;
		this.timestamp = LocalDateTime.now();
		this.aboutThisGroup = null;
		this.aboutThisUser = null;
		this.aboutThisConversation = aboutThisConversation;
	}
	
	//Empty constructor for class Connection
	public Notification() {
		
	}
	
}
