package calls;
 
public abstract class Call { 
	protected int totalMinutes;
	protected double cost;
	
	public abstract double calculateCost();
	public abstract String showDescription();
	public abstract double getPricePerMinte();
	
	
	protected final void setTotalMinutes(int totalMinutes) {
		if (totalMinutes > 0) {
			this.totalMinutes = totalMinutes;
		} else {
			this.totalMinutes = 1;
		}
	}
	
	public final int getTotalMinutes() {
		return this.totalMinutes;
	}
	
	
}
