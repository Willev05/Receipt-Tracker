import java.util.ArrayList;

public class Customer extends ReceiptsPrintable{
    private String name;
    private double total = 0;

    public Customer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        total += receipt.getTotal();
    }

    @Override
    public String toString() {
        return name;
    }

    public void viewReceipts() {
        viewReceiptsHelper("Receipts for customer " + name + ".");
    }
}
