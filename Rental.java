import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 0 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public int getDaysRentedLimit() {
		int limit;
		int daysRented = getDaysRented();
		if (daysRented <= 2) {
			limit = 0;
		} else {
			limit = video.getLimit();
		}

		return limit;
	}

	public int getDaysRented() {
		long diff;
		if (status == 1) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}
}
