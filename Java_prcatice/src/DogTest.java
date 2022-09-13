
public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog[] dogArray = new Dog[5];
		dogArray[0] = new Dog("¸Û¸ÛÀÌ", "Ä¡¾Æ¿Í");
		dogArray[1] = new Dog("»Ç»ß", "Áøµ¾°³");
		dogArray[2] = new Dog("¼ø½ÉÀÌ", "»ð»ì°³");
		dogArray[3] = new Dog("Ã¶ÀÌ", "¸¶¸£Æ¼½º");
		dogArray[4] = new Dog("»ßÂÞ", "Çªµé");	
		
		for(int i =0; i<dogArray.length; i++) {
			System.out.println(dogArray[i].showDogInfo());
		}
	}

}
