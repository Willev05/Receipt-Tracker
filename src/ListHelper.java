import java.text.NumberFormat;
import java.util.ArrayList;

//Used to get information from ArrayLists
abstract class ListHelper {
    //Prints all stores mentioned with total for each across all receipts inputted
    public static void printStoresWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> stores = new ArrayList<>();
        ArrayList<Double> totalPerStore = new ArrayList<>();

        String currentStoreName;
        int indexOfStore;
        for (Receipt receipt : receipts){
            //Starts by going through every receipt and getting the store name
            currentStoreName = String.valueOf(receipt.getStore());
            indexOfStore = stores.indexOf(currentStoreName);
            if (indexOfStore != -1){
                //If store is already in the list, add the receipts total to the store's total
                double total = totalPerStore.get(indexOfStore);
                total += receipt.getTotal();
                totalPerStore.set(indexOfStore, total);
            }
            else{
                //If the store does not exist, add it to the end of the store array, do the same with receipt's total
                stores.add(currentStoreName);
                double total = receipt.getTotal();
                totalPerStore.add(total);
            }
        }

        //Prints every store found with their total
        for (int index = 0; index < stores.size(); index++){
            System.out.println(stores.get(index) + ": " + format.format(totalPerStore.get(index)));
        }
    }

    //Prints all payment types mentioned with total for each across all receipts inputted
    public static void printPaymentsWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> payments = new ArrayList<>();
        ArrayList<Double> totalPerPayment = new ArrayList<>();

        String currentPaymentName;
        int indexOfPayment;
        for (Receipt receipt : receipts){
            //Starts by going through every receipt and getting the payment type
            currentPaymentName = receipt.getPayment().toString();
            indexOfPayment = payments.indexOf(currentPaymentName);
            if (indexOfPayment != -1){
                //If payment type is already in the list, add the receipts total to the payment type's total
                double total = totalPerPayment.get(indexOfPayment);
                total += receipt.getTotal();
                totalPerPayment.set(indexOfPayment, total);
            }
            else{
                //If the payment type does not exist, add it to the end of the payment type array, do the same with receipt's total
                payments.add(currentPaymentName);
                double total = receipt.getTotal();
                totalPerPayment.add(total);
            }
        }

        //Prints every payment type found with their total
        for (int index = 0; index < payments.size(); index++){
            System.out.println(payments.get(index) + ": " + format.format(totalPerPayment.get(index)));
        }
    }

    //Prints all customers mentioned with total for each across all receipts inputted
    public static void printCustomersWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> customers = new ArrayList<>();
        ArrayList<Double> totalPerCustomer = new ArrayList<>();

        String currentCustomerName;
        int indexOfCustomer;
        for (Receipt receipt : receipts){
            //Starts by going through every receipt and getting the customer name
            currentCustomerName = String.valueOf(receipt.getCustomer());
            indexOfCustomer = customers.indexOf(currentCustomerName);
            if (indexOfCustomer != -1){
                //If customer is already in the list, add the receipts total to the customer's total
                double total = totalPerCustomer.get(indexOfCustomer);
                total += receipt.getTotal();
                totalPerCustomer.set(indexOfCustomer, total);
            }
            else{
                //If the customer does not exist, add it to the end of the customer array, do the same with receipt's total
                customers.add(currentCustomerName);
                double total = receipt.getTotal();
                totalPerCustomer.add(total);
            }
        }

        //Prints every customer found with their total
        for (int index = 0; index < customers.size(); index++){
            System.out.println(customers.get(index) + ": " + format.format(totalPerCustomer.get(index)));
        }
    }

    //Prints all stores item types with total for each across all receipts inputted
    public static void printItemTypesWithTotalSpentFromReceipts(ArrayList<Receipt> receipts) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> totalPerType = new ArrayList<>();

        String currentType;
        int indexOfType;
        for (Receipt receipt : receipts) {
            //Starts by going through every receipt and getting the item type
            currentType = receipt.getType();
            indexOfType = types.indexOf(currentType);
            if (indexOfType != -1) {
                //If item type is already in the list, add the receipts total to the item type's total
                double total = totalPerType.get(indexOfType);
                total += receipt.getTotal();
                totalPerType.set(indexOfType, total);
            } else {
                //If the item type does not exist, add it to the end of the item type array, do the same with receipt's total
                types.add(currentType);
                double total = receipt.getTotal();
                totalPerType.add(total);
            }
        }

        //Prints every item type found with their total
        for (int index = 0; index < types.size(); index++) {
            System.out.println(types.get(index) + ": " + format.format(totalPerType.get(index)));
        }
    }
}
