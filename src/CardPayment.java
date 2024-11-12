import java.util.Scanner;

//Card payment type. Used to represent debit/credit cards of visa/mastercard types.
public class CardPayment extends Payment{
    private String cardType;
    private String nickName;

    public CardPayment(String type, String cardType, String nickName) {
        super(type);
        this.cardType = cardType;
        this.nickName = nickName;
    }

    //Neatly packs all payment information into a string
    @Override
    public String toString(){
        return nickName + ": " + type + " " + cardType;
    }

    //Contains the process of creating a new payment type, then returns a new CardPayment
    public static CardPayment createNewCardPayment(){
        String paymentType, paymentIssuer, paymentNickName;
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        //Get information from user for new payment type
        System.out.print("Enter payment type (credit or debit): ");
        paymentType = scanner.next();

        System.out.print("Enter card issuer (mastercard, visa, etc): ");
        paymentIssuer = scanner.next();

        System.out.print("Enter card nickname (can be anything, used for identification): ");
        paymentNickName = scanner.next();

        return new CardPayment(paymentType, paymentIssuer, paymentNickName);
    }
}
