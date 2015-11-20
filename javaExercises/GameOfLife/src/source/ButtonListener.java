package source;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {

	private GameOfLife game;
	private View view;

	public ButtonListener(GameOfLife game, View view) {
		this.game = game;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		game.step();
		view.getArea().setText(game.printResult());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
