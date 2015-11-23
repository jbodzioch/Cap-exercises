package main.java.com.capgemini.game;

public class Controller {

	public Controller() {
	}
	
	public void startThis(){
		
		GameOfLife game = new GameOfLife();
		View view = new View();

		view.setupMouseListener(new ButtonListener(game, view));
		view.getArea().setText(game.printResult());
	}
}
