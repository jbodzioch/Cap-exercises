package com.capgemini.gameOfLife.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.capgemini.gameOfLife.model.GameOfLife;
import com.capgemini.gameOfLife.view.View;

public class ButtonListener implements MouseListener {

	private GameOfLife game;
	private View view;

	public ButtonListener(GameOfLife game, View view) {
		this.game = game;
		this.view = view;
	}

	public void mouseClicked(MouseEvent e) {

		game.step();
		view.getArea().setText(game.printResult());
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
