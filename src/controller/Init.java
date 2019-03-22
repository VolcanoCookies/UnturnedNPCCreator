package controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Settings;

public class Init {
	
	static final String API_URL = "https://api.github.com/repos/volcanocookies/unturnednpccreator/releases/latest";
	
	Init(String currentVersion) {	
		//Read config file
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(Init.class.getResourceAsStream("/Settings.config")));
			
			String nextLine = reader.readLine();
			String output = "";
			while(nextLine!=null) {
				output += nextLine + "\n";
				nextLine = reader.readLine();
			}
			reader.close();
			
			System.out.println(output);
			
			//Check if look for updates
			Matcher matcher = Pattern.compile("check for updates[ ]?=[ ]?(true|false)\n").matcher(output.toLowerCase());
			if(matcher.find()) {
				if(matcher.group(1).toLowerCase().equals("false")) {
					System.out.println("Settings: Check For Update = False");
					Settings.checkForUpdates(false);
				} else {
					System.out.println("Settings: Check For Update = True");
					Settings.checkForUpdates(true);
				}
			}
			matcher.reset();
			matcher.usePattern(Pattern.compile("confirm before exiting[ ]?=[ ]?(true|false)\n"));
			if(matcher.find()) {
				if(matcher.group(1).toLowerCase().equals("false")) {
					System.out.println("Settings: Confirm before exiting = False");
					Settings.ExitConfirmation(false);
				} else {
					System.out.println("Settings: Confirm before exiting = True");
					Settings.ExitConfirmation(true);
				}
			}
			matcher.reset();
			matcher.usePattern(Pattern.compile("condition color[ ]?=[ ]?(#[A-z,0-9]+)$*"));
			if(matcher.find()) {
				Settings.setConditionsPresentColor(Color.decode(matcher.group(1)));
				System.out.println("Settings: Conditions present color = " + matcher.group(1));
			}
			matcher.reset();
			matcher.usePattern(Pattern.compile("rewards color[ ]?=[ ]?(#[A-z,0-9]+)$*"));
			if(matcher.find()) {
				Settings.setRewardsPresentColor(Color.decode(matcher.group(1)));
				System.out.println("Settings: Rewards present color = " + matcher.group(1));
			}
			matcher.reset();
			matcher.usePattern(Pattern.compile("mixed color[ ]?=[ ]?(#[A-z,0-9]+)$*"));
			if(matcher.find()) {
				Settings.setMixedPresentColor(Color.decode(matcher.group(1)));
				System.out.println("Settings: Mixed present color = " + matcher.group(1));  
			}
			
		} catch (IOException e) {
			//Failed
			System.out.println("failed");
			e.printStackTrace();
		}
		
		//Check if running latest version
		if(Settings.checkForUpdates()) {
			try {
				String[] output = isUpdated(currentVersion);
				if(output != null) {
					System.out.println("Init: New update found.");
					new UpdateDialog(output);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else 
			System.out.println("Init: Not checking for updates.");
	}
	static String[] isUpdated(String currentVersion) throws IOException {
	    HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
	    //add headers to the connection, or check the status if desired..
	    
	    // handle error response code it occurs
	    int responseCode = connection.getResponseCode();
	    InputStream inputStream;
	    if (200 <= responseCode && responseCode <= 299) {
	        inputStream = connection.getInputStream();
	    } else {
	        inputStream = connection.getErrorStream();
	    }

	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	            inputStream));

	    StringBuilder response = new StringBuilder();
	    String currentLine;

	    while ((currentLine = in.readLine()) != null) 
	        response.append(currentLine);

	    in.close();
	    
	    //Get latest version
	    Matcher matcher = Pattern.compile("\"tag_name\":\"([^\"]+)\",").matcher(response.toString());
	    if(matcher.find()) {
	    	if(currentVersion.equals(matcher.group(1))) {
	    		return null;
	    	} else {
	    		//String to return
	    		String[] output = new String[5];
	    		
	    		//Find new version download URL
	    		matcher.reset();
	    		matcher.usePattern(Pattern.compile("\"html_url\":\"(https://github.com/VolcanoCookies/UnturnedNPCCreator/releases/tag/[^\"]*)\""));
	    		if(matcher.find())
	    			output[0] = matcher.group(1);
	    		//Current version
	    		output[1] = currentVersion;
	    		//Find the current version upload date
	    		output[2] = getCurrentCreatedDate(currentVersion);
	    		//Find the new version number
	    		matcher.reset();
	    		matcher.usePattern(Pattern.compile("\"tag_name\":\"([^\"]+)\","));
	    		if(matcher.find())
	    			output[3] = matcher.group(1);
	    		//Find the new version upload date
	    		matcher.reset();
	    		matcher.usePattern(Pattern.compile("\"published_at\":\"([^\"]+)\","));
	    		if(matcher.find())
	    			output[4] = matcher.group(1);
	    		return output;
	    	}
	    }
	    //Could not find latest version, skipping.
		return null;
	}
	static String getCurrentCreatedDate(String currentVersion) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL("https://api.github.com/repos/volcanocookies/unturnednpccreator/releases/tags/" + currentVersion).openConnection();
	    //add headers to the connection, or check the status if desired..
	    
	    // handle error response code it occurs
	    int responseCode = connection.getResponseCode();
	    InputStream inputStream;
	    if (200 <= responseCode && responseCode <= 299) {
	        inputStream = connection.getInputStream();
	    } else {
	        inputStream = connection.getErrorStream();
	    }

	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(
	            inputStream));

	    StringBuilder response = new StringBuilder();
	    String currentLine;

	    while ((currentLine = in.readLine()) != null) 
	        response.append(currentLine);

	    in.close();
	    
	    Matcher matcher = Pattern.compile("\"published_at\":\"([^\"]+)\",").matcher(response.toString());
	    if(matcher.find()) {
	    	return matcher.group(1);
	    }
		return "Error: Not found";
	}
}
