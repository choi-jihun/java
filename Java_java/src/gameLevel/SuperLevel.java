package gameLevel;

public class SuperLevel extends PlayerLevel {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("빠르게 달립니다");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("높이 jump합니다");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("한 바퀴 돕니다");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("***** 고급자 레벨입니다. *****");
	}

}
