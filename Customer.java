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
			int daysRented = each.getDaysRented();

			double eachCharge = each.getCharge(daysRented);
			int eachPoint = each.getPoint(daysRented);

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

	public void returnRentedVideo(String videoTitle) {
		for ( Rental rental: rentals ) {
			if ( rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented() ) {
				rental.returnVideo();
				rental.getVideo().setRented(false);
				break;
			}
		}
	}

	public void rentVideo(Video video) {
		Rental rental = new Rental(video) ;
		video.setRented(true);
		rentals.add(rental);
	}
}
