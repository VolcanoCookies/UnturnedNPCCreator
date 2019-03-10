package dialogueobject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import filemanagement.LoadDialogue;

public class Dialogue {

	String GUID;
	String dialogueID;
	
	//Number of messages and responses
	int numberOfMessages;
	int numberOfResponses;
	
	//Messages in this dialogue
	Message[] messages;
	//Responses in this dialogue
	Response[] responses;
	
	//Path where this dialogue was loaded from
	String path;
	
	public Dialogue(String path) {
		
		this.path = path;
		if(path!=null)
			LoadDialogue(LoadDialogue.loadDialogue(path));
		CompileDialogue();
	}
	private String[] CompileDialogue() {
		//Asset.dat is 0, English.dat is 1
		String output[] = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Get ID, GUID and set type
		output[0] += "GUID " + this.GUID + "\n";
		output[0] += "ID " + this.dialogueID + "\n";
		output[0] += "Type Dialogue\n";
		
		
		//Get messages and responses
		output[0] += "\n" + "Messages " + this.numberOfMessages + "\n\n";
		for(Message mes : messages) {
			String[] compiled = mes.CompileMessage();
			output[0] += compiled[0] + "\n";
			output[1] += compiled[1] + "\n";
		}
		output[0] += "\n" + "Responses " + this.numberOfResponses + "\n\n";
		for(Response res : responses) {
			String[] compiled = res.CompileResponse();
			output[0] += compiled[0] + "\n";
			output[1] += compiled[1] + "\n";
		}
		
		System.out.println(output[0]);
		System.out.println("##############\n##############\n");
		System.out.println(output[1]);
		
		return output;
	}
	private void LoadDialogue(String values[]) {
		
		//Matcher to use for everything
		Matcher matcher = Pattern.compile("").matcher(values[0]);
		Matcher englishMatcher = Pattern.compile("").matcher(values[1]);

		//Get number of messages and responses
		matcher.reset();
		matcher.usePattern(Pattern.compile("[^_]+Messages ([0-9]+)"));
		if(matcher.find()) {
			numberOfMessages = Integer.valueOf(matcher.group(1));
			messages = new Message[numberOfMessages];
		}
		matcher.reset();
		matcher.usePattern(Pattern.compile("[^_]+Responses ([0-9]+)"));
		if(matcher.find()) {
			numberOfResponses = Integer.valueOf(matcher.group(1));
			responses = new Response[numberOfResponses];
		}
			
		//Generate messages
		for(int i = 0; i < numberOfMessages; i++) {
			messages[i] = new Message();
			messages[i].setIndex(Integer.toString(i));
		}
		//Generate responses
		for(int i = 0; i < numberOfResponses; i++) {
			responses[i] = new Response();
			responses[i].setIndex(Integer.toString(i));
		}
		
		//Get message conditions
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_(Condition.*)"));
		while(matcher.find()) {
			if(messages[Integer.valueOf(matcher.group(1))].getConditions()==null)
				messages[Integer.valueOf(matcher.group(1))].setConditions("");
			messages[Integer.valueOf(matcher.group(1))].setConditions(messages[Integer.valueOf(matcher.group(1))].getConditions() + matcher.group(2) + "\n");
		}
		//Get message rewards
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_(Reward.*)"));
		while(matcher.find()) {
			if(messages[Integer.valueOf(matcher.group(1))].getRewards()==null)
				messages[Integer.valueOf(matcher.group(1))].setRewards("");
			messages[Integer.valueOf(matcher.group(1))].setRewards(messages[Integer.valueOf(matcher.group(1))].getRewards() + matcher.group(2) + "\n");
		}
		//Get message response indexes
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_Response_[0-9]+ ([0-9]+)"));
		while(matcher.find()) {
			messages[Integer.valueOf(matcher.group(1))].addResponseIndex(Integer.valueOf(matcher.group(2)));
		}
		
		//Get message English section
		englishMatcher.reset();
		englishMatcher.usePattern(Pattern.compile("Message_([0-9]+)_Page_[0-9]+ (.*)"));
		while(englishMatcher.find()) {
			messages[Integer.valueOf(englishMatcher.group(1))].addText(englishMatcher.group(2));
		}
		
		/*
		 * RESPONSE SECTION
		 */
		
		//Get response conditions
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Condition.*)"));
		while(matcher.find()) {
			if(responses[Integer.valueOf(matcher.group(1))].getConditions()==null)
				responses[Integer.valueOf(matcher.group(1))].setConditions("");
			responses[Integer.valueOf(matcher.group(1))].setConditions(responses[Integer.valueOf(matcher.group(1))].getConditions() + matcher.group(2) + "\n");
		}
		//Get response rewards
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Reward.*)"));
		while(matcher.find()) {
			if(responses[Integer.valueOf(matcher.group(1))].getRewards()==null)
				responses[Integer.valueOf(matcher.group(1))].setRewards("");
			responses[Integer.valueOf(matcher.group(1))].setRewards(responses[Integer.valueOf(matcher.group(1))].getRewards() + matcher.group(2) + "\n");
		}
		//Get messages to show this response for
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_Message_[0-9]+ ([0-9]+)"));
		while(matcher.find()) {
			responses[Integer.valueOf(matcher.group(1))].addMessageIndexes(Integer.valueOf(matcher.group(2)));;
		}
		
		//Get onClick
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Quest|Dialogue|Vendor) ([0-9]+)"));
		while(matcher.find()) {
			if(matcher.group(2).equals("Dialogue"))
				responses[Integer.valueOf(matcher.group(1))].setDialogueID(matcher.group(3));
			if(matcher.group(2).equals("Quest"))
				responses[Integer.valueOf(matcher.group(1))].setQuestID(matcher.group(3));
			if(matcher.group(2).equals("Vendor"))
				responses[Integer.valueOf(matcher.group(1))].setVendorID(matcher.group(3));	
		}
		
		//Get response English section
		englishMatcher.reset();
		englishMatcher.usePattern(Pattern.compile("Response_([0-9]+) (.*)"));
		while(englishMatcher.find()) {
			responses[Integer.valueOf(englishMatcher.group(1))].setText(englishMatcher.group(2));
		}
	}
}