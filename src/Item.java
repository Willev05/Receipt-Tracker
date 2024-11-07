import java.text.NumberFormat;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal(){
        return price * quantity;
    }

    @Override
    public String toString(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return name + ": " + quantity + " @ " + format.format(price);
    }

}
