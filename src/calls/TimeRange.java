package calls;

public enum TimeRange {
//	MONDAY(1),
//	TUESDAY(),
//	WEDNESDAY,
//	THURSDAY,
//	FRIDAY,
	WORKING_DAY_1(0.2), //8 to 20
	NON_WORKING_DAY_2(0.1),
	WEEKEND(0.1);
	
	double value;
	
	TimeRange(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	
}
