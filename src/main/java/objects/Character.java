package objects;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import objects.condition.Condition;

public class Character {
	
	private String name;
	private int ID;
	private String GUID;
	
	private File file;
	
	private int face = -1;
	private int hair = -1;
	private int beard = -1;
	private Color skinColor = new Color(0xffffff);
	private Color hairColor = new Color(0xffffff);
	
	private int shirt = -1;
	private int pants = -1;
	private int hat = -1;
	private int backpack = -1;
	private int vest = -1;
	private int glasses = -1;
	private int mask = -1;
	private int shirtHalloween = -1;
	private int pantsHalloween = -1;
	private int hatHalloween = -1;
	private int backpackHalloween = -1;
	private int vestHalloween = -1;
	private int glassesHalloween = -1;
	private int maskHalloween = -1;
	private int shirtChristmas = -1;
	private int pantsChristmas = -1;
	private int hatChristmas = -1;
	private int backpackChristmas = -1;
	private int vestChristmas = -1;
	private int glassesChristmas = -1;
	private int maskChristmas = -1;
	
	private boolean halloweenClothing, christmasClothing;
	
	private boolean backwards;
	
	private int primary, secondary, tertiary;
	
	private Equipped equipped = Equipped.None;
	
	private Pose pose = Pose.Stand;
	
	private List<Condition> conditions = new ArrayList<>();
	private int dialogueID;
	
	public boolean hasHalloweenClothing() {
		if(shirtHalloween + pantsHalloween + hatHalloween + backpackHalloween + vestHalloween + glassesHalloween + maskHalloween > -7)
			return true;
		return false;
	}
	
	public boolean hasChristmasClothing() {
		if(shirtChristmas + pantsChristmas + hatChristmas + backpackChristmas + vestChristmas + glassesChristmas + maskChristmas > -7)
			return true;
		return false;
	}
	
	public void printToConsole() {
		for(Field field : this.getClass().getDeclaredFields()) {
			try {
				System.out.println(field.getName() + ":\t\t" + field.get(this));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Getters & Setters
	 */
	
	public boolean isHalloweenClothing() {
		return halloweenClothing;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public void setHalloweenClothing(boolean halloweenClothing) {
		this.halloweenClothing = halloweenClothing;
	}

	public boolean isChristmasClothing() {
		return christmasClothing;
	}

	public void setChristmasClothing(boolean christmasClothing) {
		this.christmasClothing = christmasClothing;
	}

	public String getGUID() {
		return GUID;
	}
	
	public void setGUID(String gUID) {
		GUID = gUID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public int getHair() {
		return hair;
	}

	public void setHair(int hair) {
		this.hair = hair;
	}

	public int getBeard() {
		return beard;
	}

	public void setBeard(int beard) {
		this.beard = beard;
	}

	public Color getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(Color skinColor) {
		this.skinColor = skinColor;
	}

	public Color getHairColor() {
		return hairColor;
	}

	public void setHairColor(Color hairColor) {
		this.hairColor = hairColor;
	}

	public int getShirt() {
		return shirt;
	}

	public void setShirt(int shirt) {
		this.shirt = shirt;
	}

	public int getPants() {
		return pants;
	}

	public void setPants(int pants) {
		this.pants = pants;
	}

	public int getHat() {
		return hat;
	}

	public void setHat(int hat) {
		this.hat = hat;
	}

	public int getBackpack() {
		return backpack;
	}

	public void setBackpack(int backpack) {
		this.backpack = backpack;
	}

	public int getVest() {
		return vest;
	}

	public void setVest(int vest) {
		this.vest = vest;
	}

	public int getGlasses() {
		return glasses;
	}

	public void setGlasses(int glasses) {
		this.glasses = glasses;
	}

	public int getMask() {
		return mask;
	}

	public void setMask(int mask) {
		this.mask = mask;
	}

	public int getShirtHalloween() {
		return shirtHalloween;
	}

	public void setShirtHalloween(int shirtHalloween) {
		this.shirtHalloween = shirtHalloween;
	}

	public int getPantsHalloween() {
		return pantsHalloween;
	}

	public void setPantsHalloween(int pantsHalloween) {
		this.pantsHalloween = pantsHalloween;
	}

	public int getHatHalloween() {
		return hatHalloween;
	}

	public void setHatHalloween(int hatHalloween) {
		this.hatHalloween = hatHalloween;
	}

	public int getBackpackHalloween() {
		return backpackHalloween;
	}

	public void setBackpackHalloween(int backpackHalloween) {
		this.backpackHalloween = backpackHalloween;
	}

	public int getVestHalloween() {
		return vestHalloween;
	}

	public void setVestHalloween(int vestHalloween) {
		this.vestHalloween = vestHalloween;
	}

	public int getGlassesHalloween() {
		return glassesHalloween;
	}

	public void setGlassesHalloween(int glassesHalloween) {
		this.glassesHalloween = glassesHalloween;
	}

	public int getMaskHalloween() {
		return maskHalloween;
	}

	public void setMaskHalloween(int maskHalloween) {
		this.maskHalloween = maskHalloween;
	}

	public int getShirtChristmas() {
		return shirtChristmas;
	}

	public void setShirtChristmas(int shirtChristmas) {
		this.shirtChristmas = shirtChristmas;
	}

	public int getPantsChristmas() {
		return pantsChristmas;
	}

	public void setPantsChristmas(int pantsChristmas) {
		this.pantsChristmas = pantsChristmas;
	}

	public int getHatChristmas() {
		return hatChristmas;
	}

	public void setHatChristmas(int hatChristmas) {
		this.hatChristmas = hatChristmas;
	}

	public int getBackpackChristmas() {
		return backpackChristmas;
	}

	public void setBackpackChristmas(int backpackChristmas) {
		this.backpackChristmas = backpackChristmas;
	}

	public int getVestChristmas() {
		return vestChristmas;
	}

	public void setVestChristmas(int vestChristmas) {
		this.vestChristmas = vestChristmas;
	}

	public int getGlassesChristmas() {
		return glassesChristmas;
	}

	public void setGlassesChristmas(int glassesChristmas) {
		this.glassesChristmas = glassesChristmas;
	}

	public int getMaskChristmas() {
		return maskChristmas;
	}

	public void setMaskChristmas(int maskChristmas) {
		this.maskChristmas = maskChristmas;
	}

	public boolean isBackwards() {
		return backwards;
	}

	public void setBackwards(boolean backwards) {
		this.backwards = backwards;
	}

	public int getPrimary() {
		return primary;
	}

	public void setPrimary(int primary) {
		this.primary = primary;
	}

	public int getSecondary() {
		return secondary;
	}

	public void setSecondary(int secondary) {
		this.secondary = secondary;
	}

	public int getTertiary() {
		return tertiary;
	}

	public void setTertiary(int tertiary) {
		this.tertiary = tertiary;
	}

	public Equipped getEquipped() {
		return equipped;
	}

	public void setEquipped(Equipped equipped) {
		this.equipped = equipped;
	}

	public Pose getPose() {
		return pose;
	}

	public void setPose(Pose pose) {
		this.pose = pose;
	}

	public int getDialogueID() {
		return dialogueID;
	}

	public void setDialogueID(int dialogueID) {
		this.dialogueID = dialogueID;
	}
	
}