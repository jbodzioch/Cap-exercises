package com.capgemini.texasHoldem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.texasHoldem.model.Card;
import com.capgemini.texasHoldem.model.Hand;
import com.capgemini.texasHoldem.model.SortedHand;
import com.capgemini.texasHoldem.model.Values;
import com.capgemini.texasHoldem.model.WinCounter;

public class WinCounterTest {

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
	public void shouldReturnOneForFirstPlayerWin() {

		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		Values values = new Values(sortedHands);
		values.getValues().add(9);
		values.getValues().add(7);		
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 1;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn2ForSecondPlayerWin() {

		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		Values values = new Values(sortedHands);
		values.getValues().add(5);
		values.getValues().add(7);		
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 2;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn3ForThirdPlayerWin() {

		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		Values values = new Values(sortedHands);
		values.getValues().add(5);
		values.getValues().add(7);	
		values.getValues().add(11);	
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 3;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn4ForFourthPlayerWin() {

		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		Values values = new Values(sortedHands);
		values.getValues().add(6);
		values.getValues().add(6);	
		values.getValues().add(2);	
		values.getValues().add(14);	
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 4;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn1ForFirstPlayerDrawWin() {

		String line = "8C 8C 7C 9C 5C 6D 6D 5D 4D 3D";
		Hand hands = makeHand(line.substring(0, 14));
		Hand hands2 = makeHand(line.substring(15, 29));
		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		sortedHands.add(new SortedHand(hands));
		sortedHands.add(new SortedHand(hands2));
	
		Values values = new Values(sortedHands);
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 1;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturn2ForSecondPlayerDrawWin() {

		String line = "8C 8C 7C 9C 5C TD TD 5D 4D 3D";
		Hand hands = makeHand(line.substring(0, 14));
		Hand hands2 = makeHand(line.substring(15, 29));
		List<SortedHand> sortedHands = new ArrayList<SortedHand>();
		sortedHands.add(new SortedHand(hands));
		sortedHands.add(new SortedHand(hands2));
	
		Values values = new Values(sortedHands);
		
		WinCounter winCounter = new WinCounter(values);

		int expected = 2;
		int actual = winCounter.getWhoWon();

		assertEquals(expected, actual);
	}

	
}
