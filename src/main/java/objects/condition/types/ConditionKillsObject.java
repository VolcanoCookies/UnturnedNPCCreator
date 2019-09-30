package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionKillsObject extends Condition {
	
	private int id;
	private String objectGUID;
	private int nav;
	private int value;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Kills_Object;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjectGUID() {
		return objectGUID;
	}
	public void setObjectGUID(String string) {
		this.objectGUID = string;
	}
	public int getNav() {
		return nav;
	}
	public void setNav(int nav) {
		this.nav = nav;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
