import java.text.NumberFormat;

//Represents a specific Customer
public class Customer extends ReceiptsPrintable{
    private String name;
    private double total = 0;

    public Customer(String name){
        this.name = name;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        total += receipt.getTotal();
    }

    @Override
    public String toString() {
        return name;
    }

    //View all receipts under a specific customer
    public void viewReceipts() {
        viewReceiptsHelper("Receipts for customer " + name + ".");
    }

    //Generate a report around a specific customer
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
