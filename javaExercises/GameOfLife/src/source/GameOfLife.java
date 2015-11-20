package source;

import java.util.*;
import java.util.Map.Entry;

public class GameOfLife {

	private List<List<Integer>> listOfCounterRows = new ArrayList<List<Integer>>();
	private Map<Integer, List<Integer>> listOfRows = new HashMap<Integer, List<Integer>>();
	private List<Integer> row1 = new ArrayList<Integer>();
	private List<Integer> row2 = new ArrayList<Integer>();
	private List<Integer> row3 = new ArrayList<Integer>();
	private List<Integer> row4 = new ArrayList<Integer>();
	private List<Integer> row5 = new ArrayList<Integer>();

	public Map<Integer, List<Integer>> getListOfRows() {
		return listOfRows;
	}

	public GameOfLife() {

		fillDefaultBoard();
		fillCounters();
	}
	
	private void fillDefaultBoard() {

		row1.add(0);
		row1.add(0);
		row1.add(0);
		row1.add(0);
		row1.add(0);

		row2.add(0);
		row2.add(1);
		row2.add(1);
		row2.add(1);
		row2.add(0);

		row3.add(0);
		row3.add(1);
		row3.add(1);
		row3.add(1);
		row3.add(0);

		row4.add(0);
		row4.add(0);
		row4.add(1);
		row4.add(0);
		row4.add(0);

		row5.add(0);
		row5.add(0);
		row5.add(0);
		row5.add(0);
		row5.add(0);

		listOfRows.put(0, row1);
		listOfRows.put(1, row2);
		listOfRows.put(2, row3);
		listOfRows.put(3, row4);
		listOfRows.put(4, row5);
	}

	private void fillCounters() {

		for (int i = 0; i < listOfRows.size(); i++) {
			listOfCounterRows.add(new ArrayList<Integer>());
			for (int j = 0; j < listOfRows.get(i).size(); j++) {
				listOfCounterRows.get(i).add(0);
			}
		}
	}

	public GameOfLife(Map<Integer, List<Integer>> map) {
		listOfRows = map;
		fillCounters();
	}

	public String printResult() {

		String result = "";

		for (List<Integer> l : listOfRows.values()) {
			for (int i : l) {
				result = result + i;
			}
			result = result + "\n";
		}

		result = result.substring(0, result.length() - 1);

		return result;
	}

	public void printBoard() {
		System.out.println(printResult());
	}

	public void printCounterBoard() {

		for (List<Integer> l : listOfCounterRows) {
			for (int i : l) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public void step() {

		updateCounters();
		updateBoard();
	}
	
	private void updateCounters() {

		for (Entry<Integer, List<Integer>> l : listOfRows.entrySet()) {
			for (int i = 0; i < l.getValue().size(); i++) {
				int counter = countNeighbors(l.getKey(), i);
				listOfCounterRows.get(l.getKey()).set(i, counter);
			}
		}
	}

	private void updateBoard() {

		for (Entry<Integer, List<Integer>> l : listOfRows.entrySet()) {
			int columnCounter = 0;
			for (int i : l.getValue()) {

				listOfRows.get(l.getKey()).set(columnCounter,
						updateCell(listOfCounterRows.get(l.getKey()).get(columnCounter), i));

				columnCounter++;
			}
		}
	}
	
	private int updateCell(int counter, int cell) {
		int result = 0;

		if (cell == 1 && (counter == 2 || counter == 3)) {
			result = 1;
		}

		if (cell == 0 && counter == 3) {
			result = 1;
		}

		return result;
	}

	public int countNeighbors(int row, int column) {

		int counter = 0;

		int rowMin = checkRowMin(row);
		int rowMax = checkRowMax(row);
		int columnMin = checkColumnMin(column);
		int columnMax = checkColumnMax(row, column);

		if (listOfRows.get(row).get(column) == 1) {
			counter--;
		}

		for (int j = rowMin; j < rowMax; j++) {
			for (int i = columnMin; i < columnMax; i++) {
				if (listOfRows.get(j).get(i) == 1) {
					counter++;
				}
			}
		}

		return counter;
	}

	private int checkRowMin(int row) {

		int result = 0;

		if (row == 0) {
			result = row;
		} else {
			result = row - 1;
		}

		return result;
	}

	private int checkRowMax(int row) {

		int result = 0;

		if (row == listOfRows.size() - 1) {
			result = row + 1;
		} else {
			result = row + 2;
		}

		return result;
	}

	private int checkColumnMin(int column) {

		int result = 0;

		if (column == 0) {
			result = column;
		} else {
			result = column - 1;
		}

		return result;
	}

	private int checkColumnMax(int row, int column) {

		int result = 0;

		if (column == listOfRows.get(row).size() - 1) {
			result = column + 1;
		} else {
			result = column + 2;
		}

		return result;
	}
}
