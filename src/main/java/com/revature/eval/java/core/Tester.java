package com.revature.eval.java.core;

import java.util.Arrays;

public class Tester {
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		for (int x = 0; x < 50; x++) {
			System.out.println(guessingGame(3,100));
			
		}
	}

	public static int guessingGame(int x, int y) {
		
		int range = y - x + 1;
		
		return ((int) (Math.random() * range)) + x;
	}
}
