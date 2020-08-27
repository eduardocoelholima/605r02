/**
 * Literals1.java
 *
 * Version:
 *      $Id$
 *
 * Revision:
 *      $Log$
 *
 */

/**
 * A few examples using literals
 *
 * #author Eduardo Lima
 */
public class Literals1 {

    static String greatMethod() {
        return "123";
    }

    static public void main ( String[] args ) {
        String a = "123";
        String b = "123" + "";
        String c = greatMethod();
        String d = new String( "123" );

        System.out.println ( "( a == b ) evaluates as " + ( a == b ) );
        System.out.println ( "( b == c ) evaluates as " + ( b == c ) );
        System.out.println ( "( c == d ) evaluates as " + ( c == d ) );
    }
}
