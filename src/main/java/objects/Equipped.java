package objects;

public enum Equipped {
	None(0),
	Primary(1),
	Secondary(2),
	Tertiary(3);
	
	private int value;
	
	private Equipped(int i) {
		this.value = i;
	}
	public int getValue() {
		return value;
	}
	
}
