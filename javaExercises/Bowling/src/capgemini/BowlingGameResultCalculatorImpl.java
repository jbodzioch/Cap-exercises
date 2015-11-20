package capgemini;

import java.util.*;

public class BowlingGameResultCalculatorImpl implements BowlingGameResultCalculator {
	
	private final int ROUNDS_IN_GAME = 10;
	private final int THROWS_IN_ROUND = 2;
	private final int STRIKE = 10;
	private final int SPARE = 10;

	private List<Integer> pins = new ArrayList<Integer>();
	private List<Integer> scores = new ArrayList<Integer>();
	private int tensCount = 0;
	private int roundCount = 0;

	public int getTensCount() {
		return tensCount;
	}

	public int getRoundCount() {
		return roundCount;
	}

	public void roll(int numberOfPins) {

		if (pins.isEmpty()) {
			pins.add(0);
		}

		if (!isFinished()) {
			if (numberOfPins == STRIKE) {
				tensCount++;
			}
			pins.add(numberOfPins);
		}
	}

	public int score() {

		int result = 0;
		int strikesCount = 0;

		for (int i = 1; i < pins.size(); i++) {

			if (checkStrike(i)) {
				strike(i);
				strikesCount++;
			}

			else if (checkSpare(i, strikesCount)) {
				spare(i);
			}

			else {
				scoreThis(i);
			}
		}

		for (int i = 0; i < scores.size(); i++) {
			result = result + scores.get(i);
		}

		return result;
	}

	private boolean checkStrike(int i) {

		boolean result = false;

		if (pins.get(i) == STRIKE) {
			result = true;
		}

		return result;
	}

	private void strike(int i) {

		if (i < pins.size() - 2) {
			scores.add(pins.get(i) + pins.get(i + 1) + pins.get(i + 2));
		} else if (i == pins.size() - 2) {
			scores.add(pins.get(i) + pins.get(i + 1));
		} else {
			scoreThis(i);
		}
	}

	private boolean checkSpare(int i, int strikesCount) {

		boolean result = false;

		if (pins.get(i) + pins.get(i - 1) == SPARE && (i - strikesCount) % THROWS_IN_ROUND == 0) {
			result = true;
		}

		return result;
	}

	private void spare(int i) {

		if (i < pins.size() - 1) {
			scores.add(pins.get(i) + pins.get(i + 1));
		} else {
			scoreThis(i);
		}
	}

	private void scoreThis(int i) {
		scores.add(pins.get(i));
	}

	public boolean isFinished() {
		
		boolean result = false;

		countRounds();
		if (getRoundCount() > ROUNDS_IN_GAME) {
			result = true;
		}

		return result;
	}

	private void countRounds() {
		roundCount = (pins.size() - getTensCount()) / THROWS_IN_ROUND + getTensCount();
	}


}
