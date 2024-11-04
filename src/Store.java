import java.util.ArrayList;

public class Store {
    private String name;
    private String type;
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public Store(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReceipts(ArrayList<Receipt> receipts) {
        this.receipts = receipts;
    }

    /**
     * Adds a receipt to store's related receipts list.
     * @param receipt New receipt to add.
     */
    public void addReceipts(Receipt receipt) {
        receipts.add(receipt);
    }
}
