/**
 * A library of commonly used mathematical operations.
 */
public class MyMath {

    // For each one of the three method names listed below, 
    // write the method signature, document the method,
    // and write its implementation.
    // The documentation should be done in JavaDoc.
    // Use the same documentation style we used in Fraction.java. 

    /** gcd */
    /**
     * Returns the greatest common divisor of two positive numbers.
     * Uses Euclid's algorithm.
     */
    public static int gcd(int x, int y) {
        int rem;
        while (y != 0) {
            rem = x % y;
            x = y;
            y = rem;
        }
        return x;
    }

    /**
     * commonDenominator
     */
    public static int commonDenominator(Fraction a, Fraction b) {
        int aDom = a.getDenominator();
        int bdom = b.getDenominator();
        if (aDom == bdom) {
            return aDom;
        } else if (aDom > bdom) {
            if (aDom % bdom == 0) {
                return aDom;
            }
        } else if (bdom % aDom == 0) {
            return bdom;
        }
            return aDom * bdom;
        }



    /**
     * max
     */
    static Fraction max(Fraction a, Fraction b) {
        //todo
        if (a.compareTo(b) == 1) {
            return a;
        } else
            return b;
    }
}
