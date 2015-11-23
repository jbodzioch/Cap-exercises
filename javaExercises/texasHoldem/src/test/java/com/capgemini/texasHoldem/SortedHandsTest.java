package com.capgemini.texasHoldem;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.capgemini.texasHoldem.model.Card;
import com.capgemini.texasHoldem.model.Hand;
import com.capgemini.texasHoldem.model.SortedHand;

public class SortedHandsTest {
	
	private final int HANDSIZE = 5;
	
	public Hand makeHand(String input){
		
		List<String> deck = new ArrayList<String>();
		deck.add(input.substring(0, 2));
		deck.add(input.substring(3, 5));
		deck.add(input.substring(6, 8));
		deck.add(input.substring(9, 11));
		deck.add(input.substring(12, 14));

		List<Card> handInput = new ArrayList<Card>();
		
		for (int i = 0; i < HANDSIZE; i++) {

			handInput.add(new Card(deck.get(i)));
		}

		Hand hand = new Hand(handInput);

		return hand;
	}

	@Test
	public void shouldReturnZeroTablesForNull() {

		Hand hands = new Hand();
		SortedHand sHands = new SortedHand(hands);

		final int HANDSIZE = 5;

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();

		for (int j = 0; j < HANDSIZE - 4; j++) {
			expectedValues.add(0);
			expectedCount.add(5);
		}

		List<Integer> actualValues = sHands.getValueList();
		List<Integer> actualCount = sHands.getCountList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
	}

	@Test
	public void shouldReturnTableForHand2() {

		String line = "8C 8S KC 9H 4S 7D 2S 5D 3S AC";
		
		
		Hand hands = makeHand(line.substring(15, 29));
		SortedHand sHands = new SortedHand(hands);

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();
		List<Character> expectedColors = new ArrayList<Character>();

		expectedValues.add(14);
		expectedValues.add(7);
		expectedValues.add(5);
		expectedValues.add(3);
		expectedValues.add(2);

		expectedCount.add(1);
		expectedCount.add(1);
		expectedCount.add(1);
		expectedCount.add(1);
		expectedCount.add(1);

		expectedColors.add('D');
		expectedColors.add('S');
		expectedColors.add('D');
		expectedColors.add('S');
		expectedColors.add('C');

		List<Integer> actualValues = sHands.getValueList();
		List<Integer> actualCount = sHands.getCountList();
		List<Character> actualColors = sHands.getColorList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedColors, actualColors);
	}
	
	@Test
	public void shouldReturnTableForHand1() {

		String line = "8C 8S KC 9H 4S 7D 2S 5D 3S AC";
		
		
		Hand hands = makeHand(line);
		SortedHand sHands = new SortedHand(hands);

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();
		List<Character> expectedColors = new ArrayList<Character>();

		expectedValues.add(8);
		expectedValues.add(13);
		expectedValues.add(9);
		expectedValues.add(4);

		expectedCount.add(2);
		expectedCount.add(1);
		expectedCount.add(1);
		expectedCount.add(1);

		expectedColors.add('C');
		expectedColors.add('S');
		expectedColors.add('C');
		expectedColors.add('H');
		expectedColors.add('S');

		List<Integer> actualValues = sHands.getValueList();
		List<Integer> actualCount = sHands.getCountList();
		List<Character> actualColors = sHands.getColorList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedColors, actualColors);
	}

}
