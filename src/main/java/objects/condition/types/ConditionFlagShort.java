package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionFlagShort extends Condition {
	
	private int ID;
	private int value;
	private boolean allowUnset;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Flag_Short;
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
	public boolean isAllowUnset() {
		return allowUnset;
	}
	public void setAllowUnset(boolean allowUnset) {
		this.allowUnset = allowUnset;
	}
	
}
