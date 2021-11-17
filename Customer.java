import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public void printCustomerRentalInfo() {
		System.out.println("Name: " + name +
			"\tRentals: " + rentals.size()) ;
		for ( Rental rental: rentals ) {
			System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
			System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
		}
	}

	public void clearRental() {
		rentals = new ArrayList<Rental>();
	}

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			double eachCharge = 0;
			int eachPoint = 0 ;
			int daysRented = 0;

			long diff;
			if (each.getStatus() == 1) { // returned Video
				diff = each.getReturnDate().getTime() - each.getRentDate().getTime();
			} else { // not yet returned
				diff = new Date().getTime() - each.getRentDate().getTime();
			}
			daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

			switch (each.getVideo().getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
			default:
				break;
			}

			eachPoint++;

			if ((each.getVideo().getPriceCode() == Video.NEW_RELEASE) )
				eachPoint++;

			if ( daysRented > each.getDaysRentedLimit() )
				eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty()) ;

			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
					+ "\tPoint: " + eachPoint + "\n";

			totalCharge += eachCharge;

			totalPoint += eachPoint ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result ;
	}
}
