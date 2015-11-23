package com.capgemini.texasHoldem.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JFrame {

	private final int FONT_SIZE = 20;
	private final int WINDOW_SIZE = 300;

	private JPanel buttonPanel = new JPanel();
	private JPanel textPanel = new JPanel();
	private JTextField theField = new JTextField();
	private JTextArea theArea = new JTextArea();
	private Font f = new Font("TimesNewRoman", FONT_SIZE, FONT_SIZE);

	public View() {

		this.setTitle("Texas holdem");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(WINDOW_SIZE, WINDOW_SIZE);

		theField.setFont(f);
		theField.setToolTipText("Enter number of players");
		theArea.setFont(f);

		buttonPanel.add(theField);
		textPanel.add(theArea);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(textPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public JTextArea getArea() {
		return theArea;
	}

	public JTextField getField() {
		return theField;
	}

	public void setupActionListener(ActionListener listener) {
		theField.addActionListener(listener);
	}
}
