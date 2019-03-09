package windows;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{

	private static String string = "Message_0_Pages 1\r\n" + 
			"Message_0_Responses 5\r\n" + 
			"Message_0_Response_0 0\r\n" + 
			"Message_0_Response_1 1\r\n" + 
			"Message_0_Conditions 2\r\n" + 
			"Message_0_Condition_0_Type Flag_Bool\r\n" + 
			"Message_0_Condition_0_Logic Equal\r\n" + 
			"Message_0_Condition_0_ID 2\r\n" + 
			"Message_0_Condition_0_Value True\r\n" + 
			"Message_0_Condition_1_Type Quest\r\n" + 
			"Message_0_Condition_1_Logic Equal\r\n" + 
			"Message_0_Condition_1_ID 47\r\n" + 
			"Message_0_Condition_1_Status None";

	public static void main(String[] args)
	{
		Pattern pattern = Pattern.compile(".*message_[0-9]+_responses ([0-9]+).*");
		Matcher matcher = pattern.matcher(string.toLowerCase().replaceAll("\n", "").replaceAll("\r", ""));
		
		System.out.println(matcher.matches());
		System.out.println(matcher.group(1));
	}
}
