package com.capgemini.texasHoldem;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private final int HANDSIZE = 5;

	private List<Card> hand = new ArrayList<Card>();

	public List<Card> getHand() {
		return hand;
	}
	
	public void setHand(List<Card> hand){
		this.hand = hand;
	}

	public Hand() {

		for (int i = 0; i < HANDSIZE; i++) {
			hand.add(new Card());
		}
	}

	public Hand(List<Card> hand) {

		setHand(hand);
	}
}
