import java.util.Date;

public class VHS extends Video {

    public VHS(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 1;
    }
}
