package pokerHandsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.pokerHands.Hands;
import com.capgemini.pokerHands.SortedHands;
import com.capgemini.pokerHands.Values;

public class ValuesTest {

	@Test
	public void checkHighCard() {

		String line = "8C 7S KC 9H 4S 7D 2S 5D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 0;
		int expected2 = 0;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkPair() {

		String line = "8C 8S KC 9H 4S 7D 7S 5D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 1;
		int expected2 = 1;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void check2Pair() {

		String line = "8C 8S KC KH 4S 7D 7S 5D 5S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 2;
		int expected2 = 2;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkThree() {

		String line = "8C 8S 8C KH 4S 7D 7S 7D 5S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 3;
		int expected2 = 3;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkStraight() {

		String line = "8C 6S 7C 9H 5S 7D 6S 5D 4S 3C";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 4;
		int expected2 = 4;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkColor() {

		String line = "8C 8C 7C 9C 5C 6D 6D 5D 4D 3D";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 5;
		int expected2 = 5;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkFull() {

		String line = "8C 8S 8C 9H 9S 7D 7S 5D 5S 5C";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 6;
		int expected2 = 6;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkFour() {

		String line = "8C 8S 8C 8H 9S 7D 5S 5D 5S 5C";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 7;
		int expected2 = 7;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkStraightFlush() {

		String line = "8C 6C 7C 9C 5C 7D 6D 5D 4D 3D";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 8;
		int expected2 = 8;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}

	@Test
	public void checkRoyalStraightFlush() {

		String line = "AC KC QC JC TC TD JD AD KD QD";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);
		Values values = new Values(sHands);

		int expected1 = 9;
		int expected2 = 9;

		int actual1 = values.getValue1();
		int actual2 = values.getValue2();

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
	}
}
