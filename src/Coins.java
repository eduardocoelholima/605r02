/**
 * Coins.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

/*
 * Coinis = { c_1, c_2, ... c_n }
 * k = | Coins | = (2 ^ n)  - 1
 */

import java.util.Arrays;

/**
 * Coins drawing program based on binary-represented combinations
 *
 * @author Hans-Peter Bischof
 */
public class Coins {

	static int[] myCoins = { 0, 1, 1, 2, 5, 25, 25, 25 }; // coins in the wallet
	static int soManyCoins = myCoins.length; // how many coins are in the wallet
	static int[] toPay = { 1, 4, 5, 7, 8}; // each entry is a test case

	//number of possible combinations
	static int setSize = (int)Math.pow(2, myCoins.length );

	// bubble sort fo myCoins array
	private static void sortCoins() {
		for (int index = 0; index < myCoins.length - 1; index++)     {
			for (int walker = 0; walker < myCoins.length - 1; walker++)  {
				if ( myCoins[walker] > myCoins[walker+1] )        {
					int tmp = myCoins[walker];
					myCoins[walker] = myCoins[walker + 1];
					myCoins[walker+1] = tmp;
				}
			}
		}
	}

	// print the coin present in the solution (or candidate) represented by
	// the integer value. Each bit in this integer represents the usage of a
	// a coin (each coin is considered an element of a set)
	private static String printUsedCoins(int value) {
		String returnValue = "";

		// a loop from the last coin to the first one
		for ( int index = soManyCoins; index >= 0 ; index --)	{

			// if n-th coin is used, then the n-th bit in the combination
			// (int) value will be set. Here (1 << index) can be seen as a
			// binary mask to select the bit associated with the coin being
			// examined. If the bit is set, condition will be met.
			if ( ( ( 1 << index ) & value ) == ( 1 << index ) )
				returnValue += myCoins[index] + " cents ";

		}
		if ( returnValue == "" )
			returnValue = "empty set";
		return returnValue;
	}

	// how many bits are set in the combination represented by
	// (int) value. The number of bits set means how many coins are used
	// in this combination.
	private static int soManyBitsAre1(int value) {
		int returnValue = 0;
		for ( int index = soManyCoins; index >= 0 ; index --)	{
			if ( ( ( 1 << index ) & value ) == ( 1 << index ) )
				returnValue ++;

		}
		return returnValue;
	}

	// sum up the print-value of each coin that is part of a combination
	// (int) value
	private static int calculteSumForThisSet(int value) {
		int sum = 0;
		for ( int index = soManyCoins - 1; index >= 0 ; index --)    {
			if ( ( ( 1 << index ) & value ) == ( 1 << index ) )	{
				sum += myCoins[index];
			}

		}
		return sum;
	}


	private static void  testIfaCombinationForThisSumExist(int thisSum)	{
		boolean foundAset  	= false;
		int largestSetSoFar	= 0;

		int index = 0; // index represents the combination being tested

		if ( thisSum == 0 )	{
			System.out.println("0 cents:\t\tcan not be paid");
		} else {
			// from index=0 to setSize
			while  ( index < setSize ) {

				// calculates the sum of current coin combination
				int sum = calculteSumForThisSet(index);

				// if the sum matches the desired sum (specified by an element
				// in toPay (check main method)...
				if ( ( thisSum == sum ) )	{

					// check if the current solution is better than the
					// previously best one
					if ( soManyBitsAre1(largestSetSoFar) < soManyBitsAre1(index) )
						largestSetSoFar = index;
				}
				index ++; // go to next combination
			}

			// prints the solution (if there is one)
			if ( soManyBitsAre1(largestSetSoFar) > 0 )
				System.out.println(thisSum + " cents:	"       +
						"\tyes; used coins = " 	+ printUsedCoins(largestSetSoFar) );
			else
				System.out.println(thisSum + " cents:	"       +
						"\tno; can not be paid with the following sequence of coins: " + Arrays.toString(myCoins));
		}
	}

	public static void main( String[] arguments ) {
		// sortCoins();
		for ( int index = 0; index < toPay.length; index ++ )
			testIfaCombinationForThisSumExist(toPay[index]);
	}
}
