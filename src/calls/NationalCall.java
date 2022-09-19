package calls;
 
public class NationalCall extends Call {
	Location location;

	public NationalCall(int totalMinutes, Location location) {
		this.setTotalMinutes(totalMinutes);
		this.setLocation(location);	
	}

	private void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public double calculateCost() {
		this.cost = this.totalMinutes * location.getCost();
		return this.truncateNumber(cost, 2);
	}
	
	@Override
	public double getPricePerMinte() {
		return this.location.getCost();
	}
	
	@Override
	public String showDescription() {
		return "National call to " + this.location;
	}

	

}
