public class NearlyPerfectNumber {

	//static int MAXIMUM = 1000;
	static int MAXIMUM = 100;
	static int MINIMUM = 1;
	static String theSumOfAperfectNumber = "";

	private static boolean isThisNumberAPrimeNumber(int n)      {
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

	private static boolean isItANearlyPerfectNumberNumber(int n)      {
		int index = 2;
		int sum = 0;
		theSumOfAperfectNumber = "";
		//	2, 4 &&  all others
		while ( ( index < n ) && ((int)Math.sqrt(index) < n ) && (sum < n) )	{
			if ( isThisNumberAPrimeNumber(index)  )	{
				sum += index;
				theSumOfAperfectNumber = theSumOfAperfectNumber + index + " ";
			}
			index ++;
		}
		theSumOfAperfectNumber = theSumOfAperfectNumber.trim().replaceAll(" ", " + ");
		return sum == n;
	}

	private static void verification(int theNumber, String shouldBeEqualToThis) {
		int shouldBeEqualToThisValue = 0;
		shouldBeEqualToThis = shouldBeEqualToThis.replaceAll("\\+", " ").replaceAll(" [ ]+", " ");
		String allNumbers[]   = shouldBeEqualToThis.split(" ");
		for ( int index = 0; index < allNumbers.length; index ++ )	{
			shouldBeEqualToThisValue += Integer.parseInt(allNumbers[index]);
		}
		if ( shouldBeEqualToThisValue != theNumber )	{
			System.out.println(shouldBeEqualToThisValue + " != " + theNumber );
		}
	}

	private static void findNearlyPerfectNumbersWithTheseProperties() {
		for ( int index = MINIMUM; index < MAXIMUM; index ++ )	{
			if ( isItANearlyPerfectNumberNumber(index) )	{
				verification(index, theSumOfAperfectNumber );
				System.out.println(index + "	is a nearly perfect number. ("
						+ theSumOfAperfectNumber + ")" );
			}
		}
	}

	public static void main( String[] args ) {
		findNearlyPerfectNumbersWithTheseProperties();
	}
}
