package com.capgemini.texasHoldem;

import java.util.*;

public class Poker {

	private final int HANDSIZE = 5;

	private int numberOfPlayers = 4;
	private List<String> deck = new ArrayList<String>();

	public Poker() {

		List<Hand> hands = createHands(deck);
		List<SortedHand> sortedHands = sortHands(hands);
		Values values = evaluate(sortedHands);
		WinCounter wins = countFirstHandWins(values);
		printWins(wins);
	}

	private Hand createHand(List<String> deck) {

		List<Card> handInput = new ArrayList<Card>();
		Hand hand;

		for (int i = 0; i < HANDSIZE; i++) {
			int randomCard = (int) (Math.random() * deck.size());

			handInput.add(new Card(deck.get(randomCard)));
			deck.remove(randomCard);
		}
		

		for(int i=0; i<handInput.size(); i++){
			System.out.print(Integer.toString(handInput.get(i).getValue()) + handInput.get(i).getColor() + " ");
		}
		System.out.println();

		hand = new Hand(handInput);

		return hand;
	}

	private List<Hand> createHands(List<String> deck) {

		List<Hand> hands = new ArrayList<Hand>();

		for (int i = 0; i < numberOfPlayers; i++) {

			hands.add(createHand(deck));
		}

		return hands;
	}

	private List<SortedHand> sortHands(List<Hand> hands) {

		List<SortedHand> sortedHand = new ArrayList<SortedHand>();

		for (int i = 0; i < hands.size(); i++) {
			sortedHand.add(new SortedHand(hands.get(i)));
		}

		return sortedHand;
	}

	private Values evaluate(List<SortedHand> sortedHands) {

		Values values = new Values(sortedHands);

		return values;
	}

	private WinCounter countFirstHandWins(Values values) {

		WinCounter wins = new WinCounter(values);

		return wins;
	}

	private void printWins(WinCounter winCounter) {

		System.out.println("Won by : " + winCounter.getWhoWon());
		
	}

	{
		deck.add("2D");
		deck.add("3D");
		deck.add("4D");
		deck.add("5D");
		deck.add("6D");
		deck.add("7D");
		deck.add("8D");
		deck.add("9D");
		deck.add("TD");
		deck.add("JD");
		deck.add("QD");
		deck.add("KD");
		deck.add("AD");

		deck.add("2H");
		deck.add("3H");
		deck.add("4H");
		deck.add("5H");
		deck.add("6H");
		deck.add("7H");
		deck.add("8H");
		deck.add("9H");
		deck.add("TH");
		deck.add("JH");
		deck.add("QH");
		deck.add("KH");
		deck.add("AH");

		deck.add("2S");
		deck.add("3S");
		deck.add("4S");
		deck.add("5S");
		deck.add("6S");
		deck.add("7S");
		deck.add("8S");
		deck.add("9S");
		deck.add("TS");
		deck.add("JS");
		deck.add("QS");
		deck.add("KS");
		deck.add("AS");

		deck.add("2C");
		deck.add("3C");
		deck.add("4C");
		deck.add("5C");
		deck.add("6C");
		deck.add("7C");
		deck.add("8C");
		deck.add("9C");
		deck.add("TC");
		deck.add("JC");
		deck.add("QC");
		deck.add("KC");
		deck.add("AC");
	}
}
