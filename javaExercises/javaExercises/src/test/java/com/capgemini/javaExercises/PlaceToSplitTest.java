package com.capgemini.javaExercises;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.placeToSplit.PlaceToSplit;

public class PlaceToSplitTest {

	@Test
	public void shouldReturnTrueFor11() {

		int[] testTable = { 1, 1 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseFor1() {

		int[] testTable = { 1 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnFalseFor12() {

		int[] testTable = { 1, 2 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForMinus110() {

		int[] testTable = { -1, 1, 0 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(actual);
		;
	}

	@Test
	public void shouldReturnFalseFor111() {

		int[] testTable = { 1, 1, 1 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnFalseFor121() {

		int[] testTable = { 1, 2, 1 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueFor112() {

		int[] testTable = { 1, 1, 2 };

		boolean actual = PlaceToSplit.canBalance(testTable);

		assertTrue(actual);
	}
}
