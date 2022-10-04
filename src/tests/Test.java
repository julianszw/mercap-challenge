package tests;

import bills.Bill;
import calls.Country;
import calls.InternationalCall;
import calls.LocalCall;
import calls.Location;
import calls.NationalCall;
import calls.TimeRange;
import customers.Customer;
import static org.junit.jupiter.api.Assertions.*;


class Test {

	@org.junit.jupiter.api.Test
	void allCallTypes() {
    	Customer c1 = new Customer("José Sánchez", "A11197692", 50);
    	Bill bill001 = new Bill(c1);
    	bill001.addItem(new LocalCall(5, TimeRange.WEEKEND));
		bill001.addItem(new InternationalCall(42, Country.ARGENTINA));
		bill001.addItem(new NationalCall(10, Location.MASSACHUSETTS));	
		
		assertEquals(63.08, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void onlyInternationalCalls() {
		Customer c2 = new Customer("Carla Díaz"  , "F99988832", 40);
		Bill bill001 = new Bill(c2);
		bill001.addItem(new InternationalCall(150, Country.MEXICO));
		bill001.addItem(new InternationalCall(4 , Country.POLAND));
		bill001.addItem(new InternationalCall(32 , Country.SAUDI_ARABIA));
		
		assertEquals(114.58, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void onlyNationalCalls() {
		Customer c3 = new Customer("Paulo Martin", "A99783812", 80.56);
		Bill bill001 = new Bill(c3);
		bill001.addItem(new NationalCall(20, Location.ALASKA));
		bill001.addItem(new NationalCall(3, Location.COLORADO));
		bill001.addItem(new NationalCall(1, Location.HAWAII));
		
		assertEquals(91.2, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void onlyLocalCalls() {
		Customer c4 = new Customer("Juan Ignacio Méndez", "A99783812", 62.5);
		Bill bill001 = new Bill(c4);
		bill001.addItem(new LocalCall(9, TimeRange.WEEKEND));
		bill001.addItem(new LocalCall(95, TimeRange.NON_WORKING_DAY_2));
		bill001.addItem(new LocalCall(15, TimeRange.WORKING_DAY_1));
		
		assertEquals(75.9, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void noCalls_ShouldReturnMonthlyFee() {
		Customer c5 = new Customer("Sebastián Sosa", "A99783812", 80);
		Bill bill001 = new Bill(c5);
		
		assertEquals(80, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void updateMonthlyFee_ShouldReturnNewValue() {
		Customer c5 = new Customer("Sebastián Sosa", "A99783812", 80);
		Bill bill001 = new Bill(c5);
		c5.updateMonthlyFee(85);
		
		assertEquals(85, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void emptyOrNullUser() {
		Customer c6 = new Customer(null, "B12398547", 80.56);
		Bill bill001 = new Bill(c6);
		
		assertEquals(80.56, bill001.calculateSubTotal());
	}
	
	@org.junit.jupiter.api.Test
	void emptyOrNullID() {
		Customer c6 = new Customer("Sebastián Sosa", "", 80.56);
		Bill bill001 = new Bill(c6);
		
		assertEquals(80.56, bill001.calculateSubTotal());
	}
	
	
	
}
