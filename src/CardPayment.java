/**
 * Card payment type. Used to represent debit/credit cards of visa/mastercard types.
 */
public class CardPayment extends Payment{
    private String cardType;
    private String nickName;

    public CardPayment(String type, String cardType, String nickName) {
        super(type);
        this.cardType = cardType;
        this.nickName = nickName;
    }

    public String getCardType() {
        return cardType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
