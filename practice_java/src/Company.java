public class Company {
	private static Company instance = new Company();

	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	public static Card createCard() {
		
		Card card = new Card();
		return card;
	}
}
	