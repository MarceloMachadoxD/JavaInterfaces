package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws Exception{

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		
	try {
		System.out.println("Enter Rental data");
		System.out.println("Car Model:");
		String model = sc.nextLine();
		System.out.println("Pickup dd/MM/yyyy HH:ss");
		Date start = sdf.parse(sc.nextLine());
		System.out.println("Return dd/MM/yyyy HH:ss");
		Date finish = sdf.parse(sc.nextLine());
		System.out.println("Enter Price per Hour");
		Double pricePerHour = Double.parseDouble(sc.nextLine());
		System.out.println("Enter Price per Day");
		Double pricePerDay = Double.parseDouble(sc.nextLine());
		
		
		CarRental cr = new CarRental(start, finish, new Vehicle(model));
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
			
		rentalService.ProcessInvoice(cr);
		
		System.out.println("INVOICE:"  );
		System.out.println("Basic Payment: " +  cr.getInvoice().getBasicPayment() );
		System.out.println("Tax: " +  cr.getInvoice().getTax() );
		System.out.println("Total Payment: " + +  cr.getInvoice().totalPayment());
		
		
	}		
		catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
			finally {
				sc.close();
	
			}
		
		
		
	}

}
