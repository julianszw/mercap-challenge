package calls;

public enum Location {
	LOCATION_1(0.5),
	LOCATION_2(0.3),
	LOCATION_3(0.7);
	
	double cost;
	
	Location(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
	
	

}
