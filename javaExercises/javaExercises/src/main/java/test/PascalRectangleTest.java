package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.pascalrectangle.PascalRectangle;

public class PascalRectangleTest {

	private PascalRectangle rect;

	@Before
	public void initialize() {
		rect = new PascalRectangle();
	}

	@Test
	public void shouldReturtOneWhen00() {

		int inputColumn = 1;
		int inputRow = 0;

		long expected = 1;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtMinusOneWhenMinusNumbers() {

		int inputColumn = -12;
		int inputRow = -1;

		long expected = -1;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtMinusOneWhenMoreColumnsThanRowsPlusOne() {

		int inputColumn = 4;
		int inputRow = 2;

		long expected = -1;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtOneWhen11() {

		int inputColumn = 1;
		int inputRow = 1;

		long expected = 1;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtOneWhen12() {

		int inputColumn = 1;
		int inputRow = 2;

		long expected = 1;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtThreeWhen23() {

		int inputColumn = 2;
		int inputRow = 3;

		long expected = 3;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturtTenWhen35() {

		int inputColumn = 3;
		int inputRow = 5;

		long expected = 10;
		long actual = rect.pascal(inputColumn, inputRow);

		assertEquals(expected, actual);
	}
}
