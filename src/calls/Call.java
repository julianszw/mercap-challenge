package calls;

public abstract class Call {
	protected int totalMinutes;
	protected double cost;
	//protected String description;
	
	
	public abstract void setTotalMinutes(int minutes);
	public abstract double calculateCost();
	public abstract String getDescription();
	
	
	public final int getTotalMinutes() { //borrar en subclases
		return this.totalMinutes;
	}
	
	
}
