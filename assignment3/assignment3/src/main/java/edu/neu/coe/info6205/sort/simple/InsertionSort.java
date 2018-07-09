package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.*;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        for(int i=from;i<to;i++) {
        	for(int j=i;j>from;j--) {
        		if(less(xs[j],xs[j-1])) {
        			X temp = xs[j];
        			xs[j] = xs[j-1];
        			xs[j-1]= temp;
        		}
        	}
        }
    }
    private boolean less(Comparable x, Comparable y) {
    	return x.compareTo(y)<0;
    }
}
