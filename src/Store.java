import java.text.NumberFormat;

//Represents a store that issued a receipt
public class Store extends ReceiptsPrintable{
    private String name;
    private double total = 0;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        total += receipt.getTotal();
    }

    //View all receipts under a specific store
    public void viewReceipts() {
        viewReceiptsHelper("Receipts for store " + name + ".");
    }

    //Generate a report around a specific store
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
