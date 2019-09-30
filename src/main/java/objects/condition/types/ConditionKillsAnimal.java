package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionKillsAnimal extends Condition {
	
	private int animal;
	private int ID;
	private int value;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Kills_Animal;
	}
	public int getAnimal() {
		return animal;
	}
	public void setAnimal(int animal) {
		this.animal = animal;
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
