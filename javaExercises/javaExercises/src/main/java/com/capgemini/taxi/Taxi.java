package com.capgemini.taxi;

import java.awt.Point;
import java.util.*;

public class Taxi {

	private final int SIZE = 10;
	private char[][] gameBoard = new char[SIZE][SIZE];
	private final int MULTIPLIER = 4;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Taxi() {

		setBoard();
		setCustomer();
		setTaxi();
		setAvailability();
		setResult(calculate());
	}

	public void setCustomer() {
		gameBoard[(SIZE / 2) - 1][(SIZE / 2) - 1] = 'C';
	}

	public void setBoard() {

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gameBoard[i][j] = '0';
			}
		}
	}

	public void setTaxi() {

		int numOfTaxi = (int) (Math.random() * 10 + 3);

		for (int i = 0; i < numOfTaxi; i++) {
			int x = (int) (Math.random() * SIZE);
			int y = (int) (Math.random() * SIZE);

			if (gameBoard[x][y] == '0') {
				gameBoard[x][y] = 'T';
			}
		}
	}

	public void setAvailability() {

		int rand = (int) (Math.random() * 10 + 1);

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameBoard[i][j] == 'T') {
					if (rand < 4) {
						gameBoard[i][j] = 'U';
					}
					rand = (int) (Math.random() * 10 + 1);
				}
			}
		}
	}

	public String calculate() {

		String result;

		Point client = new Point(0, 0);
		List<Point> taxies = new ArrayList<Point>();
		List<Double> distances = new ArrayList<Double>();

		client = getClientCoords();
		taxies = getTaxiesCoords();
		distances = getDistances(client, taxies);
		result = printDistances(taxies, distances);

		return result;
	}

	public Point getClientCoords() {

		Point client = new Point(0, 0);

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameBoard[i][j] == 'C') {
					client = new Point(i, j);
				}
			}
		}

		return client;
	}

	public List<Point> getTaxiesCoords() {

		List<Point> taxies = new ArrayList<Point>();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameBoard[i][j] == 'T') {
					taxies.add(new Point(i, j));
				}
			}
		}

		return taxies;
	}

	public List<Double> getDistances(Point client, List<Point> taxies) {

		List<Double> distances = new ArrayList<Double>();
		double distanceX;
		double distanceY;

		for (int i = 0; i < taxies.size(); i++) {
			distanceX = Math.abs(client.getX() - taxies.get(i).getX());
			distanceY = Math.abs(client.getY() - taxies.get(i).getY());
			distances.add(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) / MULTIPLIER);
		}

		return distances;
	}

	public String printDistances(List<Point> taxies, List<Double> distances) {

		String result = " ";

		for (int i = 0; i < distances.size(); i++) {
			if (distances.get(i) < 1) {
				result = result + "Available taxi at: " + taxies.get(i).getX() + " " + taxies.get(i).getY();
			}
		}

		return result;
	}
}
