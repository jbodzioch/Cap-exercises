package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;

public class SortedHand {

	private final int HANDSIZE = 5;

	private List<Integer> valueList = new ArrayList<Integer>();
	private List<Integer> countList = new ArrayList<Integer>();
	private List<Character> colorList = new ArrayList<Character>();
	private List<Card> hand = new ArrayList<Card>();

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public List<Integer> getValueList() {
		return valueList;
	}

	public List<Integer> getCountList() {
		return countList;
	}

	public List<Character> getColorList() {
		return colorList;
	}

	public SortedHand(List<Card> hand) {

		setHand(hand);
		sortTables(hand);
	}

	private void sortTables(List<Card> hand) {

		sortByValues(countList, valueList);
	}

	private void fillCardValues(List<Card> hand) {

		for (int j = 0; j < HANDSIZE; j++) {
			valueList.add(hand.get(j).getValue());
		}
	}

	private void fillCardColors(List<Card> hand) {

		fillCardValues(hand);

		for (int j = 0; j < HANDSIZE; j++) {
			colorList.add(hand.get(j).getColor());
		}
	}

	private void fillValuesCounters(List<Card> hand) {

		fillCardColors(hand);

		for (int i = 0; i < HANDSIZE; i++) {
			int counter1 = 0;

			for (int j = 0; j < HANDSIZE; j++) {
				if (valueList.get(j) == valueList.get(i)) {
					counter1++;
				}
			}
			countList.add(counter1);
		}
	}

	private void removeRepeated(List<Integer> countList, List<Integer> valueList) {

		fillValuesCounters(getHand());

		for (int i = 0; i < countList.size() - 1; i++) {
			for (int j = i + 1; j < countList.size(); j++) {
				if (countList.get(i) == countList.get(j) && valueList.get(i) == valueList.get(j)) {
					countList.remove(j);
					valueList.remove(j);
					j--;
				}

			}
		}
	}

	private void sortByCounters(List<Integer> countList, List<Integer> valueList) {

		removeRepeated(countList, valueList);

		int tempValue = 0;
		int tempCount = 0;

		for (int i = 0; i < countList.size() - 1; i++) {
			for (int j = i + 1; j < countList.size(); j++) {
				if (countList.get(j) > countList.get(i)) {
					tempValue = valueList.get(j);
					tempCount = countList.get(j);
					valueList.set(j, valueList.get(i));
					countList.set(j, countList.get(i));
					valueList.set(i, tempValue);
					countList.set(i, tempCount);
				}
			}
		}

	}

	private void sortByValues(List<Integer> countList, List<Integer> valueList) {

		sortByCounters(countList, valueList);

		int tempValue = 0;
		int tempCount = 0;

		for (int i = 0; i < countList.size() - 1; i++) {
			for (int j = i + 1; j < countList.size(); j++) {
				if (valueList.get(j) > valueList.get(i) && countList.get(j) == countList.get(i)) {

					tempValue = valueList.get(j);
					tempCount = countList.get(j);
					valueList.set(j, valueList.get(i));
					countList.set(j, countList.get(i));
					valueList.set(i, tempValue);
					countList.set(i, tempCount);
				}
			}
		}
	}

}
