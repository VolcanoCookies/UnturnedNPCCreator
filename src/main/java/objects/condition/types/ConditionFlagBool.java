package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionFlagBool extends Condition {
	
	private int ID;
	private boolean value;
	private boolean allowUnset;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Flag_Bool;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public boolean getValue() {
		return value;
	}
	public void setValue(Boolean value) {
		this.value = value;
	}
	public boolean isAllowUnset() {
		return allowUnset;
	}
	public void setAllowUnset(boolean allowUnset) {
		this.allowUnset = allowUnset;
	}
	
}
