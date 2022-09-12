public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company cardCompany = Company.getInstance();
		Card myCard = Company.createCard();
		Card yourCard = Company.createCard();
		
		System.out.println(myCard.getCardNumber());
		System.out.println(yourCard.getCardNumber());
	}

}
