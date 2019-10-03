package utility;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import objects.Character;
import objects.Equipped;
import objects.ItemBuying;
import objects.ItemSelling;
import objects.Pose;
import objects.Type;
import objects.Vendor;
import objects.condition.Condition;
import objects.condition.ConditionType;
import objects.condition.Logic;
import objects.condition.Skillset;
import objects.condition.Status;
import objects.condition.Zombie;
import objects.condition.types.ConditionCompareFlags;
import objects.condition.types.ConditionExperience;
import objects.condition.types.ConditionFlagBool;
import objects.condition.types.ConditionFlagShort;
import objects.condition.types.ConditionItem;
import objects.condition.types.ConditionKillsAnimal;
import objects.condition.types.ConditionKillsHorde;
import objects.condition.types.ConditionKillsObject;
import objects.condition.types.ConditionKillsPlayer;
import objects.condition.types.ConditionKillsZombie;
import objects.condition.types.ConditionQuest;
import objects.condition.types.ConditionReputation;
import objects.condition.types.ConditionSkillset;
import objects.condition.types.ConditionTimeOfDay;

public class FileIO {
	
	static Matcher matcher;
	
	public static Object loadFromFile(File file) {
		
		switch(getType(file)) {
		case Character:
			return loadCharacter(file);
		case Dialogue:
			break;
		case Quest:
			break;
		case Vendor:
			return loadVendor(file);
		default:
			System.out.println("Error; Coult not get asset.dat type.");
			break;
		}
		
		return null;
	}
	
	public void saveToFile(File file, Object object) {
		
		if(object.getClass().equals(Character.class)) {
			saveCharacter(file, (Character) object);
		} else if (object.getClass().equals(Vendor.class)) {
			saveVendor(file, (Vendor) object);
		}
		
	}
	
	/*
	 * Utility methods
	 */
	
	public static Type getType(File file) {
		for(File f : file.listFiles()) {
			if(f.getName().equalsIgnoreCase("Asset.dat")) {
				String string = getTextFromFile(f);
				switch (getString(string, "^TYPE (\\w*)$").toLowerCase()) {
				case "npc":
					return Type.Character;
				case "vendor":
					return Type.Vendor;
				case "dialogue":
					return Type.Dialogue;
				case "quest":
					return Type.Quest;
				default:
					break;
				}
			}
		}
		return null;
	}
	
	private static String getTextFromFile(File file) {
		//Create string builder
		StringBuilder stringBuilder = new StringBuilder();
		
		//Read file
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line!=null) {
				stringBuilder.append(line);
				line = reader.readLine();
				if(line!=null) stringBuilder.append("\n");
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		//Return a string
		return stringBuilder.toString();
	}
	
	private static String getString(String string, String regex) {
		if(string == null || regex == null)
			return null;
		matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE).matcher(string);
		if(matcher.find())
			return matcher.group(1);
		else
			return null;
	}
	
	private static Integer getInt(String string, String regex) {
		String string2 = getString(string, regex);
		if(string2!=null)
			return Integer.valueOf(string2);
		else
			return -1;
	}
	
	private static Integer getInt(String string, String regex, int defaultValue) {
		String string2 = getString(string, regex);
		if(string2!=null)
			return Integer.valueOf(string2);
		else
			return defaultValue;
	}
	
	private static boolean getBoolean(String string, String regex) {
		return Boolean.valueOf(getString(string, regex));
	}
	
	private static Integer getValue(String string, String key) {
		return getInt(string, "[^_]" + key + " (\\d*)");
	}
	
	private static Integer getValue(String string, String key, int defaultValue) {
		return getInt(string, "[^_]" + key + " (\\d*)", defaultValue);
	}
	
	private static String getValueAsString(String string, String key) {
		return getString(string, "[\n\r]?" + key + " (\\w*)");
	}
	
	private static Color getColor(String string, String key) {
		String colorString = getString(string, key + " #([^\n\r$ ]{6})");
		if(colorString==null)
			return null;
		return new Color(Integer.parseInt(colorString, 16));
	}
	
	private static void append(StringBuilder stringBuilder, String string, String value) {
		if(value==null)
			return;
		stringBuilder.append(string + " " + value + "\n");
	}
	
	private static void appendExclude(StringBuilder stringBuilder, String string, String value, String exclude) {
		if(value.equalsIgnoreCase(exclude))
			return;
		append(stringBuilder, string, value);
	}
	
	private static void appendExcludeDefault(StringBuilder stringBuilder, String string, String value, String exclude, String defaultValue) {
		if(value==null)
			value = defaultValue;
		if(value.equalsIgnoreCase(exclude))
			return;
		append(stringBuilder, string, value);
	}
	
	private static void append(StringBuilder stringBuilder, String string, int value) {
		if(value==-1)
			return;
		append(stringBuilder, string, Integer.toString(value));
	}
	
	private static void appendNoZero(StringBuilder stringBuilder, String string, int value) {
		if(value==0)
			return;
		append(stringBuilder, string, value);
	}
	
	public static String[] getCharacterText(Character character) {
		StringBuilder assetStringBuilder = new StringBuilder();
		StringBuilder englishStringBuilder = new StringBuilder();
		
		append(assetStringBuilder, "GUID", character.getGUID());
		assetStringBuilder.append("Type NPC\n");
		append(assetStringBuilder, "ID", character.getID());
		assetStringBuilder.append("\n");
		append(assetStringBuilder, "Shirt", character.getShirt());
		append(assetStringBuilder, "Pants", character.getPants());
		append(assetStringBuilder, "Backpack", character.getBackpack());
		append(assetStringBuilder, "Vest", character.getVest());
		append(assetStringBuilder, "Mask", character.getMask());
		append(assetStringBuilder, "Glasses", character.getGlasses());
		if(character.hasHalloweenClothing()) {
			assetStringBuilder.append("\n");
			assetStringBuilder.append("Has_Halloween_Outfit True\n");
			append(assetStringBuilder, "Halloween_Shirt", character.getShirtHalloween());
			append(assetStringBuilder, "Halloween_Pants", character.getPantsHalloween());
			append(assetStringBuilder, "Halloween_Backpack", character.getBackpackHalloween());
			append(assetStringBuilder, "Halloween_Vest", character.getVestHalloween());
			append(assetStringBuilder, "Halloween_Mask", character.getMaskHalloween());
			append(assetStringBuilder, "Halloween_Glasses", character.getGlassesHalloween());
		}
		if(character.hasChristmasClothing()) {
			assetStringBuilder.append("\n");
			assetStringBuilder.append("Has_Christmas_Outfit True\n");
			append(assetStringBuilder, "Christmas_Shirt", character.getShirtChristmas());
			append(assetStringBuilder, "Christmas_Pants", character.getPantsChristmas());
			append(assetStringBuilder, "Christmas_Backpack", character.getBackpackChristmas());
			append(assetStringBuilder, "Christmas_Vest", character.getVestChristmas());
			append(assetStringBuilder, "Christmas_Mask", character.getMaskChristmas());
			append(assetStringBuilder, "Christmas_Glasses", character.getGlassesChristmas());
		}
		assetStringBuilder.append("\n");
		appendExclude(assetStringBuilder, "Pose", character.getPose().toString(), "Stand");
		appendNoZero(assetStringBuilder, "Face", character.getFace());
		appendNoZero(assetStringBuilder, "Hair", character.getFace());
		appendNoZero(assetStringBuilder, "Beard", character.getFace());
		appendExcludeDefault(assetStringBuilder, "Color_Skin", "#" + Integer.toHexString(character.getSkinColor().getRGB()), "#FFFFFF", "#FFFFFF");
		appendExcludeDefault(assetStringBuilder, "Color_Hair", "#" + Integer.toHexString(character.getHairColor().getRGB()), "#FFFFFF", "#FFFFFF");
		
		assetStringBuilder.append("\n");
		appendNoZero(assetStringBuilder, "Primary", character.getPrimary());
		appendNoZero(assetStringBuilder, "Secondary", character.getSecondary());
		appendNoZero(assetStringBuilder, "Tertiary", character.getTertiary());
		appendExclude(assetStringBuilder, "Equipped", character.getEquipped().toString(), "None");
		appendExclude(assetStringBuilder, "Backwards", Boolean.toString(character.isBackwards()), "False");
		
		assetStringBuilder.append("\n");
		append(assetStringBuilder, "Dialogue", character.getDialogueID());
		
		append(englishStringBuilder, "Name", character.getName());
		
		String[] returnString = new String[2];
		returnString[0] = assetStringBuilder.toString();
		returnString[1] = englishStringBuilder.toString();
		
		return returnString;
	}
	
	private static List<Condition> getConditions(String string) {
		HashMap<Integer, Condition> map = new HashMap<>();
		
		/*
		 * 	Check so each condition line from same group of conditions starts with the same text, ie "selling_0_" or "response_0_".
		 * 	This is to prevent conditions from different "items" matching due to having the same local index
		 */
		
		matcher = Pattern.compile("Condition_(\\d+)_Type (.*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE).matcher(string.trim());
		while(matcher.find()) {
			Condition condition;
			int index = Integer.valueOf(matcher.group(1));
			switch(ConditionType.valueOf(matcher.group(2))) {
			case Compare_Flags:
				condition = new ConditionCompareFlags();
				((ConditionCompareFlags) condition).setA(getInt(string, index + "_A (\\d*)"));
				((ConditionCompareFlags) condition).setAllowAUnset(getBoolean(string, index + "_Allow_A_Unset (\\w*)"));
				((ConditionCompareFlags) condition).setB(getInt(string, index + "_B (\\d*)"));
				((ConditionCompareFlags) condition).setAllowBUnset(getBoolean(string, index + "_Allow_B_Unset (\\w*)"));
				break;
			case Experience:
				condition = new ConditionExperience();
				((ConditionExperience) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				break;
			case Flag_Bool:
				condition = new ConditionFlagBool();
				System.out.println("Here: " + string);
				((ConditionFlagBool) condition).setID(getInt(string, index + "_Condition_\\d*_ID (\\d+)"));
				((ConditionFlagBool) condition).setValue(getBoolean(string, index + "_Value (\\w*)"));
				((ConditionFlagBool) condition).setAllowUnset(getBoolean(string, index + "_Allow_Unset (\\w*)"));
				break;
			case Flag_Short:
				condition = new ConditionFlagShort();
				((ConditionFlagShort) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionFlagShort) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionFlagShort) condition).setAllowUnset(getBoolean(string, index + "_Allow_Unset (\\w*)"));
				break;
			case Item:
				condition = new ConditionItem();
				((ConditionItem) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionItem) condition).setAmount(getInt(string, index + "_Condition_\\d+_Amount (\\d*)"));
				break;
			case Kills_Animal:
				condition = new ConditionKillsAnimal();
				((ConditionKillsAnimal) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionKillsAnimal) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionKillsAnimal) condition).setAnimal(getInt(string, index + "_Animal (\\d*)"));
				break;
			case Kills_Horde:
				condition = new ConditionKillsHorde();
				((ConditionKillsHorde) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionKillsHorde) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionKillsHorde) condition).setNav(getInt(string, index + "_Nav (\\d*)"));
				break;
			case Kills_Object:
				condition = new ConditionKillsObject();
				((ConditionKillsObject) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionKillsObject) condition).setObjectGUID(getString(string, index + "_object ([\\w\\d]*)"));
				((ConditionKillsObject) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionKillsObject) condition).setNav(getInt(string, index + "_Nav (\\d*)"));
				break;
			case Kills_Player:
				condition = new ConditionKillsPlayer();
				((ConditionKillsPlayer) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionKillsPlayer) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				break;
			case Kills_Zombies:
				condition = new ConditionKillsZombie();
				((ConditionKillsZombie) condition).setID(getInt(string, index + "_Condition_\\d+_ID (\\d*)"));
				((ConditionKillsZombie) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				((ConditionKillsZombie) condition).setNav(getInt(string, index + "_Nav (\\d*)"));
				((ConditionKillsZombie) condition).setSpawn(getBoolean(string, index + "_Spawn (\\w*)"));
				((ConditionKillsZombie) condition).setZombie(Zombie.valueOf(getString(string, index + "_Zombie (\\w*)")));
				break;
			case Quest:
				condition = new ConditionQuest();
				((ConditionQuest) condition).setID(getInt(string, index + "_Value (\\d*)"));
				((ConditionQuest) condition).setStatus(Status.valueOf(getString(string, index + "_Status (\\w*)")));
				break;
			case Reputation:
				condition = new ConditionReputation();
				((ConditionReputation) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				break;
			case Skillset:
				condition = new ConditionSkillset();
				((ConditionSkillset) condition).setValue(Skillset.valueOf(getString(string, index + "_Value (\\w*)")));
				break;
			case Time_Of_Day:
				condition = new ConditionTimeOfDay();
				((ConditionTimeOfDay) condition).setSeconds(getInt(string, index + "_Seconds (\\d*)"));
				break;
			default:
				condition = new ConditionExperience();
				((ConditionExperience) condition).setValue(getInt(string, index + "_Value (\\d*)"));
				break;
			}
			condition.setLogic(Logic.valueOf(getString(string, index + "_Logic ([A-z_]+)")));
			condition.setReset(Boolean.valueOf(getString(string, index + "_Reset ([A-z]+)")));
			map.put(index, condition);
		}
		
		List<Condition> conditions = new ArrayList<>();
		
		for(int i = 0; i < map.size(); i++) {
			int lowestKey = -1;
			for(int key : map.keySet()) {
				if(lowestKey == -1 || lowestKey > key) {
					lowestKey = key;
				}
				conditions.add(map.get(lowestKey));
				map.remove(lowestKey);
			}
		}
		
		return conditions;
	}
	
	/*
	 * Pasters
	 */
	
	private static Character loadCharacter(File dir) {
		Character character = new Character();
		
		File assetFile = null;
		File englishFile = null;
		
		for(File file : dir.listFiles()) {
			if(file.getName().equalsIgnoreCase("asset.dat"))
				assetFile = file;
			if(file.getName().equalsIgnoreCase("english.dat"))
				englishFile = file;
		}
		
		String characterAsset = null;
		String characterEnglish = null;
		
		//Spaces added so getValue can match with [^_] even if its the begining of the file
		if(assetFile!=null)
			characterAsset = " " + getTextFromFile(assetFile);
		if(englishFile!=null)
			characterEnglish = " " + getTextFromFile(englishFile);
		
		character.setFile(dir);
		
		character.setID(getInt(characterAsset, "[^U]ID ([\\d]*)"));
		character.setGUID(getValueAsString(characterAsset, "GUID"));
		character.setName(getValueAsString(characterEnglish, "Name"));
		
		character.setShirt(getValue(characterAsset, "Shirt"));
		character.setPants(getValue(characterAsset, "Pants"));
		character.setHat(getValue(characterAsset, "Hat"));
		character.setBackpack(getValue(characterAsset, "Backpack"));
		character.setVest(getValue(characterAsset, "Vest"));
		character.setMask(getValue(characterAsset, "Mask"));
		character.setGlasses(getValue(characterAsset, "Glasses"));
		
		character.setShirtHalloween(getValue(characterAsset, "Halloween_Shirt"));
		character.setPantsHalloween(getValue(characterAsset, "Halloween_Pants"));
		character.setHatHalloween(getValue(characterAsset, "Halloween_Hat"));
		character.setBackpackHalloween(getValue(characterAsset, "Halloween_Backpack"));
		character.setVestHalloween(getValue(characterAsset, "Halloween_Vest"));
		character.setMaskHalloween(getValue(characterAsset, "Halloween_Mask"));
		character.setGlassesHalloween(getValue(characterAsset, "Halloween_Glasses"));
		
		character.setHalloweenClothing(character.hasHalloweenClothing());
		
		character.setShirtChristmas(getValue(characterAsset, "Christmas_Shirt"));
		character.setPantsChristmas(getValue(characterAsset, "Christmas_Pants"));
		character.setHatChristmas(getValue(characterAsset, "Christmas_Hat"));
		character.setBackpackChristmas(getValue(characterAsset, "Christmas_Backpack"));
		character.setVestChristmas(getValue(characterAsset, "Christmas_Vest"));
		character.setMaskChristmas(getValue(characterAsset, "Christmas_Mask"));
		character.setGlassesChristmas(getValue(characterAsset, "Christmas_Glasses"));
		
		character.setChristmasClothing(character.hasChristmasClothing());
		
		character.setFace(getValue(characterAsset, "Face", 0));
		character.setHair(getValue(characterAsset, "Hair", 0));
		character.setBeard(getValue(characterAsset, "Beard", 0));
		
		character.setSkinColor(getColor(characterAsset, "Color_Skin"));
		character.setHairColor(getColor(characterAsset, "Color_Hair"));
		
		character.setBackwards(Boolean.valueOf(getValueAsString(characterAsset, "Backwards")));
		
		character.setPrimary(getValue(characterAsset, "Primary"));
		character.setSecondary(getValue(characterAsset, "Secondary"));
		character.setTertiary(getValue(characterAsset, "Tertiary"));
		String eqipped = getValueAsString(characterAsset, "Equipped");
		if(eqipped!=null)
			character.setEquipped(Equipped.valueOf(getValueAsString(characterAsset, "Equipped")));
		
		String pose = getValueAsString(characterAsset, "Pose");
		if(pose!=null)
			character.setPose(Pose.valueOf(pose));
		
		character.setDialogueID(getValue(characterAsset, "Dialogue"));
		
		character.printToConsole();
		
		return character;
	}
	
	public static String[] getVendorText(Vendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static Vendor loadVendor(File dir) {
		Vendor vendor = new Vendor();
		
		File assetFile = null;
		File englishFile = null;
		
		for(File file : dir.listFiles()) {
			if(file.getName().equalsIgnoreCase("asset.dat"))
				assetFile = file;
			if(file.getName().equalsIgnoreCase("english.dat"))
				englishFile = file;
		}
		
		String vendorAsset = null;
		String vendorEnglish = null;
		
		//Spaces added so getValue can match with [^_] even if its the begining of the file
		if(assetFile!=null)
			vendorAsset = " " + getTextFromFile(assetFile);
		if(englishFile!=null)
			vendorEnglish = " " + getTextFromFile(englishFile);
		
		vendor.setFile(dir);
		
		vendor.setID(getInt(vendorAsset, "[^U]ID ([\\d]*)"));
		vendor.setGUID(getValueAsString(vendorAsset, "GUID"));
		vendor.setName(getString(vendorEnglish, "Name ([^\n\r$]*)"));
		vendor.setDescription(getString(vendorEnglish, "Description ([^\n\r$]*)"));
		
		System.out.println(vendorAsset);
		
		HashMap<Integer, String> mapBuying = new HashMap<>();
		matcher = Pattern.compile("^Buying_(\\d+)_(.*)", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(vendorAsset);
		while(matcher.find()) {
			int index = Integer.valueOf(matcher.group(1));
			if(mapBuying.containsKey(Integer.valueOf(matcher.group(1))))
				mapBuying.replace(index, mapBuying.get(index) + "\n" + matcher.group(0));
			else
				mapBuying.put(Integer.valueOf(matcher.group(1)), matcher.group(0));
		}
		HashMap<Integer, String> mapSelling = new HashMap<>();
		matcher = Pattern.compile("^Selling_(\\d+)_(.*)", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE).matcher(vendorAsset);
		while(matcher.find()) {
			int index = Integer.valueOf(matcher.group(1));
			if(mapSelling.containsKey(Integer.valueOf(matcher.group(1))))
				mapSelling.replace(index, mapSelling.get(index) + "\n" + matcher.group(0));
			else
				mapSelling.put(Integer.valueOf(matcher.group(1)), matcher.group(0));
		}
		
		for(String string : mapBuying.values()) {
			ItemBuying item = new ItemBuying();
			item.setItemID(getInt(string, "Buying_[\\d]+_ID (\\d+)"));
			item.setAmount(getInt(string, "Buying_[\\d]+_Amount (\\d+)"));
			item.setCost(getInt(string, "Buying_[\\d]+_Cost (\\d+)"));
			item.setConditions(getConditions(string));
			vendor.addBuyingItem(item);
		}
		for(String string : mapSelling.values()) {
			ItemSelling item = new ItemSelling();
			item.setItemID(getInt(string, "Selling_[\\d]+_ID (\\d+)"));
			item.setAmount(getInt(string, "Selling_[\\d]+_Amount (\\d+)"));
			item.setCost(getInt(string, "Selling_[\\d]+_Cost (\\d+)"));
			item.setSpawnpoint(getString(string, "Selling_[\\d]+_Spawnpoint (.*)"));
			item.setVehicle(getString(string, "Selling_[\\d]+_Type Vehicle") != null);
			item.setConditions(getConditions(string));
			vendor.addSellingItem(item);
		}
		
		return vendor;
	}

	public void saveCharacter(File file, Character character) {
		String[] strings = getCharacterText(character);
		
		File assetFile = new File(file.getAbsolutePath() + "\\Asset.dat");
		File englishFile = new File(file.getAbsolutePath() + "\\English.dat");
		try {
			if(!assetFile.createNewFile() || !englishFile.createNewFile()) {
				//failed to create files
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		writeToFile(assetFile, strings[0]);
		writeToFile(englishFile, strings[1]);
	}
	
	private void saveVendor(File file, Vendor vendor) {
		
		
		
	}

	private void writeToFile(File file, String string) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}