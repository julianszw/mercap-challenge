package calls;

import services.NumberCropper;

public class InternationalCall extends Call {
	Country country;
	
	public InternationalCall(int totalMinutes, Country country) {
		this.setTotalMinutes(totalMinutes);
		this.setCountry(country);
	}
	 
	private void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public double calculateCost() {
		this.cost = this.totalMinutes * country.getCost();
		return NumberCropper.truncateNumber(cost, 2);
	}
	
	@Override
	public double getPricePerMinte() {
		return this.country.getCost();
	}

	@Override
	public String showDescription() {
		return "International call to " + this.country;
	}

	
}
