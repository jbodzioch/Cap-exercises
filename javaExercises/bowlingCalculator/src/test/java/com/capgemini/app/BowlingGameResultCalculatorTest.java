package com.capgemini.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameResultCalculatorTest {

	BowlingGameResultCalculatorImpl calculator;

	@Before
	public void initialize() {
		calculator = new BowlingGameResultCalculatorImpl();
	}

	@Test
	public void shouldReturnZeroAtBeginning() {

		int expected = 0;
		int result = calculator.score();

		assertEquals(expected, result);
	}

	@Test
	public void shouldReturnSixWhenThrownSixPins() {

		int firstRoll = 6;

		calculator.roll(firstRoll);

		int expected = 6;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnSixWhenThrownFourAndTwoPins() {

		int firstRoll = 4;
		int secondRoll = 2;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);

		int expected = 6;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFourteenWhenThrownEightTwoAndTwoPins() {

		int firstRoll = 8;
		int secondRoll = 2;
		int thirdRoll = 2;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);
		calculator.roll(thirdRoll);

		int expected = 14;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnThirtyEightWhenThrownEightTwoTenAndFourPins() {
		int firstRoll = 8;
		int secondRoll = 2;
		int thirdRoll = 10;
		int fourthRoll = 4;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);
		calculator.roll(thirdRoll);
		calculator.roll(fourthRoll);

		int expected = 38;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFourtyEightWhenThrownTenTwoEightAndFourPins() {
		int firstRoll = 10;
		int secondRoll = 2;
		int thirdRoll = 8;
		int fourthRoll = 4;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);
		calculator.roll(thirdRoll);
		calculator.roll(fourthRoll);

		int expected = 38;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnSixtySixWhenThrownTenTwoEightAndFourPins() {
		int firstRoll = 10;
		int secondRoll = 10;
		int thirdRoll = 8;
		int fourthRoll = 2;
		int fifthRoll = 4;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);
		calculator.roll(thirdRoll);
		calculator.roll(fourthRoll);
		calculator.roll(fifthRoll);

		int expected = 66;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFiftyEightWhenThrownTenTenTwoEightTwoAndTwoPins() {
		int firstRoll = 10;
		int secondRoll = 10;
		int thirdRoll = 2;
		int fourthRoll = 8;
		int fifthRoll = 2;
		int sixthRoll = 2;

		calculator.roll(firstRoll);
		calculator.roll(secondRoll);
		calculator.roll(thirdRoll);
		calculator.roll(fourthRoll);
		calculator.roll(fifthRoll);
		calculator.roll(sixthRoll);

		int expected = 58;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnHundredNinetySevenForGivenExample() {

		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(5);
		calculator.roll(5);
		calculator.roll(7);
		calculator.roll(2);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(0);
		calculator.roll(8);
		calculator.roll(2);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(10);

		int expected = 197;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnHundredNinetySevenForGivenExampleAndMoreThrows() {

		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(5);
		calculator.roll(5);
		calculator.roll(7);
		calculator.roll(2);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(9);
		calculator.roll(0);
		calculator.roll(8);
		calculator.roll(2);
		calculator.roll(9);
		calculator.roll(1);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(10);

		int expected = 197;
		int actual = calculator.score();

		assertEquals(expected, actual);
	}

}
