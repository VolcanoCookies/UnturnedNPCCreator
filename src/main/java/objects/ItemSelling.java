package objects;

import java.util.ArrayList;
import java.util.List;

import objects.condition.Condition;

public class ItemSelling {
	
	private int itemID;
	private String itemName;
	private int amount;
	private int cost;
	private boolean isVehicle = false;
	private String spawnpoint;
	private List<Condition> conditions;
	
	/*
	 * Getters & Setters
	 */
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean isVehicle() {
		return isVehicle;
	}
	public void setVehicle(boolean isVehicle) {
		this.isVehicle = isVehicle;
	}
	public String getSpawnpoint() {
		return spawnpoint;
	}
	public void setSpawnpoint(String spawnpoint) {
		this.spawnpoint = spawnpoint;
	}
	public int getCost() {
		return cost;
	}
	public List<Condition> getConditions() {
		return conditions;
	}
	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	public void addCondition(Condition condition) {
		if(this.conditions == null)
			this.conditions = new ArrayList<>();
		this.conditions.add(condition);
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
