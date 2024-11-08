import java.text.NumberFormat;
import java.util.ArrayList;

abstract class ReceiptsPrintable {
    protected ArrayList<Receipt> receipts = new ArrayList<>();

    protected void viewReceiptsHelper(String message) {
        System.out.println(message);
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }
}
