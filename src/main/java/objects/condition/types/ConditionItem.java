package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionItem extends Condition {
	
	private int ID;
	private int amount;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Item;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
