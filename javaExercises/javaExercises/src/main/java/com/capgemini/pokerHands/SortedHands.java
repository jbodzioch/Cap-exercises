package com.capgemini.pokerHands;

public class SortedHands {

	private Hands hands;
	private SortedHand sortedHand1;
	private SortedHand sortedHand2;

	public SortedHand getSortedHand1() {
		return sortedHand1;
	}

	public SortedHand getSortedHand2() {
		return sortedHand2;
	}

	public void setSortedHand1(SortedHand hand) {
		this.sortedHand1 = hand;
	}

	public void setSortedHand2(SortedHand hand) {
		this.sortedHand2 = hand;
	}

	public Hands getHands() {
		return hands;
	}

	public void setHands(Hands hands) {
		this.hands = hands;
	}

	public SortedHands(Hands hands) {

		setHands(hands);
		setTables(hands);
	}

	private void setTables(Hands hands) {

		sortedHand1 = new SortedHand(hands.getHand1());
		sortedHand2 = new SortedHand(hands.getHand2());
	}

}
