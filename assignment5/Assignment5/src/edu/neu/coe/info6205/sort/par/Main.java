package edu.neu.coe.info6205.sort.par;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		long avgTime = 0;
		int arraySize = 100000;
		for (int z = 0; z < 3; z++) {
			int[] array = new int[arraySize];
			
			Random random = new Random(0L);
			
			for (int i = 0; i < array.length; i++)
				array[i] = random.nextInt(100000);
			
			Random rand = new Random();
			
			for (int i = array.length - 1; i > 0; i--) {
				int j = rand.nextInt(i);
				int t = array[i];
				array[i] = array[j];
				array[j] = t;
			}
			long startTime = System.nanoTime();
			ParSort.threads = 0;
			ParSort.sort(array, 0, array.length);
			long endTime = System.nanoTime();
			long time = endTime - startTime;
			System.out.println(time +" nano sec");
			avgTime = avgTime + time;
		}
		System.out.println(
				ParSort.cutoff + " " + arraySize + " " + (avgTime / 100) * Math.pow(10, -6) + " " + ParSort.threads);
	}
}
