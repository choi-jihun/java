import java.util.ArrayList;
public class DogTestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Dog> list = new ArrayList<Dog>();
		list.add(new Dog("�۸���", "ġ�ƿ�"));
		list.add(new Dog("�ǻ�", "������"));
		list.add(new Dog("������", "��찳"));
		list.add(new Dog("ö��", "����Ƽ��"));
		list.add(new Dog("����", "Ǫ��"));
		
		for(int i = 0; i< list.size(); i++) {
			Dog dog = list.get(i);
		}
		for(Dog dog : list)
			System.out.println(dog.showDogInfo());		
	}

}
