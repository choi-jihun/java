public class Student {
	private static int serialNum = 1000;
	int studentID;
	String studentName;
	int grade;
	String address;
	int cardNumber;
	
	public Student() {
		serialNum++;
		studentID = serialNum;
		cardNumber = serialNum+100;
		
	}
	
	public String getStudentName(){
		return studentName;
	}
	
	public void setStudentName(String name){
		studentName = name;
	}

	public static int getSerialNum() {
		int i = 10;
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Student.serialNum = serialNum;
	}
}
