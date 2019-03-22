package models;

import java.awt.Color;

public class NPCCharacter {
	
	final String type = "NPC";
	String GUID;
	int ID;
	String path;
	String name;
	String editorName;
	String characterName;
	//0 is for normal, 1 is for christmas clothing, 2 is for halloween clothing
	String[] shirt = new String[3];
	String[] pants = new String[3];
	String[] hat = new String[3];
	String[] backpack = new String[3];
	String[] vest = new String[3];
	String[] mask = new String[3];
	String[] glasses = new String[3];
	String face = "0";
	String hair = "0";
	String beard = "0";
	Color skinColor = Color.WHITE;
	Color hairColor = Color.WHITE;
	boolean backwards = false;
	String primary;
	String secondary;
	String tertiary;
	Equipped equipped = Equipped.None;
	String dialogueID;
	Pose pose = Pose.Stand;
	boolean christmasClothing = false;
	boolean halloweenClothing = false;

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String GUID) {
		this.GUID = GUID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	public String getBeard() {
		return beard;
	}

	public void setBeard(String beard) {
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

	public boolean isBackwards() {
		return backwards;
	}

	public void setBackwards(boolean backwards) {
		this.backwards = backwards;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public String getTertiary() {
		return tertiary;
	}

	public void setTertiary(String tertiary) {
		this.tertiary = tertiary;
	}

	public String getEquipped() {
		return equipped.getType();
	}

	public String getDialogueID() {
		return dialogueID;
	}

	public void setDialogueID(String dialogueID) {
		this.dialogueID = dialogueID;
	}

	public String getPose() {
		return pose.getType();
	}

	public void setPose(Pose pose) {
		this.pose = pose;
	}

	public void setEquipped(Equipped equipped) {
		this.equipped = equipped;
	}
	
	public boolean hasChristmasClothing() {
		return christmasClothing;
	}

	public void setChristmasClothing(boolean christmasClothing) {
		this.christmasClothing = christmasClothing;
	}

	public boolean hasHalloweenClothing() {
		return halloweenClothing;
	}

	public void setHalloweenClothing(boolean halloweenClothing) {
		this.halloweenClothing = halloweenClothing;
	}

	public String getType() {
		return type;
	}
	
	public String getShirt() {
		return shirt[0];
	}
	public String getPants() {
		return pants[0];
	}
	public String getHat() {
		return hat[0];
	}
	public String getVest() {
		return vest[0];
	}
	public String getMask() {
		return mask[0];
	}
	public String getBackpack() {
		return backpack[0];
	}
	public String getGlasses() {
		return glasses[0];
	}
	public String getChristmasShirt() {
		return shirt[1];
	}
	public String getChristmasPants() {
		return pants[1];
	}
	public String getChristmasHat() {
		return hat[1];
	}
	public String getChristmasVest() {
		return vest[1];
	}
	public String getChristmasMask() {
		return mask[1];
	}
	public String getChristmasBackpack() {
		return backpack[1];
	}
	public String getChristmasGlasses() {
		return glasses[1];
	}
	public String getHalloweenShirt() {
		return shirt[2];
	}
	public String getHalloweenPants() {
		return pants[2];
	}
	public String getHalloweenHat() {
		return hat[2];
	}
	public String getHalloweenVest() {
		return vest[2];
	}
	public String getHalloweenMask() {
		return mask[2];
	}
	public String getHalloweenBackpack() {
		return backpack[2];
	}
	public String getHalloweenGlasses() {
		return glasses[2];
	}
	public void setShirt(String shirt) {
		this.shirt[0] = shirt;
	}
	public void setPants(String pants) {
		this.pants[0] = pants;
	}
	public void setHat(String hat) {
		this.hat[0] = hat;
	}
	public void setVest(String vest) {
		this.vest[0] = vest;
	}
	public void setMask(String mask) {
		this.mask[0] = mask;
	}
	public void setBackpack(String backpack) {
		this.backpack[0] = backpack;
	}
	public void setGlasses(String glasses) {
		this.glasses[0] = glasses;
	}
	public void setChristmasShirt(String christmasShirt) {
		this.shirt[1] = christmasShirt;
	}
	public void setChristmasPants(String christmasPants) {
		this.pants[1] = christmasPants;
	}
	public void setChristmasHat(String christmasHat) {
		this.hat[1] = christmasHat;
	}
	public void setChristmasVest(String christmasVest) {
		this.vest[1] = christmasVest;
	}
	public void setChristmasMask(String christmasMask) {
		this.mask[1] = christmasMask;
	}
	public void setChristmasBackpack(String christmasBackpack) {
		this.backpack[1] = christmasBackpack;
	}
	public void setChristmasGlasses(String christmasGlasses) {
		this.glasses[1] = christmasGlasses;
	}
	public void setHalloweenShirt(String halloweenShirt) {
		this.shirt[2] = halloweenShirt;
	}
	public void setHalloweenPants(String halloweenPants) {
		this.pants[2] = halloweenPants;
	}
	public void setHalloweenHat(String halloweenHat) {
		this.hat[2] = halloweenHat;
	}
	public void setHalloweenVest(String halloweenVest) {
		this.vest[2] = halloweenVest;
	}
	public void setHalloweenMask(String halloweenMask) {
		this.mask[2] = halloweenMask;
	}
	public void setHalloweenBackpack(String halloweenBackpack) {
		this.backpack[2] = halloweenBackpack;
	}
	public void setHalloweenGlasses(String halloweenGlasses) {
		this.glasses[2] = halloweenGlasses;
	}
}