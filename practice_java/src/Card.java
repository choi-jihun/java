
public class Card {
	private int cardNumber;
	private static int serialNum = 10000;
	
	public Card() {
		serialNum++;
		cardNumber = serialNum;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardNumber() {
		return cardNumber;
	}
}
