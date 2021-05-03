import java.time.*;

public class Notification {
	
	private String notificationContent;
	private LocalDateTime timestamp;
	
	
	//Constructor for Notification class
	public Notification(String notificationContent) {
		this.notificationContent = notificationContent;
		this.timestamp = LocalDateTime.now();
	}
	
}
