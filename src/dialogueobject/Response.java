package dialogueobject;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
	String index;
	String conditions;
	String rewards;
	
	//On click actions
	String dialogueID;
	String vendorID;
	String questID;
	
	//Text to show on the button
	String text;
	
	//Messages to only show this response for
	List<Integer> messageIndexes = new ArrayList<Integer>();


	Response() {
		
	}
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
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
	public String getDialogueID() {
		return dialogueID;
	}
	public void setDialogueID(String dialogueID) {
		this.dialogueID = dialogueID;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public String getQuestID() {
		return questID;
	}
	public void setQuestID(String questID) {
		this.questID = questID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Integer> getMessageIndexes() {
		return messageIndexes;
	}
	public void addMessageIndexes(int index) {
		this.messageIndexes.add(index);
	}
}
