import java.util.ArrayList;
import java.util.Scanner;

public class ReceiptSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        // Create a list to store receipts
        ArrayList<Receipt> receipts = new ArrayList<>();

        // Create a list to store customers
        ArrayList<Customer> customers = new ArrayList<>();

        // Create a list to store stores
        ArrayList<Store> stores = new ArrayList<>();

        // Create a list of payment types
        ArrayList<Payment> payments = new ArrayList<>();

        // Default payment type of cash is created
        payments.add(new Payment("Cash"));

        //Welcome message explaining some things about the program and requesting tax rates.
        System.out.println("This application logs receipts and helps track spending per customer, store, payment options and item types.");
        int taxPercent = getIntWithVerification(scanner, "Please enter tax rate for your region (in %): ");
        Receipt.setTaxRate(taxPercent);

        // Main loop to interact with the user
        while (true) {
            System.out.println();
            System.out.println("1. Add Receipt");
            System.out.println("2. View Receipts");
            System.out.println("3. Generate Reports");
            System.out.println("4. Exit");
            int choice = getIntWithVerification(scanner, "Enter your choice: ");
            boolean invalid = true;

            switch (choice) {
                case 1:
                    // Add a receipt
                    Receipt receipt = new Receipt();
                    System.out.print("Enter store name: ");
                    String storeName = scanner.next();
                    System.out.print("Enter item type (eg. Groceries, Clothing): ");
                    String storeType = scanner.next();
                    
                    //check if the store is already exists before add it
                    Store store = findStoreByName(stores, storeName);
                    if (store == null) {
                        store = new Store(storeName);
                        stores.add(store);
                    }
                    receipt.setStore(store);
                    receipt.setType(storeType);

                    System.out.print("\nEnter customer name: ");
                    String customerName = scanner.next();

                    //check if the customer is already exists before add it
                    Customer customer = findCustomerByName(customers, customerName);
                    if (customer == null) {
                        customer = new Customer(customerName);
                        customers.add(customer);
                    }
                    receipt.setCustomer(customer);

                    // Add items to the receipt
                    while (true) {
                        System.out.println("\nEnter item name (or 'done' to finish): ");
                        String itemName = scanner.next();
                        if (itemName.equals("done")) {
                            break;
                        }
                        double price = getDoubleWithVerification(scanner, "Enter item price: ");
                        int quantity = getIntWithVerification(scanner, "Enter item quantity: ");
                        Item item = new Item(itemName, price, quantity);
                        receipt.addItem(item);
                    }

                    //gets user to select payment type from a list, or create a new one
                    invalid = true;
                    Payment payment = new Payment("");
                    do {
                        System.out.println("\nPayment methods:");
                        int counter = 1;
                        for (Payment paymentDisplay : payments){
                            System.out.println(counter + ". " + paymentDisplay);
                            counter++;
                        }
                        System.out.println(counter + ". Enter new card payment type\n");

                        int paymentChoice = getIntWithVerification(scanner, "Please select payment method used (number): ");
                        if (paymentChoice > payments.size() + 1 || 1 > paymentChoice){
                            System.out.println("Invalid selection! Please enter a number corresponding to the options above");
                        }
                        else if (paymentChoice == payments.size() + 1){
                            invalid = false;
                            payment = CardPayment.createNewCardPayment();
                            payments.add(payment);
                        }
                        else{
                            invalid = false;
                            payment = payments.get(paymentChoice - 1);
                        }

                    } while (invalid);

                    receipt.setPayment(payment);

                    // Calculate total and add receipt to lists
                    receipt.calculateTotal();
                    receipts.add(receipt);
                    store.addReceipt(receipt);
                    customer.addReceipt(receipt);
                    payment.addReceipt(receipt);

                    //show receipt at the end
                    receipt.viewReceipt();

                    break;

                case 2:
                    // View receipts
                    System.out.println("\nView receipts by:");
                    System.out.println("1. Customer");
                    System.out.println("2. Store");
                    System.out.println("3. Payment type");
                    System.out.println("4. Item type");
                    System.out.println("5. View all receipts");
                    int viewChoice = getIntWithVerification(scanner, "Enter your choice: ");

                    if (viewChoice == 1) {
                        System.out.print("Enter customer name: ");
                        String customerNameToView = scanner.next();
                        Customer customerToView = findCustomerByName(customers, customerNameToView);
                        if (customerToView != null) {
                            customerToView.viewReceipts();
                        } else {
                            System.out.println("Customer not found.");
                        }
                    } else if (viewChoice == 2) {
                        System.out.print("Enter store name: ");
                        String storeNameToView = scanner.next();
                        Store storeToView = findStoreByName(stores, storeNameToView);
                        if (storeToView != null) {
                            storeToView.viewReceipts();
                        } else {
                            System.out.println("Store not found.");
                        }
                    } else if (viewChoice == 3) {
                        invalid = true;
                        Payment paymentToView = new Payment("");
                        do {
                            System.out.println("\nPayment methods:");
                            int counter = 1;
                            for (Payment paymentDisplay : payments){
                                System.out.println(counter + ". " + paymentDisplay);
                                counter++;
                            }

                            int paymentChoice = getIntWithVerification(scanner, "Please select wanted payment method (number): ");
                            if (paymentChoice > payments.size()|| 1 > paymentChoice){
                                System.out.println("Invalid selection! Please enter a number corresponding to the options above");
                            }
                            else{
                                invalid = false;
                                paymentToView = payments.get(paymentChoice - 1);
                            }

                        } while (invalid);

                        paymentToView.viewReceipts();
                    } else if (viewChoice == 4){
                        System.out.print("Enter item type : ");
                        String itemTypeToView = scanner.next();
                        ArrayList<Receipt> receiptsToView = findReceiptsByType(receipts ,itemTypeToView);
                        if (!receiptsToView.isEmpty()){
                            Receipt.viewReceipts(receiptsToView, itemTypeToView);
                        }
                        else {
                            System.out.println("Item type not found.");
                        }
                    }
                    else if (viewChoice == 5){
                        System.out.println();
                        if (!receipts.isEmpty()){
                            for (Receipt receiptToView : receipts){
                                receiptToView.viewReceipt();
                            }
                        }
                        else {
                            System.out.println("No receipts have been entered yet.");
                        }
                    }

                    break;

                case 3:
                    System.out.println("\nGenerate report by:");
                    System.out.println("1. Customer");
                    System.out.println("2. Store");
                    System.out.println("3. Payment type");
                    System.out.println("4. Item type");
                    int genrateChoice = getIntWithVerification(scanner, "Enter your choice: ");

                    if (genrateChoice == 1){
                        System.out.print("Enter customer name: ");
                        String customerNameToView = scanner.next();
                        Customer customerToView = findCustomerByName(customers, customerNameToView);
                        if (customerToView != null) {
                            customerToView.generateReport();
                        } else {
                            System.out.println("Customer not found.");
                        }
                    }
                    else if (genrateChoice == 2){
                        System.out.print("Enter store name: ");
                        String storeNameToView = scanner.next();
                        Store storeToView = findStoreByName(stores, storeNameToView);
                        if (storeToView != null) {
                            storeToView.generateReport();
                        } else {
                            System.out.println("Store not found.");
                        }
                    }
                    else if (genrateChoice == 3){
                        invalid = true;
                        Payment paymentToView = new Payment("");
                        do {
                            System.out.println("\nPayment methods:");
                            int counter = 1;
                            for (Payment paymentDisplay : payments){
                                System.out.println(counter + ". " + paymentDisplay);
                                counter++;
                            }

                            int paymentChoice = getIntWithVerification(scanner, "Please select wanted payment method (number): ");
                            if (paymentChoice > payments.size()|| 1 > paymentChoice){
                                System.out.println("Invalid selection! Please enter a number corresponding to the options above");
                            }
                            else{
                                invalid = false;
                                paymentToView = payments.get(paymentChoice - 1);
                            }

                        } while (invalid);

                        paymentToView.generateReport();
                    }
                    else if (genrateChoice == 4){
                        System.out.print("Enter item type : ");
                        String itemTypeToView = scanner.next();
                        ArrayList<Receipt> receiptsToView = findReceiptsByType(receipts ,itemTypeToView);
                        if (!receiptsToView.isEmpty()){
                            Receipt.generateReport(receiptsToView, itemTypeToView);
                        }
                        else {
                            System.out.println("Item type not found.");
                        }
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }

    // Helper methods
    private static Customer findCustomerByName(ArrayList<Customer> customers, String name) {
        for (Customer customer : customers){
            if (customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    private static Store findStoreByName(ArrayList<Store> stores, String name) {
        for (Store store : stores){
            if (store.getName().equals(name)){
                    return store;
            }
        }
        return null;
    }

    private static ArrayList<Receipt> findReceiptsByType(ArrayList<Receipt> receipts, String type){
        ArrayList<Receipt> receiptOfType = new ArrayList<>();
        for (Receipt receipt : receipts){
            if (receipt.getType().equals(type)){
                receiptOfType.add(receipt);
            }
        }
        return receiptOfType;
    }

    private static int getIntWithVerification(Scanner scan, String message){
        while (true) {
            System.out.print(message);
            if (scan.hasNextInt()){
                return scan.nextInt();
            }
            scan.next();
            System.out.println("Input was not a valid integer! Please try again.");
        }
    }

    private static double getDoubleWithVerification(Scanner scan, String message){
        while (true){
            System.out.print(message);
            if (scan.hasNextDouble()){
                return scan.nextDouble();
            }
            scan.next();
            System.out.println("Input was not a valid double! Please try again.");
        }
    }
}