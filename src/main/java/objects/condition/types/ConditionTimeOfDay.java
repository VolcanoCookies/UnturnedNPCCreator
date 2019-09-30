package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionTimeOfDay extends Condition{
	
	private int seconds;

	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Time_Of_Day;
	}
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
