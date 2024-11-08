import java.awt.desktop.SystemEventListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Receipt{
    private static int nextId = 0;
    private int id;
    private Store store;
    private Customer customer;
    private Payment payment;
    private String type;
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

    public void calculateTotal(){
        for (Item item : items){
            total += item.getTotal();
        }
    }

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
        System.out.println("Total: " + format.format(total));
        System.out.println("Payed with " + payment);
        System.out.println("-----------------------");
    }

    public static void viewReceipts(ArrayList<Receipt> receipts, String type){
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println("Receipts for item type " + type + ".");
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }
}
