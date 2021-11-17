import java.util.Date;

public abstract class Video {
	private String title ;

	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;

	private Date registeredDate ;
	private boolean rented ;

	public Video(String title, int priceCode, Date registeredDate) {
		this.title = title;
		this.priceCode = priceCode;
		this.registeredDate = registeredDate ;
	}

	public abstract int getLateReturnPointPenalty();

	public int getPriceCode() {
		return priceCode;
	}

	public String getTitle() {
		return title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public void printVideoInfo() {
		System.out.println("Price code: " + priceCode +"\tTitle: " + title);
	}
}
