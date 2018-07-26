package edu.neu.algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashCalculateUnitTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void hashfunc1() {
		int[] xs = {15,12,44,33,41};
		HashCalculate.array = new int[5];
		HashCalculate.m = 5;
		HashCalculate.hashTestCase(xs);
        assertEquals(HashCalculate.array[0], 15);
        assertEquals(HashCalculate.array[1], 41);
        assertEquals(HashCalculate.array[2], 12);
        assertEquals(HashCalculate.array[3], 33);
        assertEquals(HashCalculate.array[4], 44);
	}
	
	@Test
	public void hashfunc2() {
		int[] xs = {53,22,33,36,64};
		HashCalculate.array = new int[5];
		HashCalculate.m = 5;
		HashCalculate.hashTestCase(xs);
        assertEquals(HashCalculate.array[0], 0);
        assertEquals(HashCalculate.array[1], 36);
        assertEquals(HashCalculate.array[2], 22);
        assertEquals(HashCalculate.array[3], 33);
        assertEquals(HashCalculate.array[4], 64);
	}


}
