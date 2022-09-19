package customers;

public class Customer {
	private String name;
	private String id;
	private double monthlyFee;
	
	public Customer(String name, String id, double monthlyFee) {
		this.setName(name);
		this.setID(id);
		this.setMonthlyFee(monthlyFee);
	}

	public Customer(String name, double monthlyFee) {
		this(name, "-", monthlyFee); 
	}
	
	public final void setName(String name) {	
		if (name == null || name.isBlank() || name.isEmpty()) {
			this.name = "NO NAME";
		} else {
			this.name = name;
		}
	}

	public final void setID(String id) {
		if (id == null || id.isBlank() || id.isEmpty()) {
			this.id = "NO ID";
		} else {
			this.id = id;
		}
	}

	public final void setMonthlyFee(double monthlyFee) {
		if (monthlyFee > 0) {
			this.monthlyFee = monthlyFee;			
		}
	}
	
	public final String getName() {
		return name;
	}

	public final String getID() {
		return id;
	}
	
	public final double getMonthlyFee() {
		return monthlyFee;
	}
}
