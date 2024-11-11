import java.util.ArrayList;

//Abstract class on which all classes that prints their receipts list are built
abstract class ReceiptsPrintable {
    protected ArrayList<Receipt> receipts = new ArrayList<>();

    //Print all receipts in this class with a custom message header
    protected void viewReceiptsHelper(String message) {
        System.out.println(message);
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }
}
