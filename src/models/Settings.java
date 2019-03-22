package models;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Settings {
	
	static boolean CheckForUpdates;
	static boolean ExitConfirmation;
	static Color conditionsPresentColor;
	static Color rewardsPresentColor;
	static Color mixedPresentColor;

	public static Color getConditionsPresentColor() {
		return conditionsPresentColor;
	}
	public static void setConditionsPresentColor(Color conditionsPresentColor) {
		Settings.conditionsPresentColor = conditionsPresentColor;
	}
	public static Color getRewardsPresentColor() {
		return rewardsPresentColor;
	}
	public static void setRewardsPresentColor(Color rewardsPresentColor) {
		Settings.rewardsPresentColor = rewardsPresentColor;
	}
	public static Color getMixedPresentColor() {
		return mixedPresentColor;
	}
	public static void setMixedPresentColor(Color mixedPresentColor) {
		Settings.mixedPresentColor = mixedPresentColor;
	}
	public boolean isCheckForUpdates() {
		return CheckForUpdates;
	}
	public static void checkForUpdates(boolean checkForUpdates) {
		CheckForUpdates = checkForUpdates;
	}
	public static boolean checkForUpdates() {
		return CheckForUpdates;
	}
	public static void ExitConfirmation(boolean bool) {
		ExitConfirmation = bool;
	}
	public static boolean ExitConfirmation() {
		return ExitConfirmation;
	}
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Settings.class.getResource("/Settings.config").toURI())));
			//String to write
			String output = "";
			
			//Get all settings values
			output += "Check for updates = " + CheckForUpdates + "\n";
			output += "Confirm before exiting = " + ExitConfirmation + "\n";
			output += "Conditions color = #" + Integer.toHexString(conditionsPresentColor.getRGB()).substring(2) + "\n";
			output += "Rewards color = #" + Integer.toHexString(rewardsPresentColor.getRGB()).substring(2) + "\n";
			output += "Both color = #" + Integer.toHexString(mixedPresentColor.getRGB()).substring(2) + "\n";
			
			//Write
			writer.write(output);
			writer.close();
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
