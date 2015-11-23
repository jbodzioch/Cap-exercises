package com.capgemini.gameOfLife.controller;

import com.capgemini.gameOfLife.model.GameOfLife;
import com.capgemini.gameOfLife.view.View;

public class Controller {

	public Controller() {
	}
	
	public void startRunning(){
		
		GameOfLife game = new GameOfLife();
		View view = new View();

		view.setupMouseListener(new ButtonListener(game, view));
		view.getArea().setText(game.printResult());
	}
}
