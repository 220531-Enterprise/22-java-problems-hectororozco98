package com.revature.eval.java.core;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println(toMilesPerHour(10));

	}

	public static long toMilesPerHour(double kilometersPerHour) {
		
		// check if the params is less than 0, if so return -1
		
		if (kilometersPerHour <0) {
			return -1;
		}
		
		// find out the formula to convert kph to mph
		
		long mph = Math.round(kilometersPerHour / 1.609);
		
		// return it!
		return mph;
	}
}

