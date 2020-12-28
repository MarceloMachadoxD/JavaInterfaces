package model.services;

public class USATaxService implements TaxServices {

	public Double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.1;
		}
		else {
			return amount * 0.05;
		}

	}

}
