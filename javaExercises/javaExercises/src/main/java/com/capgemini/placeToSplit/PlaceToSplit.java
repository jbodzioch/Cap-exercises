package com.capgemini.placeToSplit;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers
 * on the other side. Example: {{{ canBalance({1, 1, 1, 2, 1}) → true
 * canBalance({2, 1, 1, 2, 1}) → false canBalance({10, 10}) → true }}}
 */
public final class PlaceToSplit {

	public static boolean canBalance(int[] nums) {

		int[] sumForward = addForward(nums);
		int[] sumBackward = addBackward(nums);
		boolean result = false;	

		for (int i = 0; i < nums.length - 1; i++) {
			if (sumForward[i] == sumBackward[i + 1]) {
				result = true;
			}
		}

		return result;
	}

	private static int[] addForward(int[] nums) {

		int[] sumForward = new int[nums.length];

		sumForward[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumForward[i] = sumForward[i - 1] + nums[i];
		}

		return sumForward;
	}

	private static int[] addBackward(int[] nums) {

		int[] sumBackward = new int[nums.length];

		sumBackward[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i > -1; i--) {
			sumBackward[i] = sumBackward[i + 1] + nums[i];
		}

		return sumBackward;
	}

	private PlaceToSplit() {
	}
}
