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
	/* Contextualic� este programa en Washington D.C., Estados Unidos. Por este motivo, 
	 * exclu� a ambos valores de sus correspondientes enums.
	 * 
	 * Como mejora a este desarrollo, pienso que ser�a conveniente evitar que los minutos y el
	 * tipo de llamado sean valores establecidos desde afuera y, en ese caso, considerar el manejo de excepciones
	 * para evitar ingresos por teclado inesperados.
	 * 
	 * En cuanto a la clase Customer, decid� crearla ya que consider� que si este programa fuera
	 * escalable, ser�a necesario poder asignar y consultar facturas en funci�n de un usuario espec�fico.
	 * 
	 * Al margen del abono mensual, solamente una llamada puede ser un �tem en una factura. Por este
	 * motivo, decid� que un objeto de la clase Call es el par�metro que recibe BillItem en su constructor.
	 */

    public static void main (String[] args) {
    	    	
    	//Create example customer 
    	Customer c1 = new Customer("Jos� S�nchez", "A11197692", 50);
    	
    	//Generate new monthly bill
    	Bill bill001 = new Bill(c1);
    	
    	//Add consumptions to generated bill
		bill001.addItem(new InternationalCall(45 , Country.SWITZERLAND_));
		bill001.addItem(new LocalCall(7, TimeRange.WORKING_DAY_1));
		bill001.addItem(new InternationalCall(14 , Country.SAUDI_ARABIA));
		bill001.addItem(new InternationalCall(110, Country.COLOMBIA));
		bill001.addItem(new NationalCall(4, Location.FLORIDA));
		bill001.addItem(new LocalCall(-1, TimeRange.WEEKEND));
		bill001.addItem(new NationalCall(95, Location.NEVADA));
		bill001.addItem(new InternationalCall(32 , Country.ANDORRA));
		
		//Show bill's printout
		bill001.showBill();
			 	
    	
    	
    	
    	
    }

}


