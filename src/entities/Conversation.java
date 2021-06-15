package entities;

import java.io.Serializable;

abstract public class Conversation extends Notification implements Serializable{
		
	//Add a message to the message List
	abstract public void addMessage(Message aMessage);

}
