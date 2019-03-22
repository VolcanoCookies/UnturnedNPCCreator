package controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import conditions.conditionsDialog;
import dialogues.ConfirmDialog;
import javafx.stage.FileChooser;
import models.Dialogue;
import models.Equipped;
import models.ItemBuying;
import models.ItemSelling;
import models.Message;
import models.NPCCharacter;
import models.Pose;
import models.Quest;
import models.Response;
import models.Vendor;
import rewards.RewardsDialog;
import windows.Window;

public class Controller {
	
	static List<NPCCharacter> loadedCharacters = new ArrayList<NPCCharacter>();
	static List<Vendor> loadedVendors = new ArrayList<Vendor>();
	static List<Dialogue> loadedDialogues = new ArrayList<Dialogue>();
	static List<Quest> loadedQuests = new ArrayList<Quest>();
	static Window window;
	public boolean save = true;
	
	Controller() {
		
		//Create the GUI window
		window = new Window(this);

	}
	public void addCharacter(NPCCharacter character) {
		loadedCharacters.add(character);
	}
	public void addVendor(Vendor vendor) {
		loadedVendors.add(vendor);
	}
	public void addDialogue(Dialogue dialogue) {
		loadedDialogues.add(dialogue);
	}
	public void addQuest(Quest quest) {
		loadedQuests.add(quest);
	}
	
	public void SaveCharacter(NPCCharacter character) {
		//Output string
		//0 is for Asset, 1 is for English.
		String[] output = new String[2];
		
		/*
		 * Asset part
		 */
		
		//Get GUID, ID and Type
		if(character.getGUID()!=null)
			output[0] += "GUID " + character.getGUID() + "\n";
		output[0] += "ID " + character.getID() + "\n";
		output[0] += "Type " + character.getType() + "\n";
		
		//Clothing section
		output[0] += "\n\\\\Clothing\n";
		if(character.getShirt()!=null)
			output[0] += "Shirt " + character.getShirt() + "\n";
		if(character.getPants()!=null)
			output[0] += "Pants " + character.getPants() + "\n";
		if(character.getVest()!=null)
			output[0] += "Vest " + character.getVest() + "\n";
		if(character.getMask()!=null)
			output[0] += "Mask " + character.getMask() + "\n";
		if(character.getBackpack()!=null)
			output[0] += "Backpack " + character.getBackpack() + "\n";
		if(character.getGlasses()!=null)
			output[0] += "Glasses " + character.getGlasses() + "\n";
		
		//If NPC has christmas clothing
		if(character.hasChristmasClothing()) {
			output[0] += "\n\\\\Christmas Clothing\n";
			output[0] += "Has_Christmas_Outfit true\n";
			if(character.getChristmasShirt()!=null)
				output[0] += "Christmas_Shirt " + character.getChristmasShirt() + "\n";
			if(character.getChristmasPants()!=null)
				output[0] += "Christmas_Pants " + character.getChristmasPants() + "\n";
			if(character.getChristmasVest()!=null)
				output[0] += "Christmas_Vest " + character.getChristmasVest() + "\n";
			if(character.getChristmasMask()!=null)
				output[0] += "Christmas_Mask " + character.getChristmasMask() + "\n";
			if(character.getChristmasBackpack()!=null)
				output[0] += "Christmas_Backpack " + character.getChristmasBackpack() + "\n";
			if(character.getChristmasGlasses()!=null)
				output[0] += "Christmas_Glasses " + character.getChristmasGlasses() + "\n";
		}
		
		//If NPC has halloween clothing
		if(character.hasHalloweenClothing()) {
			output[0] += "\n\\\\Halloween Clothing\n";
			output[0] += "Has_Halloween_Outfit true\n";
			if(character.getHalloweenShirt()!=null)
				output[0] += "Halloween_Shirt " + character.getHalloweenShirt() + "\n";
			if(character.getHalloweenPants()!=null)
				output[0] += "Halloween_Pants " + character.getHalloweenPants() + "\n";
			if(character.getHalloweenVest()!=null)
				output[0] += "Halloween_Vest " + character.getHalloweenVest() + "\n";
			if(character.getHalloweenMask()!=null)
				output[0] += "Halloween_Mask " + character.getHalloweenMask() + "\n";
			if(character.getHalloweenBackpack()!=null)
				output[0] += "Halloween_Backpack " + character.getHalloweenBackpack() + "\n";
			if(character.getHalloweenGlasses()!=null)
				output[0] += "Halloween_Glasses " + character.getHalloweenGlasses() + "\n";
		}
		
		//Face and hair
		output[0] += "\n\\\\Face and hair\n";
		output[0] += "Face " + character.getFace() + "\n";
		output[0] += "Hair " + character.getHair() + "\n";
		output[0] += "Beard " + character.getBeard() + "\n";
		output[0] += "Color_Skin #" + Integer.toHexString(character.getSkinColor().getRGB()).substring(2).toUpperCase() + "\n";
		output[0] += "Hair_Color #" + Integer.toHexString(character.getHairColor().getRGB()).substring(2).toUpperCase() + "\n";
		
		//Equipped section
		if(character.getPrimary()!=null || character.getSecondary()!=null || character.getTertiary()!=null) {
			output[0] += "\n\\\\Equipment\n";
			if(character.getPrimary()!=null)
				output[0] += "Primary " + character.getPrimary() + "\n";
			if(character.getSecondary()!=null)
				output[0] += "Secondary " + character.getSecondary() + "\n";
			if(character.getTertiary()!=null)
				output[0] += "Tertiary " + character.getTertiary() + "\n";
			if(character.getEquipped()!=null)
				output[0] += "Equipped " + character.getEquipped() + "\n";
		}
		
		//Pose and dialogue
		output[0] += "\n\\\\Pose and dialogue\n";
		output[0] += "Pose " + character.getPose() + "\n";
		if(character.isBackwards())
			output[0] += "Backwards True\n";
		if(character.getDialogueID()!=null)
			output[0] += "Dialogue " + character.getDialogueID() + "\n";
		
		//Watermark
		output[0] += "\n\n//Created with UnturnedNPCCreator by Volcano";
		
		/*
		 * English part
		 */
		
		output[1] += "Name " + character.getName() + "\n";
		output[1] += "Character " + character.getCharacterName();
		
		System.out.println(output[0]);
		//Confirmation dialog
		new ConfirmDialog(this);
		if(!save)
			return;
		else
			writeFile(output, getFile());
	}
	public static Object CreateModelFromFile(String[] input) {
		//Matcher to determine the type of model to make
		String type;
		Matcher matcher = Pattern.compile("Type (.*)$").matcher(input[0]);
		if(matcher.matches()) {
			type = matcher.group(1);
		} else {
			return null;
		}
		if(type.toLowerCase().contains("character"))
			return CreateCharacterFromFile(input);
		if(type.toLowerCase().contains("vendor"))
			return CreateVendorFromFile(input);
		if(type.toLowerCase().contains("dialogue"))
			return CreateDialogueFromFile(input);
		if(type.toLowerCase().contains("quest"))
			return CreateQuestFromDialogue(input);
		return null;
	}
	public static NPCCharacter CreateCharacterFromFile(String[] input) {
		//Character to return
		NPCCharacter character = new NPCCharacter();
		
		//Strings for Asset and English
		String asset = input[0];
		String english = input[1];
		
		//Matchers to be used
		Matcher matcherAsset = Pattern.compile("").matcher(asset);
		Matcher matcherEnglish = Pattern.compile("").matcher(english);
		
		//Get GUID ID etc
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^ID ([0-9]*)"));
		if(matcherAsset.matches())
			character.setID(Integer.valueOf(matcherAsset.group(1)));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^GUID (.*)"));
		if(matcherAsset.matches())
			character.setGUID(matcherAsset.group(1));
		
		//Get clothing
		//Get regular clothing
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Shirt ([0-9]*)"));
		if(matcherAsset.matches())
			character.setShirt(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Pants ([0-9]*)"));
		if(matcherAsset.matches())
			character.setPants(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Mask ([0-9]*)"));
		if(matcherAsset.matches())
			character.setMask(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Vest ([0-9]*)"));
		if(matcherAsset.matches())
			character.setVest(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Backpack ([0-9]*)"));
		if(matcherAsset.matches())
			character.setBackpack(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Glasses ([0-9]*)"));
		if(matcherAsset.matches())
			character.setGlasses(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Hat ([0-9]*)"));
		if(matcherAsset.matches())
			character.setHat(matcherAsset.group(1));
		
		//Get christmas clothing
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Has_Christmas_Outfit True.*"));
		if(matcherAsset.matches()) {
			//Has christmas clothing
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Shirt ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasShirt(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Pants ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasPants(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Mask ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasMask(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Vest ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasVest(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Backpack ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasBackpack(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Glasses ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasGlasses(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Christmas_Hat ([0-9]*)"));
			if(matcherAsset.matches())
				character.setChristmasHat(matcherAsset.group(1));
		}
		
		//Get halloween clothing
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Has_Halloween_Outfit True.*"));
		if(matcherAsset.matches()) {
			//Has halloween clothing
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Shirt ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenShirt(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Pants ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenPants(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Mask ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenMask(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Vest ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenVest(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Backpack ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenBackpack(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Glasses ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenGlasses(matcherAsset.group(1));
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("^Halloween_Hat ([0-9]*)"));
			if(matcherAsset.matches())
				character.setHalloweenHat(matcherAsset.group(1));
		}
		
		//Get face, hair etc
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Face ([0-9]*)"));
		if(matcherAsset.matches())
			character.setFace(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Hair ([0-9]*)"));
		if(matcherAsset.matches())
			character.setHair(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Beard ([0-9]*)"));
		if(matcherAsset.matches())
			character.setBeard(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Color_Skin (.*)"));
		if(matcherAsset.matches())
			character.setSkinColor(Color.decode(matcherAsset.group(1)));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Color_Hair (.*)"));
		if(matcherAsset.matches())
			character.setHairColor(Color.decode(matcherAsset.group(1)));
		
		//Get equipped
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Primary ([0-9]*)"));
		if(matcherAsset.matches())
			character.setPrimary(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Secondary ([0-9]*)"));
		if(matcherAsset.matches())
			character.setPrimary(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Tertiary ([0-9]*)"));
		if(matcherAsset.matches())
			character.setPrimary(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Equipped (.*)"));
		if(matcherAsset.matches()) {
			if(matcherAsset.group().toLowerCase().contains("primary"))
				character.setEquipped(Equipped.Primary);
			else if(matcherAsset.group().toLowerCase().contains("secondary"))
				character.setEquipped(Equipped.Secondary);
			else if(matcherAsset.group().toLowerCase().contains("tertiary"))
				character.setEquipped(Equipped.Tertiary);
			else
				character.setEquipped(Equipped.None);
		}
		
		//Get pose and dialogue
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Pose (.*)"));
		if(matcherAsset.matches()) {
			if(matcherAsset.group().toLowerCase().contains("stand"))
				character.setPose(Pose.Stand);
			else if(matcherAsset.group().toLowerCase().contains("sit"))
				character.setPose(Pose.Sit);
			else if(matcherAsset.group().toLowerCase().contains("asleep"))
				character.setPose(Pose.Asleep);
			else if(matcherAsset.group().toLowerCase().contains("passive"))
				character.setPose(Pose.Passive);
			else if(matcherAsset.group().toLowerCase().contains("arrest"))
				character.setPose(Pose.Under_Arrest);
			else if(matcherAsset.group().toLowerCase().contains("rest"))
				character.setPose(Pose.Rest);
			else if(matcherAsset.group().toLowerCase().contains("prone"))
				character.setPose(Pose.Prone);
			else if(matcherAsset.group().toLowerCase().contains("crouch"))
				character.setPose(Pose.Crouch);
			else if(matcherAsset.group().toLowerCase().contains("surrender"))
				character.setPose(Pose.Surrender);
			else {
				character.setPose(Pose.Stand);
			}
		}
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("^Dialogue ([0-9]*)"));
		if(matcherAsset.matches())
			character.setDialogueID(matcherAsset.group(1));
		
		/*
		 * English part
		 */
		matcherEnglish.reset();
		matcherEnglish.usePattern(Pattern.compile("^Character (.*)"));
		if(matcherEnglish.matches()) {
			character.setCharacterName(matcherEnglish.group(1));
			character.setName(matcherEnglish.group(1));
		}
			
		return character;
	}
	private static Vendor CreateVendorFromFile(String[] input) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Dialogue CreateDialogueFromFile(String[] input) {
		// TODO Auto-generated method stub
		return null;
	}
	private static Quest CreateQuestFromDialogue(String[] input) {
		
		return null;
	}
	public static void LoadCharacter() {
		
	}
	public static void SaveVendor(Vendor vendor) {
		//Output
		String[] output = new String[2];
		output[0] = "";
		output[1] = "";
		
		//General information
		if(vendor.getGUID()!=null)
			output[0] += "GUID " + vendor.getGUID() + "\n";
		output[0] += "ID " + vendor.getID() + "\n";
		output[0] += "Type Vendor\n";
		
		//Buying items
		if(vendor.getBuyingItems().size()>0) {
			output[0] += "\nBuying Items\n";
			output[0] += "Buying " + vendor.getBuyingItems().size() + "\n";
			int i = 0;
			for(ItemBuying item : vendor.getBuyingItems()) {
				output[0] += "Buying_" + i + "_ID " + item.getItemID() + "\n";
				output[0] += "Buying_" + i + "_Cost " + item.getCost() + "\n";
				if(item.getConditions()!=null) {
					for(String string : item.getConditions().split("\n"))
						output[0] += "Buying_" + i + "_" + string + "\n";
				}
				i++;
			}
		}
		//Selling items
		if(vendor.getSellingItems().size()>0) {
			output[0] += "\nBuying Items\n";
			output[0] += "Selling " + vendor.getSellingItems().size() + "\n";
			int i = 0;
			for(ItemSelling item : vendor.getSellingItems()) {
				if(item.isVehicle())
					output[0] += "Selling_" + i + "_Type Vehicle\n";
				output[0] += "Selling_" + i + "_ID " + item.getItemID() + "\n";
				output[0] += "Selling_" + i + "_Cost " + item.getCost() + "\n";
				if(item.isVehicle())
					output[0] += "Selling_" + i + "_Spawnpoint " + item.getSpawnpoint() + "\n";
				else
					output[0] += "Selling_" + i + "_Amount " + item.getItemAmount() + "\n";
				if(item.getConditions()!=null) {
					for(String string : item.getConditions().split("\n"))
						output[0] += "Selling_" + i + "_" + string + "\n";
				}
			}
		}
		
		//Watermark
		output[0] += "\n\n//Created with UnturnedNPCCreator by Volcano" ;
		
	}
	public static void SaveDialogue(Dialogue dialogue) {
		//Output
		String[] output = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Assing ID´s to responses
		int i = 0;
		for(Message message : dialogue.getMessages()) {
			for(Response response : message.getResponses()) {
				response.setID(Integer.toString(i++));
			}
		}
		
		//Basic information
		if(dialogue.getGUID()!=null)
			output[0] += "GUID " + dialogue.getGUID() + "\n";
		output[0] += "ID " + dialogue.getID() + "\n";
		
		//Messages
		output[0] += "\nMessages " + dialogue.getMessages().size() + "\n";
		for(i = 0; i < dialogue.getMessages().size(); i++) {
			output[0] += "Message_" + i + "_Pages " + dialogue.getMessages().get(i).getText().split("<p>").length + "\n";
			if(dialogue.getMessages().get(i).getResponses().size()>0) {
				output[0] += "Message_" + i + "_Responses " + dialogue.getMessages().get(i).getResponses().size() + "\n";
				for(int ii = 0; ii < dialogue.getMessages().get(i).getResponses().size(); ii++) {
					output[0] += "Message_" + i + "_Response_" + ii + " " + dialogue.getMessages().get(i).getResponses().get(ii).getID() + "\n";
				}
			}
			if(dialogue.getMessages().get(i).getPreviousDialogueID()!=null) {
				output[0] += "Message_" + i + "_Prev " + dialogue.getMessages().get(i).getPreviousDialogueID() + "\n";
			}
			if(dialogue.getMessages().get(i).getConditions()!=null) {
				for(String string : dialogue.getMessages().get(i).getConditions().split("\n")) {
					output[0] += "Message_" + i + "_" + string + "\n";
				}
			}
			if(dialogue.getMessages().get(i).getConditions()!=null) {
				for(String string : dialogue.getMessages().get(i).getRewards().split("\n")) {
					output[0] += "Message_" + i + "_" + string + "\n";
				}
			}
		}
		
		//Responses
		i = 0;
		output[0] += "\nResponses ";
		for(Message message : dialogue.getMessages())
			i += message.getResponses().size();
				i++;
		output[0] += i + "\n";
		i = 0;
		List<Response> tempList = new ArrayList<Response>();
		for(Message message : dialogue.getMessages()) {
			for(Response response : message.getResponses()) {
				tempList.add(response);
			}
		}
		for(i = 0; i < tempList.size(); i++) {
			for(Response response : tempList) {
				if(Integer.valueOf(response.getID())==i) {
					if(response.getDialogueID()!=null)
						output[0] += "Response_" + i + "_Dialogue " + response.getDialogueID() + "\n";
					if(response.getVendorID()!=null)
						output[0] += "Response_" + i + "_Vendor " + response.getVendorID() + "\n";
					if(response.getQuestID()!=null)
						output[0] += "Response_" + i + "_Quest " + response.getQuestID() + "\n";
					if(response.getConditions()!=null) {
						for(String string : response.getConditions().split("\n"))
							output[0] += "Response_" + i + "_" + string + "\n";
					}
					if(response.getRewards()!=null) {
						for(String string : response.getRewards().split("\n"))
							output[0] += "Response_" + i + "_" + string + "\n";
					}
				}
			}
		}
		
		/*
		 * ENGLISH PART
		 */
		
		//Messages'
		for(i = 0; i < dialogue.getMessages().size(); i++) {
			//If only one page
			if(!dialogue.getMessages().get(i).getText().contains("<p>"))
				output[1] += "Message_" + i + "_Page_0 " + dialogue.getMessages().get(i).getText() + "\n";
			else {
				//If multiple pages
				String[] pages = dialogue.getMessages().get(i).getText().split("<p>");
				for(int ii = 0; ii < pages.length; ii++)
					output[1] += "Message_" + i + "_Page_" + ii + " " + pages[ii] + "\n";
			}
		}
		output[1] += "\n";
		for(i = 0; i < tempList.size(); i++) {
			for(Response response : tempList) {
				if(Integer.valueOf(response.getID())==i) {
					output[1] += "Response_" + i + " " + response.getText() + "\n";
				}
			}
		}
		
		//Watermark
		output[0] += "\n\n//Created with UnturnedNPCCreator by Volcano" ;
	}
	public Vendor LoadVendor() {
		//Get strings from file
		String[] input = LoadFile(getFile());
		
		//Create new vendor object
		Vendor vendor = new Vendor();
		
		//Strings for Asset and English
		String asset = input[0];
		String english = input[1];
		
		//Matchers to be used
		Matcher matcherAsset = Pattern.compile("").matcher(asset);
		Matcher matcherEnglish = Pattern.compile("").matcher(english);
		
		//Vendor is of vendor type
		vendor.setType("Vendor");
		
		//General information
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("[^GU]ID ([0-9]*)"));
		if(matcherAsset.matches())
			vendor.setID(matcherAsset.group(1));
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("GUID (.*)"));
		if(matcherAsset.matches())
			vendor.setGUID(matcherAsset.group(1));
		
		//Get buying items
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("Buying ([0-9]*)"));
		if(matcherAsset.find()) {
			//Found items the vendor is buying
			//Generate items
			for(int i = 0; i < Integer.valueOf(matcherAsset.group(1)); i++)
				vendor.addBuyingItem(new ItemBuying());
			//Get item ID's
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Buying_([0-9]+)_ID ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getBuyingItems().get(Integer.valueOf(matcherAsset.group(1))).setItemID(matcherAsset.group(2));
			//Get item costs
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Buying_([0-9]+)_Cost ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getBuyingItems().get(Integer.valueOf(matcherAsset.group(1))).setCost(matcherAsset.group(2));
			//Get item amounts
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Buying_([0-9]+)_Amount ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getBuyingItems().get(Integer.valueOf(matcherAsset.group(1))).setItemAmount(matcherAsset.group(2));
			//Get item conditions
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Buying_([0-9]+)_(Condition.*)"));
			while(matcherAsset.matches())
				vendor.getBuyingItems().get(Integer.valueOf(matcherAsset.group(1))).addToConditions(matcherAsset.group(2));
		}
		
		//Get selling items
		matcherAsset.reset();
		matcherAsset.usePattern(Pattern.compile("Selling ([0-9]*)"));
		if(matcherAsset.find()) {
			//Found items the vendor is selling
			//Generate items
			for(int i = 0; i < Integer.valueOf(matcherAsset.group(1)); i++)
				vendor.addSellingItem(new ItemSelling());
			//Get item ID's
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_ID ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).setItemID(matcherAsset.group(2));
			//Get item costs
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_Cost ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).setCost(matcherAsset.group(2));
			//Check if item is a vehicle
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_Type Vehicle"));
			while(matcherAsset.find())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).setVehicle(true);
			//Get Spawnpoints for all vehicles
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_Spawnpoint (.*)"));
			while(matcherAsset.find())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).setSpawnpoint(matcherAsset.group(2));
			//Get item amounts
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_Amount ([0-9]*)"));
			while(matcherAsset.find())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).setItemAmount(matcherAsset.group(2));
			//Get item conditions
			matcherAsset.reset();
			matcherAsset.usePattern(Pattern.compile("Selling_([0-9]+)_(Condition.*)"));
			while(matcherAsset.matches())
				vendor.getSellingItems().get(Integer.valueOf(matcherAsset.group(1))).addToConditions(matcherAsset.group(2));
		}
		
		/*
		 * English part
		 */
		//Get name
		matcherEnglish.reset();
		matcherEnglish.usePattern(Pattern.compile("Name (.*)\n"));
		if(matcherEnglish.matches())
			vendor.setName(matcherEnglish.group(1));
		//Get description
		matcherEnglish.reset();
		matcherEnglish.usePattern(Pattern.compile("Description (.*)[\n$]*"));
		if(matcherEnglish.matches())
			vendor.setDescription(matcherEnglish.group(1));
		
		return vendor;
	}
	public Object LoadFile(JPanel panel, String loadType) {
		String[] output = new String[2];
		output[0] = "";
		output[1] = "";
		File[] files = new File[2];
		FileChooser fileChooser = new FileChooser();
		String filepath = fileChooser.showOpenDialog(null).getAbsolutePath();
		files[0] = new File(filepath + "/Asset.dat");
		files[1] = new File(filepath + "/English.dat");
		for(int i = 0; i < 2; i++) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(files[i]));
				String nextLine = reader.readLine();
				while(nextLine!=null) {
					output[i] += nextLine;
					nextLine = reader.readLine();
				}
				reader.close();
				Matcher matcher = Pattern.compile("^Type (.*)$").matcher(output[0]);
				if(matcher.find()) {
					//Loadtype is if you want to open files of a special type, and give a error if you for example try to open a character from the vendor panel.
					if(loadType!=null) {
						//Load a special type, error if loaded wrong type
						if(!matcher.group(1).toLowerCase().contains(loadType)) {
							return null;
						}
					}
					//Load whatever type and open appropriate window for it.
					if(matcher.group(1).toLowerCase().contains("type npc")) {
						NPCCharacter character = CreateCharacterFromFile(output);
						loadedCharacters.add(character);
						return character;
					} else if(matcher.group(1).toLowerCase().contains("vendor")) {
						
					} else if(matcher.group(1).toLowerCase().contains("dialogue")) {
						
					} else if(matcher.group(1).toLowerCase().contains("quest")) {
						
					} else {
						//Could not resolve filetype
					}
				}
			} catch ( IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	public static File[] getFile() {
		//Files to return
		File[] files = new File[2];
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	chooser.getSelectedFile().getName();
	    	files[0] = new File(chooser.getSelectedFile().getAbsolutePath() + "/Asset.dat");
			files[1] = new File(chooser.getSelectedFile().getAbsolutePath() + "/English.dat");
	    }
		
		
//		File file = new FileChooser().showOpenDialog(null);
//		files[0] = new File(file.getAbsolutePath() + "/Asset.dat");
//		files[1] = new File(file.getAbsolutePath() + "/English.dat");
		
		return files;
	}
	public static void writeFile(String[] output, File[] files) {
		try {
			BufferedWriter writer;
			for(int i = 0; i < 2; i++) {
				writer = new BufferedWriter(new FileWriter(files[i]));
				writer.write(output[i]);
				writer.close();
			}
		} catch (IOException e) {
			/*
			 * Add custom error dialog here
			 */
			
			e.printStackTrace();
		}
	}
	public static String[] LoadFile(File[] files) {
		BufferedReader reader;
		String[] output = new String[2];
		String nextLine;
		try {
			for(int i = 0; i < 2; i++) {
				output[i] = "";
				reader = new BufferedReader(new FileReader(files[i]));
				nextLine = reader.readLine();
				while(nextLine!=null) {
					output[i] += nextLine;
					nextLine = reader.readLine();
				}
			}
			
			return output;
		} catch (IOException e) {
			/*
			 * Add custom error dialog here
			 */
			
			e.printStackTrace();
		}
		return null;
	}
	public NPCCharacter getCharacter() {
		// TODO Auto-generated method stub
		return null;
	}
	public String OpenConditions(String conditions) {
		return conditionsDialog.ConditionsDialog(conditions);
	}
	public String OpenRewards(String rewards) {
		return RewardsDialog.Dialog(rewards);
	}
}
