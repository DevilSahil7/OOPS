package com.stockmanagement.stock.utility;

import java.util.Scanner;

/**
 * Purpose: Utility for code reusability
 * 
 * @author Sahil Kudake
 *
 */
public class Utility {

	static Scanner sc = new Scanner(System.in);

	public static int integerInput() {
		return sc.nextInt();
	}

	public static double doubleInput() {
		return sc.nextDouble();
	}

	public static String stringInput() {
		return sc.next();
	}

	public static Long longInput() {
		return sc.nextLong();
	}

	public static boolean booleanInput() {
		return sc.nextBoolean();
	}
}
