import java.util.Date;

public class CD extends Video {

    public CD(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }
}
