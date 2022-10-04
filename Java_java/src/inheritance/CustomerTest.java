package inheritance;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cusLee = new Customer();
		cusLee.setCustomerID(10010);
		cusLee.setCustomerName("이순신");
		cusLee.bonusPoint=1000;
		System.out.println(cusLee.showCustomerInfo());
		VIPCustomer cusKim = new VIPCustomer();
		cusKim.setCustomerID(10020);
		cusKim.setCustomerName("김유신");
		cusKim.bonusPoint = 10000;
		System.out.println(cusKim.showCustomerInfo());
	}

}
 