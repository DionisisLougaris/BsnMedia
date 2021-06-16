package entities;

import java.io.Serializable;

abstract public class Conversation extends Notification implements Serializable{
		
	abstract public void addMessage(Message aMessage);

}
