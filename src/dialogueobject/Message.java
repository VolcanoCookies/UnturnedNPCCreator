package dialogueobject;

import java.util.ArrayList;
import java.util.List;

public class Message {

	String index;
	String conditions;
	String rewards;
	
	//Indexes in dialogue file for the responses for this message.
	List<Integer> responseIndexes = new ArrayList<Integer>();
	
	//Array is for pages.
	String[] text;
	
	//Index of message to go back to
	int returnMessageIndex;
	
	Message() {
		
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
	public List<Integer> getResponseIndexes() {
		return responseIndexes;
	}
	public void setResponseIndexes(List<Integer> responseIndexes) {
		this.responseIndexes = responseIndexes;
	}
	public String[] getText() {
		return text;
	}
	public void setText(String[] text) {
		this.text = text;
	}
	public int getReturnMessageIndex() {
		return returnMessageIndex;
	}
	public void addReturnMessageIndex(int returnMessageIndex) {

		this.returnMessageIndex = returnMessageIndex;
	}
	public void addResponseIndex(int index) {
		this.responseIndexes.add(index);
	}
}
