import java.text.NumberFormat;
import java.util.ArrayList;

public class Store implements ReceiptPrintable{
    private String name;
    private double total = 0;
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        total += receipt.getTotal();
    }

    @Override
    public void viewReceipts() {
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("Receipts for store " + name + ".");
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }
}
