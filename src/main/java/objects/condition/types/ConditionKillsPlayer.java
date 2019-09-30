package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionKillsPlayer extends Condition {
	
	private int ID;
	private int value;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Kills_Player;
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
	
}
