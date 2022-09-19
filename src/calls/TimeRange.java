package calls;

public enum TimeRange {
	WORKING_DAY_1(0.2), //8 to 20
	NON_WORKING_DAY_2(0.1), //Rest of the day
	WEEKEND(0.1);
	
	double value;

	TimeRange(double value) {
		this.value = value;
	}

	public double getCost() {
		return value;
	}
	
	
}
