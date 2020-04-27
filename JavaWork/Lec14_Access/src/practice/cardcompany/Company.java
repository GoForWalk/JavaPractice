package practice.cardcompany;

public class Company {

	private int cardNumCnt = 10000;
	
	private static Company instance = null;
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public Card createCard() {
		cardNumCnt++;
	//	Card cd= new Card();
	//	cd.setCardNumber(cardNumCnt);
		Card cd = new Card(cardNumCnt);
		return cd;
	}
		
		
} // end class
