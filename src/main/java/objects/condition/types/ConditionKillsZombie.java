package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;
import objects.condition.Zombie;

public class ConditionKillsZombie extends Condition {
	
	private Zombie zombie;
	private int ID;
	private int value;
	private boolean Spawn;
	private int nav;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Kills_Zombies;
	}
	public Zombie getZombie() {
		return zombie;
	}
	public void setZombie(Zombie zombie) {
		this.zombie = zombie;
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
	public boolean isSpawn() {
		return Spawn;
	}
	public void setSpawn(boolean spawn) {
		Spawn = spawn;
	}
	public int getNav() {
		return nav;
	}
	public void setNav(int nav) {
		this.nav = nav;
	}
	
}