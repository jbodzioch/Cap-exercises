package source;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {

	private final int FONT_SIZE = 20;
	private final int WINDOW_SIZE = 300;

	private JPanel buttonPanel = new JPanel();
	private JButton theButton = new JButton();
	private JPanel textPanel = new JPanel();
	private JTextArea theArea = new JTextArea();
	private Font f = new Font("TimesNewRoman", FONT_SIZE, FONT_SIZE);

	public View() {

		this.setTitle("Game of Life");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);

		theButton.setText("Next Step");
		theArea.setFont(f);

		textPanel.add(theArea);
		buttonPanel.add(theButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(textPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public JTextArea getArea() {
		return theArea;
	}

	public void setupMouseListener(MouseListener listener) {
		theButton.addMouseListener(listener);
	}
}
