package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionKillsHorde extends Condition {
	
	private int ID;
	private int value;
	private int nav;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Kills_Horde;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getNav() {
		return nav;
	}
	public void setNav(int nav) {
		this.nav = nav;
	}
	
}
