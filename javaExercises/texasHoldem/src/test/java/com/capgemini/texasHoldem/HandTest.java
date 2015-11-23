package com.capgemini.texasHoldem;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.capgemini.texasHoldem.model.Card;
import com.capgemini.texasHoldem.model.Hand;

public class HandTest {

	public final int HANDSIZE = 5;

	public Hand makeHand(String input) {

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
	public void shouldReturnZerosForEmptyHand() {

		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> actual = new ArrayList<Integer>();

		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);

		Hand hands = new Hand();

		for (int i = 0; i < hands.getHand().size(); i++) {
			actual.add(hands.getHand().get(i).getValue());
		}

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnHandValues() {

		String line = "8C TS KC 9H 4S 7D 2S 5D 3S AC";

		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> actual = new ArrayList<Integer>();

		expected.add(8);
		expected.add(10);
		expected.add(13);
		expected.add(9);
		expected.add(4);

		Hand hand = makeHand(line);

		for (int i = 0; i < hand.getHand().size(); i++) {
			actual.add(hand.getHand().get(i).getValue());
		}

		assertEquals(expected, actual);
	}
}
