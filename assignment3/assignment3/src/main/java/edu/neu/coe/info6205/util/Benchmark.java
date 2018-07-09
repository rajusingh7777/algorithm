/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {

	private final Function<T, Void> f;
    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }
    
    public double run(T t, int n) {
    	double avgtime = 0.0;
    	for(int i=0;i<n;i++) {
    		long startTime =System.nanoTime(); 
        	f.apply(t);
        	long endTime =System.nanoTime(); 
        	avgtime =avgtime+ (endTime - startTime);
    	}
    	return avgtime/n; 
    }

    static Integer[] aux = new Integer[1000];
    public static void main(String[] args) {
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        int n = 200;
        Integer[] array = new Integer[n];
        
        //Array of Random number
//        for (int i = 0; i <n ; i++) {
//        	Random r = new Random();
//        	array[i] = r.nextInt(n); 
//        }
        
        //Partially Sorted array 100 inversions
//        for (int i = 0; i <n ; i++) {
//        	array[i] = i;
//        }
//        for(int i=100;i<200;i++) {
//        	int temp = array[i];
//        	array[i] = array[i+1];
//        	array[i+1] = temp;
//        	i=i+1;
//        }
        
        //Sorted Array
//        for (int i = 0; i <n ; i++) {
//        	array[i] = i;
//    	}
        
        //Reverse Sorted Array
        int count = 0;
        for (int i=n-1;i>=0;i--) {
        	array[count] = i; 
        	count++;
        }
        
       
       benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
       benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
            aux = Arrays.copyOf(xs,n);
            sorter.sort(aux, 0, x);
			return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " nano secs for n=" + n);
    }
}
