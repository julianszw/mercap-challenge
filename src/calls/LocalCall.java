package calls;

public class LocalCall extends Call {
	
	TimeRange timeRange;

	public LocalCall(int totalMinutes, TimeRange timeRange) {
		this.setTotalMinutes(totalMinutes);
		this.setTimeRange(timeRange);
		//this.cost = timeRange.getValue();
	}
	
	private void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}

	@Override
	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	@Override
	public double calculateCost() {
		return this.totalMinutes * timeRange.getValue();
	}

	@Override
	public String getDescription() {
//		String message;
//		message = "Local call | " + this.timeRange; 
//		message = String.format("Local Call %-20s- Time Range: ", this.timeRange);
		return "Local Call - " + this.timeRange.toString().toLowerCase(); //agregar día y hor
//		return message;
	}
	
	
	
	@Override
	public String toString() {
		return this.getDescription();
	}
	
	
}
