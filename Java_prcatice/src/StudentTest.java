public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student studentLee = new Student(1001,"Lee");
		Student studentKim = new Student(1002,"Kim");
		studentLee.addSubject("����", 100);
		studentLee.addSubject("����", 90);
		studentKim.addSubject("����", 90);
		studentKim.addSubject("����", 70);
		studentKim.addSubject("����", 90);
		
		studentLee.showStudentInfo();
		System.out.println("==============================");
		studentKim.showStudentInfo();
	}

}
