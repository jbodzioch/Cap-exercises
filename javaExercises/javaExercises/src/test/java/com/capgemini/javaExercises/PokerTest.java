package com.capgemini.javaExercises;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.pokerHands.Poker;

public class PokerTest {

	Poker poker;

	@Test
	public void shouldReturnExistingResult() {

		poker = new Poker();
		String result = poker.getResult();

		assertTrue(!result.isEmpty());
	}
}
