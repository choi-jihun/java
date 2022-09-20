public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog[] dogArray = new Dog[5];
		dogArray[0] = new Dog("멍멍이", "치아와");
		dogArray[1] = new Dog("뽀삐", "진돗개");
		dogArray[2] = new Dog("순심이", "삽살개");
		dogArray[3] = new Dog("철이", "마르티스");
		dogArray[4] = new Dog("삐쭈", "푸들");	
		
		for(int i =0; i<dogArray.length; i++) {
			System.out.println(dogArray[i].showDogInfo());
		}
	}

}