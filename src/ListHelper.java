import java.text.NumberFormat;
import java.util.ArrayList;

abstract class ListHelper {
    public static void printStoresWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> stores = new ArrayList<>();
        ArrayList<Double> totalPerStore = new ArrayList<>();

        String currentStoreName;
        int indexOfStore;
        for (Receipt receipt : receipts){
            currentStoreName = receipt.getStore().getName();
            indexOfStore = stores.indexOf(currentStoreName);
            if (indexOfStore != -1){
                double total = totalPerStore.get(indexOfStore);
                total += receipt.getTotal();
                totalPerStore.set(indexOfStore, total);
            }
            else{
                stores.add(currentStoreName);
                double total = receipt.getTotal();
                totalPerStore.add(total);
            }
        }

        for (int index = 0; index < stores.size(); index++){
            System.out.println(stores.get(index) + ": " + format.format(totalPerStore.get(index)));
        }
    }

    public static void printPaymentsWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> payments = new ArrayList<>();
        ArrayList<Double> totalPerPayment = new ArrayList<>();

        String currentPaymentName;
        int indexOfPayment;
        for (Receipt receipt : receipts){
            currentPaymentName = receipt.getPayment().toString();
            indexOfPayment = payments.indexOf(currentPaymentName);
            if (indexOfPayment != -1){
                double total = totalPerPayment.get(indexOfPayment);
                total += receipt.getTotal();
                totalPerPayment.set(indexOfPayment, total);
            }
            else{
                payments.add(currentPaymentName);
                double total = receipt.getTotal();
                totalPerPayment.add(total);
            }
        }

        for (int index = 0; index < payments.size(); index++){
            System.out.println(payments.get(index) + ": " + format.format(totalPerPayment.get(index)));
        }
    }

    public static void printCustomersWithTotalSpentFromReceipts(ArrayList<Receipt> receipts){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> customers = new ArrayList<>();
        ArrayList<Double> totalPerCustomer = new ArrayList<>();

        String currentCustomerName;
        int indexOfCustomer;
        for (Receipt receipt : receipts){
            currentCustomerName = receipt.getCustomer().getName();
            indexOfCustomer = customers.indexOf(currentCustomerName);
            if (indexOfCustomer != -1){
                double total = totalPerCustomer.get(indexOfCustomer);
                total += receipt.getTotal();
                totalPerCustomer.set(indexOfCustomer, total);
            }
            else{
                customers.add(currentCustomerName);
                double total = receipt.getTotal();
                totalPerCustomer.add(total);
            }
        }

        for (int index = 0; index < customers.size(); index++){
            System.out.println(customers.get(index) + ": " + format.format(totalPerCustomer.get(index)));
        }
    }

    public static void printItemTypesWithTotalSpentFromReceipts(ArrayList<Receipt> receipts) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        ArrayList<String> types = new ArrayList<>();
        ArrayList<Double> totalPerType = new ArrayList<>();

        String currentType;
        int indexOfType;
        for (Receipt receipt : receipts) {
            currentType = receipt.getType();
            indexOfType = types.indexOf(currentType);
            if (indexOfType != -1) {
                double total = totalPerType.get(indexOfType);
                total += receipt.getTotal();
                totalPerType.set(indexOfType, total);
            } else {
                types.add(currentType);
                double total = receipt.getTotal();
                totalPerType.add(total);
            }
        }

        for (int index = 0; index < types.size(); index++) {
            System.out.println(types.get(index) + ": " + format.format(totalPerType.get(index)));
        }
    }
}
