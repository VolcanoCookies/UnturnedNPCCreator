package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionReputation extends Condition {
	
	private int value;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Reputation;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
