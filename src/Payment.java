import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Generic payment type. Used for basic payments like cash.
 */
public class Payment implements ReceiptPrintable{
    protected String type;
    protected double total = 0;
    protected ArrayList<Receipt> receipts = new ArrayList<>();

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

    public void addToTotal(double newCharge) {
        this.total += newCharge;
    }

    public void addReceipt(Receipt receipt){

        receipts.add(receipt);
        total += receipt.getTotal();
    }

    @Override
    public void viewReceipts(){
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("Receipts for payment method " + this + ".");
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }

    @Override
    public String toString(){
        return type;
    }
}
