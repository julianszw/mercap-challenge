package customers;

public class Customer {
	
	String 		  name;
	String        cuit; // o ID
	int    		  customerNumber;
	static int    customerNumberCounter;
	double		  monthlyFee;
	
	public Customer(String name, String cuit, double monthlyFee) {
		customerNumberCounter++; 
		this.setName(name);
		this.setCuit(cuit);
		this.setCustomerNumber();
		this.setMonthlyFee(monthlyFee);
	}

//	public Customer(String name, String cuit) {
//		this(name, cuit, 0); //0 ?
//	}
//	
	
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public void setName(String name) {
		//regex
		this.name = name;
	}

	public void setCuit(String cuit) {
		//regex
		this.cuit = cuit;
	}

	public void setCustomerNumber() {
		this.customerNumber = customerNumberCounter;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public String getName() {
		return name;
	}

	public String getCuit() {
		return cuit;
	}
	
	

	
	
}
