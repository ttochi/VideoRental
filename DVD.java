import java.util.Date;

public class DVD extends Video {

    public DVD(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }
}
