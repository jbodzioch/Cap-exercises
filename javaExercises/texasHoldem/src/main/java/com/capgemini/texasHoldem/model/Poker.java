package com.capgemini.texasHoldem.model;

import java.util.*;

public class Poker {

	private final int HANDSIZE = 5;

	private int numberOfPlayers = 4;
	private List<String> deck = new ArrayList<String>();
	List<Hand> hands = new ArrayList<Hand>();
	WinCounter wins;
	
	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}
	
	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}

	public Poker() {

		hands = createHands(deck);
		List<SortedHand> sortedHands = sortHands(hands);
		Values values = evaluate(sortedHands);
		wins = countFirstHandWins(values);
	}

	private Hand createHand(List<String> deck) {

		List<Card> handInput = new ArrayList<Card>();
		Hand hand;

		for (int i = 0; i < HANDSIZE; i++) {
			handInput.add(getCardFromDeck());
		}
		
		hand = new Hand(handInput);

		return hand;
	}
	
	public Card getCardFromDeck(){
		Card result;
		
		int randomCard = (int) (Math.random() * deck.size());
		
		result = new Card(deck.get(randomCard));
		deck.remove(randomCard);
		
		return result;
	}
	
	public String printHands(){
		
		List<Hand> cardList = hands;
		String result = "";
		
		for(int i=0; i<cardList.size(); i++){
			for(int j=0; j<cardList.get(i).getHand().size(); j++){
				result = result + Integer.toString(cardList.get(i).getHand().get(j).getValue()) + cardList.get(i).getHand().get(j).getColor() + " ";
			}
			result = result + "\n";
		}
		
		return result.substring(0, result.length()-1);
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

	public String printWins() {
		String result = "Won by : " + wins.getWhoWon();
		
		return result;
		
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
