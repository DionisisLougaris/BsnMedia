import java.time.*;

public class Message extends Notification{
	private String content;
	private LocalDateTime timesent;
	private User sender;
	
	
	public Message(String content, LocalDateTime timesent, User sender) {
		this.content = content;
		this.timesent = timesent;
		this.sender = sender;
	}


	public String getContent() {
		return content;
	}


	public LocalDateTime getTimesent() {
		return timesent;
	}


	public User getSender() {
		return sender;
	}

	
	
}
