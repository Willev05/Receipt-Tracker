import java.text.NumberFormat;
import java.util.ArrayList;

//Represents a Receipt gotten from a store
public class Receipt{
    //Since the entire system revolves around Receipt, it contains many other classes and variables
    private static int nextId = 0;
    //Tax rate is 0% by default, ReceiptSystem should change it on first load
    private static double taxRate = 0;
    private int id;
    private Store store;
    private Customer customer;
    private Payment payment;
    private String type;
    private double subTotal = 0;
    private double tax = 0;
    private double total = 0;
    private ArrayList<Item> items = new ArrayList<>();

    public Receipt(){
        id = nextId;
        nextId++;
    };

    public void setStore(Store store) {
        this.store = store;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void setTaxRate(double taxRate) {
        Receipt.taxRate = (taxRate / 100);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public double getTotal() {
        return total;
    }

    public String getType(){
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public Store getStore() {
        return store;
    }

    //Gets total from all items, also sets the subtotal and tax
    public void calculateTotal(){
        for (Item item : items){
            subTotal += item.getTotal();
        }
        tax = subTotal * taxRate;
        total = subTotal + tax;
    }

    //Prints the specific receipt instance
    public void viewReceipt(){
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("-----------------------");
        System.out.println("Receipt id: " + id);
        System.out.println("Customer name: " + customer);
        System.out.println("Store name: " + store);
        System.out.println("Item type: " + type);
        System.out.println();
        System.out.println("Item(s) purchased: ");

        for (Item item : items){
            System.out.println(item);
        }

        System.out.println();
        System.out.println("Subtotal: " + format.format(subTotal));
        System.out.println("Tax: " + format.format(tax) + " @ " + taxRate * 100 + "%");
        System.out.println("Total: " + format.format(total));
        System.out.println("Payed with " + payment);
        System.out.println("-----------------------");
    }

    //View all receipts under a specific item type
    public static void viewReceipts(ArrayList<Receipt> receipts, String type){
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("Receipts for item type " + type + ".");
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }

    //Generate a report around a specific item type
    public static void generateReport(ArrayList<Receipt> receipts, String type){
        NumberFormat format =  NumberFormat.getCurrencyInstance();
        System.out.println("\n-----------Report-----------");
        System.out.println("Report for item type " + type + ".");
        System.out.println("Total spent: " + format.format(getTotalFromReceiptList(receipts)));
        System.out.println("\nTotal spent per customer:");
        ListHelper.printCustomersWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per store: ");
        ListHelper.printStoresWithTotalSpentFromReceipts(receipts);

        System.out.println("\nTotal spent per payment option: ");
        ListHelper.printPaymentsWithTotalSpentFromReceipts(receipts);
    }

    //Gets the total from a list of receipts
    private static double getTotalFromReceiptList(ArrayList<Receipt> receipts){
        double total = 0;
        for (Receipt receipt : receipts){
            total += receipt.getTotal();
        }
        return total;
    }
}
