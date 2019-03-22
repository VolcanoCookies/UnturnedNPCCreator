package models;

public enum Pose {
	Stand ("Stand"),
	Sit ("Sit"),
	Asleep ("Asleep"),
	Passive ("Passive"),
	Under_Arrest ("Under_Arrest"),
	Rest ("Rest"),
	Prone ("Prone"),
	Crouch ("Crouch"),
	Surrender ("Surrender");
	
	private final String pose;
	
	Pose(String pose){
		this.pose = pose;
	}
	String getType() {
		return this.pose;
	}
}
