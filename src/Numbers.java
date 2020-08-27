/**
 * Numbers.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

// andersons numbers
import java.lang.Math;

/**
 * Checks for Number Properties
 *
 * @author Hans-Peter Bischof
 *
 */
public class Numbers {

	final static int MINIMUM = 1;	// 0 is excluded
//	final static int MAXIMUM = 100000000;
	final static int MAXIMUM = 10000;
	static int[]  theDigits;


	private static void printDigits()	{
		for ( int index = 0; index < theDigits.length; index ++ )
			System.out.println(index + ":= " + theDigits[index]);
	}

	// extracts the digits of an integer by repeated division by 10. The
	// actual digit value is extracted with a mod. Digits are stores as an
	// array of integers.
	private static void extractDigits(int thisNumber) {
		theDigits = new int[ ( "" + thisNumber ).length() ];
		int index = 0;
		if ( theDigits.length > 1 )	{
			do {
				theDigits[index++ ] = thisNumber % 10; // the actual digit value
				thisNumber = thisNumber / 10;
			} while  ( thisNumber % 10 != thisNumber 	);
		}
		theDigits[index++] = thisNumber;
	}

	// check if the number has only 0s and 1s as digits. This makes the
	// number not meet the property but also breaks the property checking
	// method, so this method is used to identify this and avoid calling the
	// method in this case.
	private static boolean includesOnlyZerosAndOnes()	{
		boolean rValue = true;
		for ( int index = 0; rValue && ( index < theDigits.length); index ++ )       {
			rValue &= ( theDigits[index] <= 1 );
		}
		return rValue;
	}

	private static void printResult(int thisNumber, int sumOfPower, int power) {
		String format = "%" + ( theDigits.length + 2 ) + "d\t%s\t%" + ( theDigits.length + 2 ) + "d\t%s\n";
		System.out.printf(format, thisNumber, " == ", sumOfPower, " has the desired property");
		System.out.print("	");
		for ( int index = 0; index < theDigits.length; index ++ )	{
			System.out.print(theDigits[theDigits.length - index - 1] + " ^ " + power);
			if ( index < theDigits.length - 1 )
				System.out.print(" + " );
		}
		System.out.println();
	}

	// the 'do while' loop will never terminate, if the number includes only 0's and 1's
	private static void testNotZeroAndOnes(int thisNumber) {
		int power = 0;
		int sumOfPower = 0;
		do {

			// calculates the sum and does not go on if the sum is over the
			// number itself. The power k is increased in every iteration of
			// the do-while loop.
			sumOfPower = 0;
			for ( int index = 0; index < theDigits.length; index ++ )	{

				sumOfPower += Math.pow( (double)theDigits[index], (double)power );
			}
			power ++;
		} while  ( sumOfPower <  thisNumber );

		if ( sumOfPower == thisNumber )
			printResult(thisNumber, sumOfPower, power - 1);
	}

	private static void hasProperty(int thisNumber) {

		// extract the digits as an array of integers
		extractDigits(thisNumber);

		// if the digits of a number only has 0s and 1s, there is no
		// k that will satisfy the property but the method will fail because
		// it checks if the sum is greater than the number to stop, and in
		// this case it will never be.
		if (!  includesOnlyZerosAndOnes() )
			testNotZeroAndOnes(thisNumber);
	}

	// tests numbers within MINIMUM and MAXIMUM for having the desired
	// properties: there exist a number k such that the sum of the numbers'
	// digits to the power of k is equal to the number
	private static void findNumbersWithTheseProperties() {
		for ( int index = MINIMUM; index < MAXIMUM; index ++ )
			hasProperty(index);
	}

	public static void main( String[] args ) {
		new Numbers().findNumbersWithTheseProperties();
	}
}


