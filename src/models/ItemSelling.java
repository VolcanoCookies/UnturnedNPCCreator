package models;

public class ItemSelling {
	
	String itemID;
	String itemName;
	String itemAmount;
	boolean isVehicle = false;
	String spawnpoint;
	String conditions;
	String cost;
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(String itemAmount) {
		this.itemAmount = itemAmount;
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
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public void addToConditions(String string) {
		if(this.conditions==null)
			this.conditions = "";
		this.conditions += string;
	}
}
