package com.capgemini.pokerHands;

import java.io.*;
import java.util.*;

public class Poker {

	private final String adress = "src/main/java/com/capgemini/pokerHands/poker.txt";
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Poker() {

		List<String> lines = getLines(adress);
		List<Hands> hands = createHands(lines);
		List<SortedHands> sortedHands = sortHands(hands);
		List<Values> values = evaluate(sortedHands);
		List<WinCounter> wins = countFirstHandWins(values);
		setResult(printWins(wins));
	}

	private List<String> getLines(String adress) {

		List<String> lines = new ArrayList<String>();

		File file = new File(adress);
		Scanner sc;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			sc.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lines;
	}

	private List<Hands> createHands(List<String> lines) {

		List<Hands> hands = new ArrayList<Hands>();

		for (int i = 0; i < lines.size(); i++) {
			hands.add(new Hands(lines.get(i)));
		}

		return hands;
	}

	private List<SortedHands> sortHands(List<Hands> hands) {

		List<SortedHands> sortedHands = new ArrayList<SortedHands>();

		for (int i = 0; i < hands.size(); i++) {
			sortedHands.add(new SortedHands(hands.get(i)));
		}

		return sortedHands;
	}

	private List<Values> evaluate(List<SortedHands> sortedHands) {

		List<Values> values = new ArrayList<Values>();

		for (int i = 0; i < sortedHands.size(); i++) {
			values.add(new Values(sortedHands.get(i)));
		}

		return values;
	}

	private List<WinCounter> countFirstHandWins(List<Values> values) {

		List<WinCounter> wins = new ArrayList<WinCounter>();

		for (int i = 0; i < values.size(); i++) {
			wins.add(new WinCounter(values.get(i)));
		}

		return wins;
	}

	private String printWins(List<WinCounter> winCounter) {

		String result;
		int wins = 0;

		for (int i = 0; i < winCounter.size(); i++) {
			if (winCounter.get(i).getIsWin()) {
				wins++;
			}
		}

		result = "Won by hand 1: " + wins;

		return result;
	}
}
