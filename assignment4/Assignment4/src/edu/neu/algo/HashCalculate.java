package edu.neu.algo;

import java.util.Arrays;
import java.util.Random;

public class HashCalculate {
	static int m; // number of bins/slots
	static int[] array; // array of Hashes
	static int result[]; // to store count of C1 and B0
	static double iteration = 50.0; // Number of times program runs to get accurate value

	public static void main(String[] args) {
		m = 250;
		double coupon = 0.0;
		double birthday = 0.0;
		for (int i = 0; i < iteration; i++) {
			array = new int[m];
			Arrays.fill(array, -1);
			result = new int[2];
			hash();
			coupon = coupon + result[0];
			birthday = birthday + result[1];
		}
		
		
		System.out.println("Coupon Collector prog :" + coupon / iteration);
		System.out.println("Coupon Collector theory :" + Math.sqrt(Math.PI * m / 2));
		System.out.print("\n");
		System.out.println("Birthday prog :" + birthday / iteration);
		System.out.println("Birthday theory :" + m * Math.log(m));
		
	}

	// Hash function
	static void hash() {
		boolean checkForFirstIteration = true;
		boolean checkAllElements = false;
		while (true) {
			if (checkForFirstIteration) {
				initializeArray(true);
				checkForFirstIteration = false;
				continue;
			} else {
				checkAllElements = false;
				for (int i = 0; i < m; i++) {
					if (array[i] == -1) {
						initializeArray2();
						checkAllElements = true;
					}
				}
			}
			if (checkAllElements) {
				continue;
			} else {
				break;
			}
		}
	}

	// First array initialization to get C1(m)
	static void initializeArray(boolean firstTime) {
		int count = 0;
		for (int i = 0; i < m; i++) {
			Random r = new Random();
			int val = r.nextInt(m);
			int mod = val % m;
			if (array[mod] == -1) {
				array[mod] = val;
				result[1]++;
				count++;
			} else if (firstTime) {
				result[0] = count;
				break;
			}
		}
	}

	// Continue the initialization if the value is not filled in array
	static void initializeArray2() {
		for (int i = 0; i < m; i++) {
			Random r = new Random();
			int val = r.nextInt(m);
			// Hash implementation
			int mod = val % m;
			array[mod] = val;
			result[1]++;
		}
	}

	// For unit test case using same hash function
	static void hashTestCase(int givArr[]) {
		for (int i = 0; i < m; i++) {
			int mod = givArr[i] % m;
			array[mod] = givArr[i];
		}
	}
}
