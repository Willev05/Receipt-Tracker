import java.text.NumberFormat;
import java.util.ArrayList;

public class ReceiptsPrintable {
    protected ArrayList<Receipt> receipts = new ArrayList<>();

    protected void viewReceiptsHelper(String message) {
        NumberFormat format = NumberFormat.getCurrencyInstance();

        System.out.println(message);
        for (Receipt receipt : receipts){
            receipt.viewReceipt();
        }
    }
}
