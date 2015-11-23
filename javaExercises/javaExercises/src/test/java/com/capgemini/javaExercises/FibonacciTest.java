package com.capgemini.javaExercises;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.fibonacci.Fibonacci;

public class FibonacciTest {

	@Test
	public void shouldReturnOneWhenZero() {

		long expected = 1;
		long actual = Fibonacci.fib(0);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnMinusOneWhenMinusOne() {

		long expected = -1;
		long actual = Fibonacci.fib(-1);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnMinusOneWhenMinusTwo() {

		long expected = -1;
		long actual = Fibonacci.fib(-2);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnOneWhenOne() {

		long expected = 1;
		long actual = Fibonacci.fib(1);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnTwoWhenTwo() {

		long expected = 2;
		long actual = Fibonacci.fib(2);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnThreeWhenThree() {

		long expected = 3;
		long actual = Fibonacci.fib(3);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnFiveWhenFour() {

		long expected = 5;
		long actual = Fibonacci.fib(4);

		assertEquals(expected, actual);
	}
}
