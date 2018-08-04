package edu.neu.coe.info6205.sort.par;

import static org.junit.Assert.*;

import org.junit.Test;


public class ParSortTestCase {

	@Test
    public void sort1() throws Exception {

        int[] xs = {13,6,12,7,14};
        ParSort.sort(xs, 0, xs.length);
        assertEquals(xs[0], 6);
        assertEquals(xs[1], 7);
        assertEquals(xs[2], 12);
        assertEquals(xs[3], 13);
        assertEquals(xs[4], 14);
    }

	@Test
    public void sort2() throws Exception {

        int[] xs = {3,8,9,1,4,10};
        ParSort.sort(xs, 0, xs.length);
        assertEquals(xs[0], 1);
        assertEquals(xs[1], 3);
        assertEquals(xs[2], 4);
        assertEquals(xs[3], 8);
        assertEquals(xs[4], 9);
        assertEquals(xs[5], 10);
    }

	@Test
    public void sort3() throws Exception {

        int[] xs = {11,2,14,13,6,5,17};
        ParSort.sort(xs, 0, xs.length);
        assertEquals(xs[0], 2);
        assertEquals(xs[1], 5);
        assertEquals(xs[2], 6);
        assertEquals(xs[3], 11);
        assertEquals(xs[4], 13);
        assertEquals(xs[5], 14);
        assertEquals(xs[6], 17);
    }
	
}
