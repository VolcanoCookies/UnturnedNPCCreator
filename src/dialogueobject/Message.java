package dialogueobject;

import java.util.ArrayList;
import java.util.List;

class Message {

	String index;
	String conditions;
	String rewards;
	
	//Indexes in dialogue file for the responses for this message.
	List<Integer> responseIndexes = new ArrayList<Integer>();
	
	//Array is for pages.
	List<String> text = new ArrayList<String>();
	
	//Index of message to go back to
	int returnMessageIndex = 0;
	
	public Message() {
		
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
	public List<String> getText() {
		return text;
	}
	public void addText(String text) {
		this.text.add(text);
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

	public String[] CompileMessage() {
		//Asset.dat is 0, English.dat is 1
		String output[] = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Get responses
		if(this.responseIndexes.size()>0) {
			output[0] += "Message_" + this.index + "_Responses " + this.responseIndexes.size() + "\n";
			for(int i = 0; i < this.responseIndexes.size(); i++) {
				output[0] += "Message_" + this.index + "_Response_" + i + " " + this.responseIndexes.get(i) + "\n";
			}
		}
		
		//Get previous dialogue to go back to
		if(this.returnMessageIndex!=0)
			output[0] += "Message_" + this.index + "_Prev " + this.returnMessageIndex + "\n";
		
		//Get message conditions and rewards
		if(this.conditions!=null) {
			for(String string : this.conditions.split("\n")) {
				output[0] += "Message_" + this.index + "_" + string + "\n";
			}
		}
		if(this.rewards!=null) {
			for(String string : this.rewards.split("\n")) {
				output[0] += "Message_" + this.index + "_" + string + "\n";
			}
		}
		
		//Get English text
		for(int i = 0; i < text.size(); i++) {
			output[1] += "Message_" + this.index + "_Page_" + text.get(i);
		}
		
				
		return output;
	}
}
