package com.capgemini.javaExercises;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.taxi.Taxi;

public class TaxiTest {

	Taxi taxi;

	@Test
	public void shouldReturnExistingResult() {

		taxi = new Taxi();
		String result = taxi.getResult();

		assertTrue(!result.isEmpty());
	}
}
