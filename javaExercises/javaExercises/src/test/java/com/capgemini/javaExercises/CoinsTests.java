package com.capgemini.javaExercises;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.coins.Coins;

public class CoinsTests {

	private List<Integer> mylist;

	@Before
	public void initialize() {
		mylist = new ArrayList<Integer>();
	}

	@Test
	public void shouldReturnOneWhen00() {

		mylist.add(0);
		mylist.add(0);

		int expected = 1;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroWhenNull() {

		int expected = 0;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroWhen0() {

		mylist.add(0);

		int expected = 0;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhen000() {

		mylist.add(0);
		mylist.add(0);
		mylist.add(0);

		int expected = 2;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhen010() {

		mylist.add(0);
		mylist.add(1);
		mylist.add(0);

		int expected = 2;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhen100() {

		mylist.add(1);
		mylist.add(0);
		mylist.add(0);

		int expected = 2;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhen001() {

		mylist.add(0);
		mylist.add(0);
		mylist.add(1);

		int expected = 2;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnThreeWhen00110() {

		mylist.add(0);
		mylist.add(0);
		mylist.add(1);
		mylist.add(1);
		mylist.add(0);

		int expected = 3;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnThreeWhen0010100() {

		mylist.add(0);
		mylist.add(0);
		mylist.add(1);
		mylist.add(0);
		mylist.add(1);
		mylist.add(0);
		mylist.add(0);

		int expected = 4;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFourWhen0011() {

		mylist.add(0);
		mylist.add(0);
		mylist.add(1);
		mylist.add(1);

		int expected = 2;
		int actual = Coins.solution(mylist);

		assertEquals(expected, actual);
	}
}
