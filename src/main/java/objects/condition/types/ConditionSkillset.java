package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;
import objects.condition.Skillset;

public class ConditionSkillset extends Condition {
	
	private Skillset value;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Skillset;
	}
	public Skillset getValue() {
		return value;
	}
	public void setValue(Skillset value) {
		this.value = value;
	}
	
}