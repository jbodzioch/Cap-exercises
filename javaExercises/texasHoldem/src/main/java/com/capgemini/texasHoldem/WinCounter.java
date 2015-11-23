package com.capgemini.texasHoldem;

import java.util.ArrayList;
import java.util.List;

public class WinCounter {

	private Values values;
	private List<SortedHand> sortedHands;
	private int whoWon;

	public int getWhoWon() {
		return whoWon;
	}

	public void setWhoWon(int whoWon) {
		this.whoWon = whoWon;
	}

	public Values getValues() {
		return values;
	}

	public List<SortedHand> getSortedHands() {
		return sortedHands;
	}

	public void setValues(Values values) {
		this.values = values;
	}

	public void setSortedHands(List<SortedHand> list) {
		this.sortedHands = list;
	}

	public WinCounter(Values values) {

		setValues(values);
		setSortedHands(values.getSortedHands());
		setWhoWon(checkWin());
	}

	private int checkWin() {

		int result = 0;
		int tempMax = 0;
		List<Integer> tempWinners = new ArrayList<Integer>();
		
		for(int i=0; i<values.getValues().size(); i++){
			if(values.getValues().get(i)>tempMax){
				tempMax = values.getValues().get(i);
				result = i;
			}
		}
		
		for(int i=0; i<values.getValues().size(); i++){
			if(values.getValues().get(i)==tempMax){
				tempWinners.add(i);
			}
		}
		
		if(tempWinners.size()>1){
			result = checkWhenDraw(tempWinners);
				
		}

		return result+1;
	}

	private int checkWhenDraw(List<Integer> list) {

		int result = 0;
		int tempMax = 0;
		
		for(int i=0; i<list.size(); i++){
			if(sortedHands.get(i).getValueList().get(0)>tempMax){
				tempMax = sortedHands.get(i).getValueList().get(0);
				result = list.get(i);
			}
		}

		return result;
	}

}
