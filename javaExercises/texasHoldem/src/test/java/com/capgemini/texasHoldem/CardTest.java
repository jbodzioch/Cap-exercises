package com.capgemini.texasHoldem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.texasHoldem.Card;

public class CardTest {

	private Card card;

	@Test
	public void shouldReturnZeroWhenEmpty() {

		card = new Card();

		int expected = 0;
		int actual = card.getValue();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhenTwo() {

		card = new Card("2D");

		int expected = 2;
		int actual = card.getValue();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTenWhenT() {

		card = new Card("TD");

		int expected = 10;
		int actual = card.getValue();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFourteenWhenA() {

		card = new Card("AD");
		int expected = 14;
		int actual = card.getValue();

		assertEquals(expected, actual);
	}
}
