package models;

public enum Equipped {
	None (null),
	Primary ("Primary"),
	Secondary ("Secondary"),
	Tertiary ("Tertiary");
	
	private final String type;
	
	Equipped(String type){
		this.type = type;
	}
	String getType() {
		return this.type;
	}
}
