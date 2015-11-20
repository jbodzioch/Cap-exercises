package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52. There exists
 * exactly one Pythagorean triplet for which a + b + c = 1000. Find the product
 * abc.
 */
public class Pythagorean {

	private int a;
	private int b;
	private int c;

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public void calculate() {

		// From mathematical dependence variable "c" cannot exceed 500
		int upperBorder = 500;
		boolean exists = false;

		while (!exists) {
			for (int c = 0; c < upperBorder; c++) {
				for (int b = 0; b < c; b++) {
					for (int a = 0; a < b; a++) {
						if (checkPowers(a, b, c)) {
							if (checkThousand(a, b, c)) {
								setA(a);
								setB(b);
								setC(c);

								exists = true;
							}
						}

					}
				}
			}
		}
	}

	private boolean checkPowers(int a, int b, int c) {

		boolean result = false;

		if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
			result = true;
		}

		return result;
	}

	private boolean checkThousand(int a, int b, int c) {

		boolean result = false;

		if (c + b + a == 1000) {
			result = true;
		}

		return result;
	}

	public void printResult() {
		System.out.println(getA() + " " + getB() + " " + getC());
	}
}
