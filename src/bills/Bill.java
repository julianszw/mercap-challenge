package bills;

import java.math.BigDecimal;
import java.util.ArrayList;

import calls.Call;
import customers.Customer;
import services.NumberCropper; 

public class Bill implements Printable {
	private Customer customer;
	private ArrayList<BillItem> items;
	private static int billNumberCounter;
	private int billNumber;
	 
	public Bill(Customer customer) {
		this.setCustomer(customer);
		this.items = new ArrayList<BillItem>();
		billNumberCounter++;
		this.setBillNumber();
	}
	
	private final void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	private final void setBillNumber() {
		this.billNumber = billNumberCounter;
	}
	
	private final Customer getCustomer() {
		return customer;
	}

	private final int getBillNumber() {
		return billNumber;
	}
    
    public final void addItem(Call call) {
    	BillItem newBillItem;
    	newBillItem = new BillItem(call, call.calculateCost());
    	this.items.add(newBillItem);
    }
    
	public final void print() {
		System.out.println ("=".repeat(84));
		System.out.printf("Bill No. : %010d\n"	, this.getBillNumber()); 
		System.out.printf("Customer : %-29s" 	, this.customer.getName()); 
		System.out.printf("%44s\n"	, "ID :  " + this.customer.getID()); 	
		System.out.println ("-".repeat(84));
		System.out.printf("%-42s|%10s|%10s|%10s\n", "DESCRIPTION", "TOTAL MINUTES", "PRICE PER MINUTE", "SUBTOTAL");
		System.out.printf("%-42s|%13s|%16s|%10s\n", "Monthly fee", " - ", "- ", "$" + this.getCustomer().getMonthlyFee());
	
		for (BillItem billItem : items) {
			billItem.showItem();
		}
		
		System.out.println("-".repeat(84));
		System.out.println("TOTAL: $" + this.calculateSubTotal());
		System.out.println("=".repeat(84));
	}	
	
	public final double calculateSubTotal() {
		double billSubTotal = 0;
		billSubTotal += this.customer.getMonthlyFee();
		
		for (int i = 0; i < items.size(); i++) {
			billSubTotal += items.get(i).getItemTotal();
		}
		  return NumberCropper.truncateNumber(billSubTotal, 2);
	}
	
	private class BillItem implements Billable{
		private Call   call;
		private String description;
		private double itemTotal;
		
		
		public BillItem(Call call, double itemTotal) {			
			this.setCall(call);
			this.setDescription();
			this.setItemTotal();
		}
		
		private final void setCall(Call call) {
			this.call = call;
		}

		private final void setDescription() {
			this.description = call.showDescription();
		}

		private final void setItemTotal() {
			this.itemTotal = call.calculateCost(); 
		}

		public final String getDescription() {
			return description;
		}

		public final double getItemTotal() {
			return this.itemTotal;
		}
		
		private final void showItem() {
			System.out.printf("%-42s|%13s|%16s|%10s\n", this.getDescription(), this.call.getTotalMinutes(), "$" + this.call.getPricePerMinte(), "$" + this.getItemTotal());
		}
		
	}

}
