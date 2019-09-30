package objects.condition.types;

import objects.condition.Condition;
import objects.condition.ConditionType;

public class ConditionCompareFlags extends Condition {
	
	private int a;
	private int b;
	private boolean allowAUnset;
	private boolean allowBUnset;
	
	/*
	 * Getters & Setters
	 */
	
	public ConditionType getType() {
		return ConditionType.Compare_Flags;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public boolean isAllowAUnset() {
		return allowAUnset;
	}
	public void setAllowAUnset(boolean allowAUnset) {
		this.allowAUnset = allowAUnset;
	}
	public boolean isAllowBUnset() {
		return allowBUnset;
	}
	public void setAllowBUnset(boolean allowBUnset) {
		this.allowBUnset = allowBUnset;
	}
	
}
