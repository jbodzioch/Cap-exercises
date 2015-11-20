package com.capgemini.fibonacci;

import java.util.*;

/**
 * Created by ldrygala on 2015-01-23. F1 F2 F3 F4 F5 F6 F7 F8 F9 F10 F11 F12 F13
 * F14 F15 F16 F17 F18 F19 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
 * 2584 4181
 */
public class Fibonacci {

	public static long fib(int n) {

		List<Integer> sum = new ArrayList<Integer>();
		long result = -1;

		if (n >= 0) {
			sum.add(1);
			sum.add(1);

			for (int i = 2; i < n + 1; i++) {
				sum.add(sum.get(i - 1) + sum.get(i - 2));
			}

			result = sum.get(n);
		}

		return result;
	}
}
