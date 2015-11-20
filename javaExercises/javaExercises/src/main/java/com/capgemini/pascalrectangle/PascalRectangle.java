package com.capgemini.pascalrectangle;

/**
 * Created by ldrygala on 2015-01-23. 0 1 1 1 1 2 1 2 1 3 1 3 3 1 4 1 4 6 4 1 5
 * 1 5 10 10 5 1 6 1 6 15 20 15 6 1 7 1 7 21 35 35 21 7 1 8 1 8 28 56 70 56 28 8
 * 1 9 1 9 36 84 126 126 84 36 9 1
 */
public class PascalRectangle {

	public long pascal(int c, int r) {

		long result = -1;

		if (checkValidParameters(c, r)) {
			int[][] rectangle = new int[r + 1][r + 1];

			rectangle = fillOnes(rectangle);
			rectangle = fillRectangle(rectangle);

			result = rectangle[r][c - 1];
		}

		return result;
	}

	private boolean checkValidParameters(int columns, int rows) {

		boolean result = false;

		if (columns > 0 && rows >= 0 && columns <= rows + 1) {
			result = true;
		}

		return result;
	}

	private int[][] fillOnes(int[][] rectangle) {

		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle.length; j++) {
				if (i == j) {
					rectangle[i][j] = 1;
				} else if (j == 0) {
					rectangle[i][j] = 1;
				} else {
					rectangle[i][j] = 0;
				}
			}
		}

		return rectangle;
	}

	private int[][] fillRectangle(int[][] rectangle) {

		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < i; j++) {
				rectangle[i][j + 1] = rectangle[i - 1][j] + rectangle[i - 1][j + 1];
			}
		}

		return rectangle;
	}
}
