package pokerHandsTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.capgemini.pokerHands.Hands;
import com.capgemini.pokerHands.SortedHands;

public class SortedHandsTest {

	@Test
	public void shouldReturnZeroTablesForNull() {

		Hands hands = new Hands();
		SortedHands sHands = new SortedHands(hands);

		final int HANDSIZE = 5;

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();

		for (int j = 0; j < HANDSIZE - 4; j++) {
			expectedValues.add(0);
			expectedCount.add(5);
		}

		List<Integer> actualValues = sHands.getSortedHand1().getValueList();
		List<Integer> actualCount = sHands.getSortedHand1().getCountList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
	}

	@Test
	public void shouldReturnTableForHand1() {

		String line = "8C 8S KC 9H 4S 7D 2S 5D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();
		List<Character> expectedColors = new ArrayList<Character>();

		expectedValues.add(8);
		expectedValues.add(13);
		expectedValues.add(9);
		expectedValues.add(4);

		expectedCount.add(2);
		expectedCount.add(1);
		expectedCount.add(1);
		expectedCount.add(1);

		expectedColors.add('C');
		expectedColors.add('S');
		expectedColors.add('C');
		expectedColors.add('H');
		expectedColors.add('S');

		List<Integer> actualValues = sHands.getSortedHand1().getValueList();
		List<Integer> actualCount = sHands.getSortedHand1().getCountList();
		List<Character> actualColors = sHands.getSortedHand1().getColorList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedColors, actualColors);
	}

	@Test
	public void shouldReturnTableForHand2() {

		String line = "8C TS KC 9H 4S 7D 7S 5D 7S AC";
		Hands hands = new Hands(line);
		SortedHands sHands = new SortedHands(hands);

		List<Integer> expectedValues = new ArrayList<Integer>();
		List<Integer> expectedCount = new ArrayList<Integer>();
		List<Character> expectedColors = new ArrayList<Character>();

		expectedValues.add(7);
		expectedValues.add(14);
		expectedValues.add(5);

		expectedCount.add(3);
		expectedCount.add(1);
		expectedCount.add(1);

		expectedColors.add('D');
		expectedColors.add('S');
		expectedColors.add('D');
		expectedColors.add('S');
		expectedColors.add('C');

		List<Integer> actualValues = sHands.getSortedHand2().getValueList();
		List<Integer> actualCount = sHands.getSortedHand2().getCountList();
		List<Character> actualColors = sHands.getSortedHand2().getColorList();

		assertEquals(expectedValues, actualValues);
		assertEquals(expectedCount, actualCount);
		assertEquals(expectedColors, actualColors);
	}

}
