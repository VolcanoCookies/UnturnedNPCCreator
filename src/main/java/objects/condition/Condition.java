package objects.condition;

public abstract class Condition {
	
	private boolean reset = false;
	private Logic logic;
	
	/*
	 * Getters & Setters
	 */
	
	public boolean isReset() {
		return reset;
	}
	public void setReset(boolean reset) {
		this.reset = reset;
	}
	public Logic getLogic() {
		return logic;
	}
	public void setLogic(Logic logic) {
		this.logic = logic;
	}
	
}
