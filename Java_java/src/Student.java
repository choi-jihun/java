
import java.util.ArrayList;

public class Student {
	private int studentID;
	String studentName;
	ArrayList<Subject> subList;
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		subList = new ArrayList<Subject>();
	}
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		subject.setName(name);
		subject.setScorePoint(score);
		subList.add(subject);
	}
	
	public void showStudentInfo() {
		int total = 0;
		for(Subject s : subList) {
			total += s.getScorePoint();
			System.out.println("학생 " + studentName + "의" + s.getName() + " 과목 성적은 " + s.getScorePoint() + "입니다.");
		}
		System.out.println("학생 " + studentName + "의 총점은"+ total + " 입니다.");
	}
}