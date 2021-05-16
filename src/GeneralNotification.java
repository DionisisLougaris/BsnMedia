
public class GeneralNotification extends Notification{

	private String typeOfNotification;
	
	public GeneralNotification(String notificationContent, Group aboutThisGroup, String typeOfNotification) {
		super(notificationContent, aboutThisGroup);
		this.typeOfNotification = typeOfNotification;
	}

	
	
	public String getTypeOfNotification() {
		return typeOfNotification;
	}

	public void setTypeOfNotification(String typeOfNotification) {
		this.typeOfNotification = typeOfNotification;
	}
		
}
