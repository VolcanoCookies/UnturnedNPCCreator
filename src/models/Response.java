package models;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
	String text;
	boolean global;
	String ID;
	String questID;
	String vendorID;
	String dialogueID;
	String conditions;
	String rewards;
	List<Message> messages = new ArrayList<Message>();
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isGlobal() {
		return global;
	}
	public void setGlobal(boolean global) {
		this.global = global;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getRewards() {
		return rewards;
	}
	public void setRewards(String rewards) {
		this.rewards = rewards;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public String getQuestID() {
		return questID;
	}
	public void setQuestID(String questID) {
		this.questID = questID;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public String getDialogueID() {
		return dialogueID;
	}
	public void setDialogueID(String dialogueID) {
		this.dialogueID = dialogueID;
	}
}
