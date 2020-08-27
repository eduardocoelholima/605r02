/**
 * Number2.java
 *
 *  * Version:
 *  *   $Id$
 *  *
 *  * Revisions:
 *  *   $Log$
 *  */

/**
 * Varied methods for working with numbers
 *
 * Learning objectives
 * - show the use of StringBuilder to reverse a string
 * - show the use of String .equals()
 *
 *
 */
public class Number2 {

    /**
     * Reverses a string
     *
     * @param string
     * @return
     */
    static String reverseString ( String string ) {
        return new StringBuilder()
                        .append( string )
                        .reverse()
                        .toString();
    }

    /**
     * Checks whether a number is a palindrome
     * (its digits are symmetrical)
     *
     * @param number
     * @return
     */
    static boolean isPalindrome( int number ) {

        String[] digits = Integer.toString( number ).split( "" );

        for ( int i = 0; i < digits.length/2; i++ ) {

            // why would == not work below?
            if ( ! digits[ i ].equals( digits[ digits.length-1 - i ] ) ) {
                return false;
            }
        }

        return true;

    }


    /**
     * Main call used for testing
     *
     * @param args
     */
    static public void main( String[] args ) {
        System.out.println( reverseString( "abcd" ) );
        System.out.println( isPalindrome( 1221 ) );
        System.out.println( isPalindrome( 1222 ) );

    }
}
