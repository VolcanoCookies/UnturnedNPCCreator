package dialogues;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {
	
	private String asset = "";
	private String english = "";
	private int noReplies = 0;
	private String[][] replies;
	private int index = 0;
	
	public Message(int index, String asset, String english) {
		
		this.index = index;
		
		//Get number of replies
		Matcher matcher = Pattern.compile(".*message_" + index + "_responses ([0-9]+).*", Pattern.DOTALL).matcher(asset.toLowerCase());
		if(matcher.matches())
			this.noReplies = Integer.valueOf(matcher.group(1));
						
		//Get asset data
		for(String string : asset.split("\n")) {
			if(string.toLowerCase().contains("message_" + this.index + "_") && !string.toLowerCase().contains("_message_"))
				this.asset += string + "\n";
		}
		
		//Get English data
		for(String string : english.split("\n")) {
			if(string.toLowerCase().contains("message_" + this.index + "_"))
				this.english += string;
		}
		
		//Get replies and their global index
		
		
		//Output
		if(true) {
			System.out.println("Message index " + this.index);
			System.out.println("No. reponses " + this.noReplies);
			System.out.print("Message asset\n" + this.asset + "\n-----------------\n");
			System.out.print("Message english\n" + this.english + "\n-----------------\n");
			System.out.println("\n\n");
		}
		
	}
}
