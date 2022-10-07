package car;

public class Grandeur extends Car{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Grandeur 시동을 겁니다.");
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Grandeur 달립니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Grandeur 멈춥니다.");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("Grandeur 시동을 끕니다.");
	}

}
