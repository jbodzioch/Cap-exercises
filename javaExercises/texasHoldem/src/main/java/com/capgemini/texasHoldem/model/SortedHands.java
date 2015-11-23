package com.capgemini.texasHoldem.model;

import java.util.List;

public class SortedHands {

	private List<Hand> hands;
	private List<SortedHand> sortedHands;

	public List<SortedHand> getSortedHands() {
		return sortedHands;
	}

	public void setSortedHands(List<SortedHand> hand) {
		this.sortedHands = hand;
	}

	public List<Hand> getHands() {
		return hands;
	}

	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}

	public SortedHands(List<Hand> hands) {

		setHands(hands);
		setTables(hands);
	}

	private void setTables(List<Hand> hands) {

		for(int i=0; i<hands.size(); i++){
			sortedHands.add (new SortedHand(hands.get(i)));
		}
	}

}
