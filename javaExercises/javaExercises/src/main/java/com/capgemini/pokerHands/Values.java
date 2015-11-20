package com.capgemini.pokerHands;

import java.util.*;

public class Values {

	private final int SINGLE_CARD = 1;
	private final int PAIR_OF_A_KIND = 2;
	private final int THREE_OF_A_KIND = 3;
	private final int FOUR_OF_A_KIND = 4;
	private final int ACE = 14;

	private Map<String, Integer> map = new HashMap<String, Integer>();
	private SortedHands sortedHands;
	private int value1;
	private int value2;

	public SortedHands getSortedHands() {
		return sortedHands;
	}

	public void setSortedHands(SortedHands sortedHands) {
		this.sortedHands = sortedHands;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public Values(SortedHands sortedHands) {

		setSortedHands(sortedHands);
		setValues(sortedHands);
	}

	public void setValues(SortedHands sortedHands) {

		setValue1(checkRoyalStraightFlush(sortedHands.getSortedHand1().getCountList(),
				sortedHands.getSortedHand1().getValueList(), sortedHands.getSortedHand1().getColorList()));
		setValue2(checkRoyalStraightFlush(sortedHands.getSortedHand2().getCountList(),
				sortedHands.getSortedHand2().getValueList(), sortedHands.getSortedHand2().getColorList()));
	}

	public int checkPair(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (countList.get(0) == PAIR_OF_A_KIND) {
			return map.get("Pair");
		}

		return map.get("High card");
	}

	public int check2Pairs(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (countList.get(0) == PAIR_OF_A_KIND && countList.get(1) == PAIR_OF_A_KIND) {
			return map.get("Two pairs");
		}

		return checkPair(countList, valueList, colorList);
	}

	public int checkThree(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (countList.get(0) == THREE_OF_A_KIND && countList.get(1) == SINGLE_CARD) {
			return map.get("Three");
		}

		return check2Pairs(countList, valueList, colorList);
	}

	public int checkStraight(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (isStraight(countList, valueList)) {
			return map.get("Straight");
		}

		return checkThree(countList, valueList, colorList);
	}

	public int checkColor(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (isColor(colorList)) {
			return map.get("Color");
		}

		return checkStraight(countList, valueList, colorList);
	}

	public int checkFull(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (countList.get(0) == THREE_OF_A_KIND && countList.get(1) == PAIR_OF_A_KIND) {
			return map.get("Full");
		}

		return checkColor(countList, valueList, colorList);
	}

	public int checkFour(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (countList.get(0) == FOUR_OF_A_KIND) {
			return map.get("Four");
		}

		return checkFull(countList, valueList, colorList);
	}

	public int checkStraightFlush(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (isStraight(countList, valueList) && isColor(colorList)) {
			return map.get("Straight Flush");
		}

		return checkFour(countList, valueList, colorList);
	}

	public int checkRoyalStraightFlush(List<Integer> countList, List<Integer> valueList, List<Character> colorList) {

		if (isStraight(countList, valueList) && isColor(colorList) && valueList.get(0) == ACE) {
			return map.get("Royal Straight Flush");
		}

		return checkStraightFlush(countList, valueList, colorList);
	}

	public boolean isStraight(List<Integer> countList, List<Integer> valueList) {

		boolean result = false;

		if (valueList.get(0) == valueList.get(valueList.size() - 1) + 4 && countList.get(0) == 1) {
			result = true;
		}

		return result;
	}

	public boolean isColor(List<Character> colorList) {

		boolean result = false;

		if (colorList.get(0) == colorList.get(1) && colorList.get(0) == colorList.get(2)
				&& colorList.get(0) == colorList.get(3) && colorList.get(0) == colorList.get(4)) {
			result = true;
		}

		return result;
	}

	{
		map.put("High card", 0);
		map.put("Pair", 1);
		map.put("Two pairs", 2);
		map.put("Three", 3);
		map.put("Straight", 4);
		map.put("Color", 5);
		map.put("Full", 6);
		map.put("Four", 7);
		map.put("Straight Flush", 8);
		map.put("Royal Straight Flush", 9);
	}
}
