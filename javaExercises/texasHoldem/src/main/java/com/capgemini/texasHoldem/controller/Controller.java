package com.capgemini.texasHoldem.controller;

import com.capgemini.texasHoldem.model.Poker;
import com.capgemini.texasHoldem.view.View;

public class Controller {

	public Controller() {
	}

	public void startRunning() {

		Poker poker = new Poker();
		View view = new View();

		// view.setupActionListener(new ButtonListener(poker, view));
		view.getArea().setText(poker.printHands());
		view.getField().setText(poker.printWins());
	}
}