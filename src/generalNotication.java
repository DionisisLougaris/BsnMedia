
public class generalNotication extends Notification{

	private String typeOfNotification;
	
	
	//Constructor for GeneralNotification class
	public generalNotication(String notificationContent, String typeOfNotification) {
		super(notificationContent);
		this.typeOfNotification = typeOfNotification;
	}
		
}
