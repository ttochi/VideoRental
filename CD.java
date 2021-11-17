import java.util.Date;

public class CD extends Video {

    public CD(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }
}
