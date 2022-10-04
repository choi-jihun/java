package inheritance;

public class Employee {
	public String name;
	public String grade;
	public Employee(String name) {
		this.name = name;
	}
}
class Engineer extends Employee{
	public Engineer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	} //없으면 오류 왜냐? 상위클래스에 디폴트 생성자 Employee()가 없기 때문.
	  //따라서 하위 클래스에서 생성자 정의 후 super()를 통해 명시적 호출 해야함.
	private String skillset;
	public String getskillSet() {
		return skillset;
	}
	public void setSkillSet(String skillset) {
		this.skillset = skillset;
	}
}
