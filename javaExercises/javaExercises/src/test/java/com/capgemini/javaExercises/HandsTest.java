package com.capgemini.javaExercises;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.capgemini.pokerHands.Hands;

public class HandsTest {

	@Test
	public void shouldReturnZerosForEmptyHand() {

		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> actual = new ArrayList<Integer>();

		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);
		expected.add(0);

		Hands hands = new Hands();

		for (int i = 0; i < hands.getHand1().size(); i++) {
			actual.add(hands.getHand1().get(i).getValue());
		}

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFirstHandValues() {

		String line = "8C TS KC 9H 4S 7D 2S 5D 3S AC";

		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> actual = new ArrayList<Integer>();

		expected.add(8);
		expected.add(10);
		expected.add(13);
		expected.add(9);
		expected.add(4);

		Hands hands = new Hands(line);

		for (int i = 0; i < hands.getHand1().size(); i++) {
			actual.add(hands.getHand1().get(i).getValue());
		}

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnSecondHandValues() {

		String line = "8C TS KC 9H 4S 7D 2S 5D 3S AC";

		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> actual = new ArrayList<Integer>();

		expected.add(7);
		expected.add(2);
		expected.add(5);
		expected.add(3);
		expected.add(14);

		Hands hands = new Hands(line);

		for (int i = 0; i < hands.getHand2().size(); i++) {
			actual.add(hands.getHand2().get(i).getValue());
		}

		assertEquals(expected, actual);
	}
}
