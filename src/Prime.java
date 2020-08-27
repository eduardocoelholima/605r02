/**
 * Prime.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

/**
 * Prime implementation using Aristothene's sieve and additional number
 * properties.
 *
 * @author Hans-Peter Bischof
 */
public class Prime {

	// final static int MAXIMUM = 73939133 + 1;
	final static int MAXIMUM = 400;
	final static int MINIMUM = 1;
	final static boolean  thisNumberIsAprimeNumber[] = new boolean[ MAXIMUM];

	// not needed when using the initialized sieve
	private static boolean isItAPrimeNumber(int n)      {	// is not used
		boolean rValue = true;
		int index = 1;
		if ( n <= 1 )
			return false;
		if ( n == 2 )
			rValue = true;
		while ( ( ++index <= ( (int)Math.sqrt(n) ) ) &&  rValue ) {
			if ( n % index == 0 )	{
				rValue = false;
			}
		}
		return rValue;
	}

	private static void initPrimeOrNotSieve()	{
		// all numbers are initialized as a prime (false means prime)
		for ( int index = 0; index < thisNumberIsAprimeNumber.length; index ++ )
			thisNumberIsAprimeNumber[index] = false;

		// all numbers that has at least 2 factors are iterated in this 2 for
		// loops. The first outer loop has an upper bound of square root of
		// largest number in the sieve, and the inner loop has the product of
		// the factors as an upper bound.

		// these will go over ALL composite numbers within the sieve size, so
		// after this loop the sieve will be ready to be used
		for ( int factor1 = 2; factor1 <=  ( (int)Math.sqrt(thisNumberIsAprimeNumber.length) ); factor1++ )	{
			for ( int factor2 = 2; factor2 * factor1 <   thisNumberIsAprimeNumber.length; factor2 ++ )	{
				thisNumberIsAprimeNumber[factor1 * factor2 ] = true;
			}
		}
	}

	private static boolean hasProperty(int thisNumber) {

		// removes right-most digit while:
		// - there is still a digit remaining (condition granted by
		// (thisNumber > 1), because after the last right-most digit is
		// removed, (thisNumber/10)==0;
		// - the current number is also prime
		while ( ( thisNumber > 1 ) && ! thisNumberIsAprimeNumber[thisNumber] )  {

			// equivalent to remove right-most digit, if there is one
			thisNumber = thisNumber / 10;
		}

		//will only be true if ALL numbers processed before were prime
		return ( thisNumber == 0 );
	}

	// initializes the sieve and checks each number within MINIMUM and
	// MAXIMUM if they meet the properties required (the number should be
	// prime and after removing the right-most digit, the number is also
	// prime, repeatedly until the last remaining digit.
	private static void findPrimesWithTheseProperties() {
		initPrimeOrNotSieve(); // initializes the sieve
		// print();
		for ( int index = MINIMUM; index < MAXIMUM; index +=2 )	{

			// checks if the number is prime and if is has the property (all
			// resulting numbers after removing the right-most digit are also
			// prime, repeating until the last remaining digit).
			if ( ! thisNumberIsAprimeNumber[index] && hasProperty(index)	)
				System.out.println(index + " has the properties.");
		}
	}

	private static void print()	{
		for ( int index = 0; index < thisNumberIsAprimeNumber.length; index ++ )	{
			System.out.println(index + ":	" + thisNumberIsAprimeNumber[index] );
		}
	}

	public static void main( String[] args ) {
		new Prime().findPrimesWithTheseProperties();
	}
}


