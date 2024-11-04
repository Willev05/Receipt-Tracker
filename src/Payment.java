import java.util.ArrayList;

/**
 * Generic payment type. Used for basic payments like cash.
 */
public class Payment {
    private String type;
    private double total = 0;
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public Payment(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReceipts(ArrayList<Receipt> receipts) {
        this.receipts = receipts;
    }

    /**
     * The function serves to add a new charge onto the payment.
     * @param newCharge Ammount to add to payment type
     */
    public void addToTotal(double newCharge) {
        this.total += newCharge;
    }

    /**
     * Adds a receipt to payment's receipt list.
     * @param receipt New receipt to add to related receipts list.
     */
    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }

}
