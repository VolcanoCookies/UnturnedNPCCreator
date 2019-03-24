package models;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	String previousDialogueStringID;
	String conditions;
	String rewards;
	List<Response> responses = new ArrayList<Response>();
	String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void addText(String text) {
		if(this.text!=null)
			this.text += "<p>" + text;
		else
			this.text = text;
	}
	public String getPreviousDialogueID() {
		return previousDialogueStringID;
	}
	public void setPreviousDialogueID(String previousMessageID) {
		this.previousDialogueStringID = previousMessageID;
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
	public List<Response> getResponses() {
		return responses;
	}
	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
	public void addResponse(Response response) {
		this.responses.add(response);
	}
	public void addRewards(String rewards) {
		this.rewards += rewards;
	}
	public void addConditions(String condition) {
		this.conditions += condition;
	}
}
