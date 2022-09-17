package tests;

import bills.Bill;
import calls.Country;
import calls.InternationalCall;
import calls.LocalCall;
import calls.Location;
import calls.NationalCall;
import calls.TimeRange;
import customers.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
    	Customer c1 = new Customer("JUANCITO", "20-8765499-1", 50);
    	Bill bill001 = new Bill(c1);
    	bill001.addItem(new LocalCall(5, TimeRange.WEEKEND));
		bill001.addItem(new InternationalCall(4, Country.BOLIVIA));
		bill001.addItem(new NationalCall(10, Location.LOCATION_3));
		
		assertEquals(59.06, bill001.calculateSubTotal());
	}

}
