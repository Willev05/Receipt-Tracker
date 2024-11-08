import java.text.NumberFormat;
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

    public void generateReport(){
        NumberFormat format =  NumberFormat.getCurrencyInstance();
        System.out.println("\n-----------Report-----------");
        System.out.println("Report for customer " + name + ".");
        System.out.println("Total spent: " + format.format(total));
        System.out.println("\nTotal spent per store:");
        ListHelper.printStoresWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per payment option: ");
        ListHelper.printPaymentsWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per item type: ");
        ListHelper.printItemTypesWithTotalSpentFromReceipts(receipts);
    }
}
