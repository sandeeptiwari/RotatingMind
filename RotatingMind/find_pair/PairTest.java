package com.sandi.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.sandi.app.FindPair;

public class PairTest {
private FindPair pair;
	
	@BeforeEach
	public void setUp() {
	  pair = new FindPair();
	}
	
	@Test
	@Disabled("Find the pair")
	public void testFindPair() {
		int a1[] = {1, 3, 4, 5};
	    int a2[] = {7, 19, 23, 35};
	    
	   int actual[] = pair.findPair(a1, a2, 3);
	   int expected[] = {2, 1};
       assertArrayEquals(expected, actual);
	}

	
}


