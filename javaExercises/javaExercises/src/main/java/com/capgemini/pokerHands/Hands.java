package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;

public class Hands {

	private final int HANDSIZE = 5;
	private final int DISTANCE_BETWEEN_CARDS = 3;
	private final int DISTANCE_BETWEEN_CHARACTERS = 1;
	private final int DISTANCE_BETWEEN_HANDS = 15;

	private List<Card> hand1 = new ArrayList<Card>();
	private List<Card> hand2 = new ArrayList<Card>();

	public List<Card> getHand1() {
		return hand1;
	}

	public List<Card> getHand2() {
		return hand2;
	}

	public Hands() {

		for (int i = 0; i < HANDSIZE; i++) {
			hand1.add(new Card());
			hand2.add(new Card());
		}
	}

	public Hands(String theLine) {

		for (int i = 0; i < HANDSIZE; i++) {
			hand1.add(new Card(theLine.charAt(DISTANCE_BETWEEN_CARDS * i),
					theLine.charAt(DISTANCE_BETWEEN_CARDS * i + DISTANCE_BETWEEN_CHARACTERS)));
			hand2.add(new Card(theLine.charAt(DISTANCE_BETWEEN_CARDS * i + DISTANCE_BETWEEN_HANDS),
					theLine.charAt(DISTANCE_BETWEEN_CARDS * i + DISTANCE_BETWEEN_HANDS + DISTANCE_BETWEEN_CHARACTERS)));
		}
	}
}
