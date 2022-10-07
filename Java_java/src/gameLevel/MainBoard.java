package gameLevel;

public class MainBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player();
		player.play(1);
		
		AdvancedLevel aplayer = new AdvancedLevel();
		player.upgradeLevel(aplayer);
		player.play(1);

		SuperLevel splayer = new SuperLevel();
		player.upgradeLevel(splayer);
		player.play(1);
	}

}
