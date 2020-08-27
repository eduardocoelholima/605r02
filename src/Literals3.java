/**
 * Literals3.java
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
public class Literals3 {

    static String aMethod() {
        return "123";
    }

    static String anotherMethod() {
        return new String("123" );
    }

    static String oneMoreMethod() {
        return aMethod();
    }

    static public void main ( String[] args ) {

        String a = "123";
        String b = "12" + "3";
        String c = aMethod();
        String d = anotherMethod();
        String e = oneMoreMethod();

        System.out.println ( "( a == b ) evaluates as " + ( a == b ) );
        System.out.println ( "( a == c ) evaluates as " + ( a == c ) );
        System.out.println ( "( a == d ) evaluates as " + ( a == d ) );
        System.out.println ( "( a == e ) evaluates as " + ( a == e ) );

        System.out.println ( "a.equals( b ) evaluates as " + a.equals( b ) );
        System.out.println ( "a.equals( c ) evaluates as " + a.equals( c ) );
        System.out.println ( "a.equals( d ) evaluates as " + a.equals( d ) );
        System.out.println ( "a.equals( e ) evaluates as " + a.equals( e ) );
    }
}
