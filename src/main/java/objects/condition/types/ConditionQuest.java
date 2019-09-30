package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;
import objects.condition.Status;

public class ConditionQuest extends Condition {
	
	private int ID;
	private Status status;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Quest;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
