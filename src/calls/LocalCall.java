package calls;

import services.NumberCropper;

public class LocalCall extends Call {
	private TimeRange timeRange;
 
	public LocalCall(int totalMinutes, TimeRange timeRange) {
		this.setTotalMinutes(totalMinutes);
		this.setTimeRange(timeRange);
	}
	
	private void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}

	@Override
	public double calculateCost() {
		this.cost = this.totalMinutes * timeRange.getCost();
		return NumberCropper.truncateNumber(cost, 2);
	}
	
	@Override
	public double getPricePerMinute() {
		return this.timeRange.getCost();
	}

	@Override
	public String showDescription() {
		return "Local Call - Time range: " + this.timeRange;
	}

	
	
}
