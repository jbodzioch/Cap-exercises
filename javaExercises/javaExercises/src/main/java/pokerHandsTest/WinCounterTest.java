package pokerHandsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.pokerHands.Hands;
import com.capgemini.pokerHands.SortedHands;
import com.capgemini.pokerHands.Values;
import com.capgemini.pokerHands.WinCounter;

public class WinCounterTest {

	@Test
	public void shouldReturnTrueForWin() {

		String line = "8C 8S 8C 9H 4S 7D 7S 5D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sortedHands = new SortedHands(hands);
		Values values = new Values(sortedHands);
		WinCounter winCounter = new WinCounter(values);

		boolean actual = winCounter.getIsWin();

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForLose() {

		String line = "8C 8S 7C 9H 4S 7D 7S 7D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sortedHands = new SortedHands(hands);
		Values values = new Values(sortedHands);
		WinCounter winCounter = new WinCounter(values);

		boolean actual = winCounter.getIsWin();

		assertTrue(!actual);
	}

	@Test
	public void shouldReturnTrueForWinningDraw() {

		String line = "8C 8S 8C 9H 4S 7D 7S 7D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sortedHands = new SortedHands(hands);
		Values values = new Values(sortedHands);
		WinCounter winCounter = new WinCounter(values);

		boolean actual = winCounter.getIsWin();

		assertTrue(actual);
	}

	@Test
	public void shouldReturnFalseForLosingDraw() {

		String line = "8C 8S 8C 9H 4S 9D 9S 9D 3S AC";
		Hands hands = new Hands(line);
		SortedHands sortedHands = new SortedHands(hands);
		Values values = new Values(sortedHands);
		WinCounter winCounter = new WinCounter(values);

		boolean actual = winCounter.getIsWin();

		assertTrue(!actual);
	}
}
