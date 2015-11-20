package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.pythagorean.Pythagorean;

public class PythagoreanTest {

	private Pythagorean pyt = new Pythagorean();

	@Before
	public void initialize() {
		pyt.calculate();
	}

	@Test
	public void shouldReturnTrueForALowestCGreatest() {

		boolean actual = false;

		if (pyt.getB() > pyt.getA() && pyt.getC() > pyt.getB()) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void shouldReturnTrueForAPowPlusBPowEqualsCPow() {

		boolean actual = false;

		if (Math.pow(pyt.getA(), 2) + Math.pow(pyt.getB(), 2) == Math.pow(pyt.getC(), 2)) {
			actual = true;
		}

		assertTrue(actual);
	}

	@Test
	public void shouldReturnThousand() {

		int expected = 1000;
		int actual = pyt.getA() + pyt.getB() + pyt.getC();

		pyt.printResult();

		assertEquals(expected, actual);
	}
}
