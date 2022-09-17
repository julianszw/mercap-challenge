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
	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	@Override
	public double calculateCost() {
		return this.totalMinutes * location.getCost();
	}


	@Override
	public String getDescription() {
		return "National Call to " + this.location;
	}
	

	
	@Override
	public String toString() {
		return this.getDescription();
	}
}
