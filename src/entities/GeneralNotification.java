package entities;

public class GeneralNotification extends Notification{

	private String typeOfNotification;//projectDone,acceptRequest,addedToGroup *Only possible values for typeOfNotification*
	
	public GeneralNotification(String notificationContent, Group aboutThisGroup, String typeOfNotification) {
		super(notificationContent, aboutThisGroup);
		this.typeOfNotification = typeOfNotification;
	}

	public GeneralNotification(String notificationContent, User aboutThisUser, String typeOfNotification) {
		super(notificationContent, aboutThisUser);
		this.typeOfNotification = typeOfNotification;
		// TODO Auto-generated constructor stub
	}




	public String getTypeOfNotification() {
		return typeOfNotification;
	}

	public void setTypeOfNotification(String typeOfNotification) {
		this.typeOfNotification = typeOfNotification;
	}
		
}
