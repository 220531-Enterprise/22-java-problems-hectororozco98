package com.revature.eval.java.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {

			// check if the params is less than 0, if so return -1

			if (kilometersPerHour < 0) {
				return -1;
			}

			// find out the formula to convert kph to mph

			long mph = Math.round(kilometersPerHour / 1.609);

			// return it!
			return mph;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			// TODO Write an implementation for this method declaration

			if (kilometersPerHour < 0) {
				return "Invalid Value";
			}

			return kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h";
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {

		// if parameter is less than 0, print invalid
		if (kiloBytes < 0) {
			return "Invalid Value";
		}

		// calculate the megabytes and remaining kilobytes from the parameter
		// 1 MB = 1024 KB
		int megaBytes = kiloBytes / 1024;

		int remainder = kiloBytes - (1024 * megaBytes);

		// print it in the message format above
		// return a string
		return kiloBytes + " KB = " + megaBytes + " MB and " + remainder + " KB";
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {

		// if ourOfDay is in the range of 0-23, continue
		if (hourOfDay < 0 || hourOfDay > 23) {
			return false;
		}

		if (hourOfDay < 8 && isBarking) {
			return true;
		} else if (hourOfDay > 22 && isBarking) {
			return true;
		}

		// all other cases return false
		return false;
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public static boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {

		// Decimalformat created to shave our doubles to 3 decimal points
		firstNum = firstNum * 1000;
		firstNum = Math.floor(Math.abs(firstNum));
		
		secondNum = secondNum * 1000;
		secondNum = Math.floor(Math.abs(secondNum));
		
		DecimalFormat cleanDub = new DecimalFormat("0.###");

		// Create strings with the cleandub format of our parameters
		String firstNumStr = cleanDub.format(firstNum);
		String secondNumStr = cleanDub.format(secondNum);

		// If statement to determine if our parameters equal in value
		if (firstNumStr.equals(secondNumStr)) {
			return true;
		}

		return false;
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {

			// If statement that determines if any of our parameters are teens. Only one
			// parameter
			// needs to be a teen for this to return true
			if (isTeen(x) || isTeen(y) || isTeen(z)) {
				return true;
			}
			return false;
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		// IsTeen method used to determine if the int passed through is in the range of
		// 13-19
		public static boolean isTeen(int number) {

			// If statement, if parameter is greater than 12 & less than 20, it returns true
			if (number > 12 && number < 20) {
				return true;
			}
			return false;
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public static String printYearsAndDays(long minutes) {

		// If parameter is less than 0, print Invalid Value
		if (minutes < 0) {
			return "Invalid Value";
		}

		// Calculate the amount of years and days from the minutes passed into our
		// method.
		// There are 525600 minutes in a year
		long y = minutes / 525600;
		
		long remainder = minutes - (y * 525600);

		// There are 1440 minutes in a day
		long d = remainder / 1440;

		// return the conversion message
		return minutes + " min = " + y + " y and " + d + " d";
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {

		// Switch statement to determine what we are going to return
		// the parameter would fall in one of these cases, if not, it will run the
		// default code
		switch (number) {

		case (0):
			return "ZERO";
		case (1):
			return "ONE";
		case (2):
			return "TWO";
		case (3):
			return "THREE";
		case (4):
			return "FOUR";
		case (5):
			return "FIVE";
		case (6):
			return "SIX";
		case (7):
			return "SEVEN";
		case (8):
			return "EIGHT";
		case (9):
			return "NINE";
		default:
			return "OTHER";
		}
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {

		// If either parameter is < 10, we will return -1
		if (first < 10 || second < 10) {
			return -1;
		}
		// otherwise, return the GCD of both params.

		// creating gcd variable, the smallest divisor will always be 1 so we set it to
		// that.
		int gcd = 1;

		// for loop, starts at 1, then loops as many times as the first or second
		// variable, whichever is smaller
		// we use && because or would go past the smallest number, which will make the
		// for loop just compare the biggest number to itself.
		for (int x = 1; x <= first && x <= second; x++) {
			if (first % x == 0 && second % x == 0) {
				gcd = x;
			}
		}

		return gcd;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {

		// if the parameter is negative, then just return -1
		if (num < 0) {
			return -1;
		}

		// Using the modular operator "%" we can find the last digit
		// Essentially adds a decimal before the last digit in a number, and returns the
		// decimal (AKA the last number).
		int lastDigit = num % 10;

		// We are reducing a digit from the number through each loop
		// As long as num has more than one digit, the loop will run
		while (num > 9) {
			num = num / 10;
		}

		// We are left with a reduced num that has just a single digit. This will be our
		// first digit
		int firstDigit = num;

		// return the sum
		return firstDigit + lastDigit;
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {

		// instantiate a string called reversedStr as ""
		String reversedStr = "";

		// Use a for loop starting at the length of the string minus 1, since we would
		// go out of bounds.
		// as long as x is greater than or equal to 0, we keep looping, subtracting 1
		// from x every time.
		for (int x = (string.length() - 1); x >= 0; x--) {
			// Our original reversedStr will be changed every loop. Adding on
			// To what we previous had plus the current letter in the loop.
			// Essentially we are building the given string backwards one letter at at time.
			reversedStr = reversedStr + string.charAt(x);
		}

		return reversedStr;

	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public static String acronym(String phrase) {

		// Making a black string for our acronym.
		String acronym = "";
		
		phrase = phrase.replace("-", " ");
		
		phrase = phrase.toUpperCase();
			
		String[] strArr = phrase.split(" ");
		
		for (String s : strArr) {
			
			acronym = acronym + s.charAt(0);
			
		}
		return acronym;
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {

			// All sides of the triangle must be equal

			// determine if the first side is equal to the second
			if (getSideOne() != getSideTwo()) {
				return false;
			}

			// now we determine if the first is also equal to the third
			if (getSideOne() != getSideThree()) {
				return false;
			}

			return true;
		}

		public boolean isIsosceles() {

			if (getSideOne() == getSideTwo() || getSideOne() == getSideThree()) {
				return true;
			}

			return false;
		}

		public boolean isScalene() {

			// nested if statements to determine that neither side is equal to each other
			if (getSideOne() != getSideTwo()) {
				if (getSideTwo() != getSideThree()) {
					if (getSideOne() != getSideThree()) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {

		// I created a string called points that has the order of every letter according
		// to their point value
		String points = "AEIOULNRSTDGBCMPFHVWYKJXQZ";

		// Created a new string that uppercases every letter from the param
		String stringCap = string.toUpperCase();

		// initial value of our score set to 0
		int score = 0;

		// Using a for loop to loop through the entire capitalized word.
		for (int x = 0; x < stringCap.length(); x++) {
			// if the current letter's index from our points string is less than or equal to
			// 9, award 1 point
			// I do this for the rest of the letter groups, just adjusting the condition and
			// points awarded
			if (points.indexOf(stringCap.charAt(x)) <= 9) {
				score++;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) <= 11) {
				score += 2;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) <= 15) {
				score += 3;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) <= 20) {
				score += 4;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) == 21) {
				score += 5;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) <= 23) {
				score += 8;
				continue;
			}

			if (points.indexOf(stringCap.charAt(x)) <= 25) {
				score += 10;
				continue;
			}
		}

		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public static String cleanPhoneNumber(String string) {

		// These are used to remove any unnecessary values from strings that
		// are inputted to the method
		string = string.replace("-", "");
		string = string.replace("+", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		string = string.replace(".", "");
		string = string.replaceAll(" ", "");

		// If statement to determine if the phone number has the extra country code
		if (string.length() == 11) {
			string = string.replaceFirst("1", "");
		}
		
		if (string.length() == 10) {
			
			for (int x = 0; x < string.length(); x++) {
				
				if (string.charAt(x) > 47 && string.charAt(x) < 58) {
				} else {
					throw new IllegalArgumentException();
				}
			}		
		} else {
			throw new IllegalArgumentException();
		}
		return string;
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public static Map<String, Integer> wordCount(String string) {

		// Create a linkedHashMap, since they preserve order unlike a regular HashMap
		Map<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		String[] strArr = null;

		// Create a string array which splits the original string depending where spaces
		// are inserted.

		if (string.contains("\n")) {

			string = string.replace("\n", "");
		}

		if (string.contains(",")) {

			strArr = string.split(",");
		} else if (string.contains(" ")) {

			strArr = string.split(" ");
		}

		if (strArr == null) {
			lhm.put(string, 1);
		} else {
			// a for loop to handle each individual string in the array
			for (String s : strArr) {
				// if our linkedhashmap already contains the string as a key, update is value by
				// one
				if (lhm.containsKey(s)) {
					lhm.put(s, lhm.get(s) + 1);
				} else {
					// else add the new string into the linkedhashmap with a value of 1
					lhm.put(s, 1);
				}
			}
		}
		return lhm;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public static boolean isArmstrongNumber(int input) {

		String strInput = Integer.toString(input);
		int value = 0;
		int currentNum;

		for (int x = 0; x < strInput.length(); x++) {

			// System.out.println(strInput.charAt(x));

			currentNum = Character.getNumericValue(strInput.charAt(x));

			value += Math.pow(currentNum, strInput.length());

		}

		if (input == value) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public static List<Long> calculatePrimeFactorsOf(long l) {

		List<Long> primeFactors = new ArrayList<Long>();
		long curNum = l;

		for (long x = 2; x <= curNum; x++) {

			if (curNum % x == 0) {

				primeFactors.add(x);
				curNum = curNum / x;
				x = 1;
			}
		}

		return primeFactors;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public static int calculateNthPrime(int k) {

		List<Integer> primeList = new ArrayList<>();
		SortedSet<Integer> mySet = new TreeSet<>();

		if (k == 0) {
			throw new IllegalArgumentException();
		}

		long curNum = 2;

		while (mySet.size() < k) {

			for (int x = 2; x <= curNum; x++) {

				if (curNum % x == 0 && mySet.size() < k) {

					if (curNum != 2 && curNum % 2 == 0) { // if number isnt 2 or an even number
						curNum++;
						x = 2;
						continue;
					}

					mySet.add(x);
					// primeList.set(curIndex, x);
					// curIndex++;
					curNum++;
					x = 2;
				}
			}
		}

		for (int l : mySet) {

			primeList.add(l);
		}

		return primeList.get(k - 1);
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public static boolean isPangram(String string) {

		// first, delete white space from string
		string = string.replace(" ", "");

		// System.out.println(string);

		// second convert entire string to either upper or lower case
		string = string.toUpperCase();
		Set<Character> mySet = new HashSet<>();
		Set<Character> testSet = new HashSet<>();

		// third, check to see if the string has at least 26 characters.
		if (string.length() >= 26) {

			for (int x = 0; x < string.length(); x++) {

				if (string.charAt(x) > 64 && string.charAt(x) < 91) {

					// if character is between A-Z, add to set
					mySet.add(string.charAt(x));
				}
			}
		}
		if (mySet.size() == 26) {
			return true;
		}
		return false;
	}

	/**
	 * 20. Sum of Multiples
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public static int getSumOfMultiples(int i, int[] set) {

		Set<Integer> multipleSet = new HashSet<Integer>();

		for (int x : set) {

			for (int a = 1; a < i; a++) {

				if (a % x == 0) {

					multipleSet.add(a);
				}
			}
		}

		int sum = 0;
		for (int x : multipleSet) {

			sum += x;
		}

		return sum;
	}

	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas. Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random
	 * class.
	 */
	public static int[] threeLuckyNumbers() {

		int[] luckyNums = new int[3];

		for (int x = 0; x < 3; x++) {

			int randomNum = (int) (Math.random() * 100);
			luckyNums[x] = randomNum;

		}

		return luckyNums;
	}

	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range: int x =
	 * minimum iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and
	 * y.
	 */

	public static int guessingGame(int x, int y) {

		int range = y - x + 1;

		return ((int) (Math.random() * range)) + x;
	}
}
