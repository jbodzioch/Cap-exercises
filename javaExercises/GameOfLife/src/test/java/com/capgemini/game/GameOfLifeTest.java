package test.java.com.capgemini.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.java.com.capgemini.game.GameOfLife;

public class GameOfLifeTest {

	GameOfLife game;

	@Test
	public void shouldCountNeighborsForNonBorder() {

		game = new GameOfLife();

		int expected = 6;

		int actual = game.countNeighbors(2, 2);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldCountNeighborsForBorder() {

		game = new GameOfLife();

		int expected = 1;

		int actual = game.countNeighbors(0, 0);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn0ForKilledLivingWithLessThanTwoLivingNeighbors() {

		Map<Integer, List<Integer>> listOfRows = new HashMap<Integer, List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		List<Integer> row2 = new ArrayList<Integer>();
		List<Integer> row3 = new ArrayList<Integer>();

		row1.add(0);
		row1.add(0);
		row1.add(0);

		row2.add(0);
		row2.add(1);
		row2.add(0);

		row3.add(0);
		row3.add(0);
		row3.add(0);

		listOfRows.put(0, row1);
		listOfRows.put(1, row2);
		listOfRows.put(2, row3);

		game = new GameOfLife(listOfRows);
		game.step();

		int expected = 0;

		int actual = game.getListOfRows().get(1).get(1);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn0ForKilledLivingWithMoreThanThreeLivingNeighbors() {

		Map<Integer, List<Integer>> listOfRows = new HashMap<Integer, List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		List<Integer> row2 = new ArrayList<Integer>();
		List<Integer> row3 = new ArrayList<Integer>();

		row1.add(1);
		row1.add(1);
		row1.add(1);

		row2.add(1);
		row2.add(1);
		row2.add(1);

		row3.add(1);
		row3.add(1);
		row3.add(1);

		listOfRows.put(0, row1);
		listOfRows.put(1, row2);
		listOfRows.put(2, row3);

		game = new GameOfLife(listOfRows);
		game.step();

		int expected = 0;

		int actual = game.getListOfRows().get(1).get(1);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn1ForStillLivingWithThreeLivingNeighbors() {

		Map<Integer, List<Integer>> listOfRows = new HashMap<Integer, List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		List<Integer> row2 = new ArrayList<Integer>();
		List<Integer> row3 = new ArrayList<Integer>();

		row1.add(1);
		row1.add(1);
		row1.add(1);

		row2.add(0);
		row2.add(1);
		row2.add(0);

		row3.add(0);
		row3.add(0);
		row3.add(0);

		listOfRows.put(0, row1);
		listOfRows.put(1, row2);
		listOfRows.put(2, row3);

		game = new GameOfLife(listOfRows);
		game.step();

		int expected = 1;

		int actual = game.getListOfRows().get(1).get(1);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturn1ForResurrectedDeadWithThreeLivingNeighbors() {

		Map<Integer, List<Integer>> listOfRows = new HashMap<Integer, List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		List<Integer> row2 = new ArrayList<Integer>();
		List<Integer> row3 = new ArrayList<Integer>();

		row1.add(1);
		row1.add(1);
		row1.add(1);

		row2.add(0);
		row2.add(0);
		row2.add(0);

		row3.add(0);
		row3.add(0);
		row3.add(0);

		listOfRows.put(0, row1);
		listOfRows.put(1, row2);
		listOfRows.put(2, row3);

		game = new GameOfLife(listOfRows);
		game.step();

		int expected = 1;

		int actual = game.getListOfRows().get(1).get(1);

		assertEquals(expected, actual);
	}

}
