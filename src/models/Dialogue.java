package models;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {
	
	
	String ID;
	String GUID;
	List<Message> messages = new ArrayList<Message>();
	List<Response> globalResponses = new ArrayList<Response>();
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getGUID() {
		return GUID;
	}
	public void setGUID(String gUID) {
		GUID = gUID;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Response> getGlobalResponses() {
		return globalResponses;
	}
	public void setGlobalResponses(List<Response> globalResponses) {
		this.globalResponses = globalResponses;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public void addGlobalResponse(Response response) {
		this.globalResponses.add(response);
	}
}
