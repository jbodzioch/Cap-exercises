package com.capgemini.coins;

import java.util.*;

/**
 * Created by ldrygala on 2015-02-06.
 * <p/>
 * Consider N coins aligned in a row. Each coin is showing either heads or
 * tails. The adjacency of these coins is the number of adjacent pairs of coins
 * with the same side facing up.
 * <p/>
 * It must return the maximum possible adjacency that can be obtained by
 * reversing exactly one coin (that is, one of the coins must be reversed).
 * Consecutive elements of array A represent consecutive coins in the row. Array
 * A contains only 0s and/or 1s: 0 represents a coin with heads facing up; 1
 * represents a coin with tails facing up. For example, given array A consisting
 * of six numbers, such that:
 * <p/>
 * A[0] = 1 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 0 A[5] = 0
 * <p/>
 * the function should return 4. The initial adjacency is 2, as there are two
 * pairs of adjacent coins with the same side facing up, namely (0, 1) and (4,
 * 5). After reversing the coin represented by A[2], the adjacency equals 4, as
 * there are four pairs of adjacent coins with the same side facing up, namely:
 * (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher
 * adjacency. The same adjacency can be obtained by reversing the coin
 * represented by A[3].
 */
public class Coins {
	
	public static int solution(List<Integer> coins) {
		
		final int PAIRS_GAINED_WHEN_SWAP_THREE = 2;

		List<Integer> tempCoins = new ArrayList<Integer>();
		tempCoins.addAll(coins);

		int result = 0;
		int tempCounter = countPairs(coins);
		//test

		if (searchForThree(coins)) {
			result = tempCounter + PAIRS_GAINED_WHEN_SWAP_THREE;
		} else {
			result = Math.max((searchForward(coins)), (searchBackward(tempCoins)));
		}

		return result;
	}

	private static boolean checkThree(int coin, int nextCoin, int secondNextCoin) {

		boolean result = false;

		if (coin == secondNextCoin && coin != nextCoin) {
			result = true;
		}

		return result;
	}

	private static boolean searchForThree(List<Integer> tempCoins3) {

		boolean result = false;

		for (int i = 0; i < tempCoins3.size() - 2; i++) {
			if (checkThree(tempCoins3.get(i), tempCoins3.get(i + 1), tempCoins3.get(i + 2))) {
				result = true;
			}
		}

		return result;
	}

	private static boolean checkTwo(int coin, int nextCoin) {

		boolean result = false;

		if (coin == nextCoin) {
			result = true;
		}

		return result;
	}

	private static int searchForward(List<Integer> tempCoins) {

		boolean coinFlipped = false;

		for (int i = 0; i < tempCoins.size() - 1; i++) {
			if (!coinFlipped && !(checkTwo(tempCoins.get(i), tempCoins.get(i + 1)))) {
				tempCoins.set(i, tempCoins.get(i + 1));
				coinFlipped = true;
			}
		}

		return countPairs(tempCoins);
	}

	private static int searchBackward(List<Integer> tempCoins2) {

		boolean coinFlipped = false;

		for (int i = tempCoins2.size() - 1; i > 0; i--) {
			if (!coinFlipped && !(checkTwo(tempCoins2.get(i - 1), tempCoins2.get(i)))) {
				tempCoins2.set(i, tempCoins2.get(i - 1));
				coinFlipped = true;
			}
		}

		return countPairs(tempCoins2);
	}

	private static int countPairs(List<Integer> coins) {

		int counter = 0;

		if (!coins.isEmpty() && coins.size() > 1) {
			for (int i = 0; i < coins.size() - 1; i++) {
				if (coins.get(i) == coins.get(i + 1)) {
					counter++;
				}
			}
		}

		return counter;
	}
}
