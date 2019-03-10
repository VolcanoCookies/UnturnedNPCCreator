package dialogueobject;

import java.util.ArrayList;
import java.util.List;

class Response {
	
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


	public Response() {
		
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

	public String[] CompileResponse() {
		//Asset.dat is 0, English.dat is 1
		String output[] = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Get messages to show response for
		if(this.messageIndexes.size()>0) {
			output[0] += "Response_" + this.index + "_Messages " + this.messageIndexes.size() + "\n";
			for(int i = 0; i < this.messageIndexes.size(); i++) {
				output[0] += "Response_" + this.index + "_Message_" + i + " " + this.messageIndexes.get(i) + "\n";
			}
		}
		
		//Get on click
		if(this.dialogueID!=null)
			output[0] += "Response_" + this.index + "_Dialogue " + this.dialogueID + "\n";
		if(this.questID!=null)
			output[0] += "Response_" + this.index + "_Quest " + this.questID + "\n";
		if(this.vendorID!=null)
			output[0] += "Response_" + this.index + "_Vendor " + this.vendorID + "\n";
		
		//Get conditions and rewards
		if(this.conditions!=null) {
			for(String string : this.conditions.split("\n")) {
				output[0] += "Response_" + this.index + "_" + string + "\n";
			}
		}
		if(this.rewards!=null) {
			for(String string : this.rewards.split("\n")) {
				output[0] += "Response_" + this.index + "_" + string + "\n";
			}
		}
		
		return output;
	}
}
