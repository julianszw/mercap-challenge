package bills;

import java.util.ArrayList;

import calls.Call;
import calls.LocalCall;
import customers.Customer;

public class Bill {
	
	int    	   			billNumber;
	static int 			billNumberCounter;
	//final double 	    MONTHLY_FEE = 50;
	double 				monthlyFee;
	ArrayList<BillItem> items;
	Customer			customer;
	double			    totalConsumption;
	
	public Bill(Customer customer) {
		this.setCustomer(customer);
		this.items = new ArrayList<BillItem>();
		billNumberCounter++;
		this.setBillNumber();
		this.setMonthlyFee();
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setBillNumber() {
		this.billNumber = billNumberCounter;
	}

	public void setMonthlyFee() {
		this.monthlyFee = this.customer.getMonthlyFee(); //validar de nuevo?
	}
	
	public int getBillNumber() {
		return billNumber;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void addItem(Call call) {
//		if (call instanceof LocalCall) {
//			
//		}
		BillItem newBillItem;
		newBillItem = new BillItem(call, call.calculateCost());
		this.items.add(newBillItem); //validar? - identidad del item
	}
	
	public void showBill() {
		double subTotal = 0;
		subTotal += this.customer.getMonthlyFee();
		System.out.println ("=".repeat(70));
		System.out.printf  ("Bill N°  : %010d\n"	, this.getBillNumber());
		System.out.printf  ("Customer : %s   \n"    , this.getCustomer().getName());
		System.out.println ("=".repeat(70));
		
		System.out.printf ("Monthly Fee - subtotal: %-60s \n", this.getCustomer().getMonthlyFee()); //"%-30s | %4s minutes | subtotal: %-10s \n"
		for (int i = 0; i < items.size(); i++) { //for, no foreach...no?
			items.get(i).showItem();
			subTotal += items.get(i).getSubTotal();
		}
		System.out.println("=".repeat(70));
		System.out.println("TOTAL: " + subTotal);
		System.out.println("=".repeat(70));
	}	
	
	public final double calculateSubTotal() {
		double subTotal = 0;
		subTotal += this.customer.getMonthlyFee();
		
		for (int i = 0; i < items.size(); i++) {
			subTotal += items.get(i).getSubTotal();
		}

		return subTotal;
	}
	
	private class BillItem {
		private Call   call;
		private String description;
		private double subTotal;
		
		
		public BillItem(Call call, double subTotal) {			
			this.setCall(call);
			this.setDescription();
			//this.setTotalMinutes();
			this.setSubTotal();
		}

		private void setDescription() {
			this.description = call.getDescription();
		}

		private void setCall(Call call) {
			this.call = call;
		}

//		private void setTotalMinutes() {
//			this.totalMinutes = call.getTotalMinutes();
//		}
		
		private void setSubTotal() {
			this.subTotal = call.calculateCost(); 
		}

		public String getDescription() {
			return description;
		}

		public double getSubTotal() {
			return subTotal;
		}

		

		public void showItem() {
			System.out.printf("%-30s | %4s minutes | subtotal: %-10s \n", this.getDescription(), this.call.getTotalMinutes(), this.subTotal); 
		}

		@Override
		public String toString() {
			//contador de items
			return this.getDescription() + " | " + this.call.getTotalMinutes() + " minutes | Subtotal: " + this.subTotal;
		}
		
		
	}

}
