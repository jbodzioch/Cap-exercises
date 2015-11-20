package com.capgemini.pokerHands;

import java.util.*;

public class Card {

	private int cardValue = 0;
	private char cardColor = 'N';
	private Map<Character, Integer> map = new HashMap<Character, Integer>();

	public int getValue() {
		return this.cardValue;
	}

	public char getColor() {
		return this.cardColor;
	}

	public void setValue(int value) {
		this.cardValue = value;
	}

	public void setColor(char color) {
		this.cardColor = color;
	}

	public Card() {
	}

	public Card(char value, char color) {

		setValue(map.get(value));
		setColor(color);
	}

	{
		map.put('2', 2);
		map.put('3', 3);
		map.put('4', 4);
		map.put('5', 5);
		map.put('6', 6);
		map.put('7', 7);
		map.put('8', 8);
		map.put('9', 9);
		map.put('T', 10);
		map.put('J', 11);
		map.put('Q', 12);
		map.put('K', 13);
		map.put('A', 14);
	}
}
