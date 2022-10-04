package calls;

import services.NumberCropper;

public class NationalCall extends Call {
	private Location location;

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
		return NumberCropper.truncateNumber(cost, 2);
	}
	
	@Override
	public double getPricePerMinute() {
		return this.location.getCost();
	}
	
	@Override
	public String showDescription() {
		return "National call to " + this.location;
	}

	

}
