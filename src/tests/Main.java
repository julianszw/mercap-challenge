package tests;

import bills.Bill;
import calls.Country;
import calls.InternationalCall;
import calls.LocalCall;
import calls.Location;
import calls.NationalCall;
import calls.TimeRange;
import customers.Customer;

public class Main {


    public static void main (String[] args) {
    	Customer c1 = new Customer("JUANCITO", "20-8765499-1", 50);
    	Customer c2 = new Customer("PEDRITO" , "27-1282128-1", 40);
    	Customer c3 = new Customer("CARLITOS", "20-7474955-1", 80);
    	Bill bill001 = new Bill(c1);
    	bill001.addItem(new LocalCall(5, TimeRange.WEEKEND));
		bill001.addItem(new InternationalCall(4, Country.BOLIVIA));
		bill001.addItem(new NationalCall(10, Location.LOCATION_3));
		bill001.showBill();
    			 	
    	
    	
    	//assert(bill001)
    	
    	
    	
    }

}


