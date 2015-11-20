package com.capgemini.pokerHands;

public class WinCounter {

	private Values values;
	private SortedHands sortedHands;
	private boolean isWin = false;

	public boolean getIsWin() {
		return isWin;
	}

	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}

	public Values getValues() {
		return values;
	}

	public SortedHands getSortedHands() {
		return sortedHands;
	}

	public void setValues(Values values) {
		this.values = values;
	}

	public void setSortedHands(SortedHands sortedHands) {
		this.sortedHands = sortedHands;
	}

	public WinCounter(Values values) {

		setValues(values);
		setSortedHands(values.getSortedHands());
		setIsWin(checkWin());
	}

	private boolean checkWin() {

		boolean result = false;

		if (values.getValue1() > values.getValue2()) {
			result = true;
		}

		if (values.getValue1() == values.getValue2()) {
			if (checkWhenDraw()) {
				result = true;
			}
		}

		return result;
	}

	private boolean checkWhenDraw() {

		boolean result = false;

		if (sortedHands.getSortedHand1().getValueList().get(0) > sortedHands.getSortedHand2().getValueList().get(0)) {
			result = true;
		}

		return result;
	}

}
