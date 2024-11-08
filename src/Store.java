import java.text.NumberFormat;
import java.util.ArrayList;

public class Store extends ReceiptsPrintable{
    private String name;
    private double total = 0;

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

    public void viewReceipts() {
        viewReceiptsHelper("Receipts for store " + name + ".");
    }

    public void generateReport(){
        NumberFormat format =  NumberFormat.getCurrencyInstance();
        System.out.println("\n-----------Report-----------");
        System.out.println("Report for store " + name + ".");
        System.out.println("Total spent: " + format.format(total));
        System.out.println("\nTotal spent per customer:");
        ListHelper.printCustomersWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per payment option: ");
        ListHelper.printPaymentsWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per item type: ");
        ListHelper.printItemTypesWithTotalSpentFromReceipts(receipts);
    }
}
