import java.util.ArrayList;
import java.util.Random;

public class TestReceiptSystem extends ReceiptSystem{

    public static void main(String[] args){
        Random random = new Random();
        payments.add(new Payment("Cash"));

        String[] storePrep = {
                "Walmart",
                "Loblaws",
                "LCBO"
        };

        String[] itemType = {
                "Froceries",
                "Clothoing",
                "Alc"
        };

        String[] customerPrep = {
                "Will",
                "Luke",
                "Tom"
        };

        String[][] paymentPrep = {
                {"Credit", "Mastercard", "Card 1"},
                {"Debit", "Visa", "Card 2"},
                {"Credit", "visa", "Card 3"}
        };

        int[][] receiptPrep = {
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 2, 2},
                {2, 2, 1, 3},
                {1, 0, 2, 2}
        };

        for (String store : storePrep){
            stores.add(new Store(store));
        }

        for (String customer : customerPrep){
            customers.add(new Customer(customer));
        }

        for (String[] payment : paymentPrep){
            payments.add(new CardPayment(payment[0], payment[1], payment[2]));
        }

        for (int[] receiptInfo : receiptPrep){
            Receipt receipt = new Receipt();

            receipt.setStore(stores.get(receiptInfo[0]));
            receipt.setType(itemType[receiptInfo[1]]);
            receipt.setCustomer(customers.get(receiptInfo[2]));
            receipt.addItem(new Item("Item 1", random.nextDouble() * 10, random.nextInt(5) + 1));
            receipt.addItem(new Item("Item 2", random.nextDouble() * 10, random.nextInt(5) + 1));
            receipt.setPayment(payments.get(receiptInfo[3]));
            receipt.calculateTotal();
            receipts.add(receipt);

            stores.get(receiptInfo[0]).addReceipt(receipt);
            customers.get(receiptInfo[2]).addReceipt(receipt);
            payments.get(receiptInfo[3]).addReceipt(receipt);
        }

        System.out.println("Receipts loaded to memory. Launching main function...");
        mainOld();
    }
}
