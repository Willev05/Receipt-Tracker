import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Generic payment type. Used for basic payments like cash.
 */
public class Payment extends ReceiptsPrintable{
    protected String type;
    protected double total = 0;

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

    public void viewReceipts(){
        viewReceiptsHelper("Receipts for payment method " + this + ".");
    }

    public void generateReport(){
        NumberFormat format =  NumberFormat.getCurrencyInstance();
        System.out.println("\n-----------Report-----------");
        System.out.println("Report for payment option " + this + ".");
        System.out.println("Total spent: " + format.format(total));
        System.out.println("\nTotal spent per customer:");
        ListHelper.printCustomersWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per store: ");
        ListHelper.printStoresWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per item type: ");
        ListHelper.printItemTypesWithTotalSpentFromReceipts(receipts);
    }

    @Override
    public String toString(){
        return type;
    }
}
