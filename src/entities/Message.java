package entities;

import java.io.Serializable;
import java.time.*;

public class Message implements Serializable{
	
	private String content;
	private LocalDateTime timesent; //Holds the exact time message was sent
	private User sender;
	
	
	public Message(String content, User sender) {
		this.content = content;
		this.timesent = LocalDateTime.now();
		this.sender = sender;
	}

	//*************** Getters and Setters *************
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
