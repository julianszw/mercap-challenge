package calls;

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
	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	@Override
	public double calculateCost() {
		return this.totalMinutes * country.getCost();
	}

	@Override
	public String getDescription() {
//		String message;
//		message = String.format("International Call             - Destiny: %s", this.country);
//		return message;
		return "International Call to " + this.country;
	}
	
	
	@Override
	public String toString() {
		return this.getDescription();
	}

}
