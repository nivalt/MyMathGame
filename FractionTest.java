/**
 * Tests the Fraction and MyMath methods described in Homework 8.
 */
public class FractionTest {

    // Some representative Fraction objects, used in the various tests written in this class.
    static Fraction half = new Fraction(2, 4);
    static Fraction minusHalf = new Fraction(-1, 2);
    static Fraction quarter = new Fraction(1, 4);
    static Fraction minusQuarter = new Fraction(-1, 4);
    static Fraction third = new Fraction(1, 3);
    static Fraction twoThirds = new Fraction(2, 3);
    static Fraction zero = new Fraction(0, 1);
    static Fraction fivesix = new Fraction(5, 6);

    public static void main(String args[]) {
        ///testFraction();
//        testAbs();
//        testSignum();
       // testConvert();
      //  testSubtract();
      //  testCompareTo();
        //testEquals();
//        testPow();
       // testRandomFraction();
        testCommonDenominator();
        testScale();
      //  testMax();
    }

    private static void testFraction() {
        // Use this function for writing code that creates and manipulates Fraction objects.
        // You can use the static Fraction objects declared above, but make sure to practice  
        // creating some Fraction objects of your own.
    }

    private static void testAbs() {
        System.out.println("Testing the abs function:");
        System.out.println("abs(" + half + ") = " + half.abs());
        System.out.println("abs(" + minusHalf + ") = " + minusHalf.abs());
        System.out.println("abs(" + quarter + ") = " + quarter.abs());
        System.out.println("abs(" + minusQuarter + ") = " + minusQuarter.abs());
        System.out.println("abs(" + third + ") = " + third.abs());
        System.out.println("abs(" + twoThirds + ") = " + twoThirds.abs());
        System.out.println("abs(" + zero + ") = " + zero.abs());
        // Complete the testing code here.
    }

    private static void testSignum() {
        System.out.println("Testing the signum function:");
        System.out.println("signum(" + half + ") = " + half.signum());
        System.out.println("signum(" + minusHalf + ") = " + minusHalf.signum());
        System.out.println("signum(" + quarter + ") = " + quarter.signum());
        System.out.println("signum(" + minusQuarter + ") = " + minusQuarter.signum());
        System.out.println("signum(" + third + ") = " + third.signum());
        System.out.println("signum(" + twoThirds + ") = " + twoThirds.signum());
        System.out.println("signum(" + zero + ") = " + zero.signum());
    }

    private static void testConvert() {
        System.out.println("Testing the convert function:");
        System.out.println("convert(" + half + ") = " + half.convert());
        System.out.println("convert(" + minusHalf + ") = " + minusHalf.convert());
        System.out.println("convert(" + quarter + ") = " + quarter.convert());
        System.out.println("convert(" + zero + ") = " + zero.convert());
        System.out.println("convert(" + third + ") = " + third.convert());
    }

    private static void testSubtract() {
        System.out.println("Testing the subtract function:");
        System.out.println("add(" + quarter + "," + quarter + ") = " + quarter.add(quarter));
        System.out.println("subtract(" + half + "," + third + ") = " + half.subtract(third));
        System.out.println("subtract(" + half + "," + minusHalf + ") = " + half.subtract(minusHalf));
        System.out.println("subtract(" + half + "," + quarter + ") = " + half.subtract(quarter));
        System.out.println("subtract(" + half + "," + zero + ") = " + half.subtract(zero));
        System.out.println("subtract(" + twoThirds + "," + third + ") = " + twoThirds.subtract(third));
        System.out.println("subtract(" + zero + "," + third + ") = " + zero.subtract(third));
    }

    private static void testCompareTo() {
        System.out.println("Testing the compareTo function:");
        System.out.println("compareTo(" + half + "," + third + ") = " + half.compareTo(third));
        System.out.println("compareTo(" + half + "," + minusHalf + ") = " + half.compareTo(minusHalf));
        System.out.println("compareTo(" + half + "," + quarter + ") = " + half.compareTo(quarter));
        System.out.println("compareTo(" + half + "," + zero + ") = " + half.compareTo(zero));
        System.out.println("compareTo(" + twoThirds + "," + third + ") = " + twoThirds.compareTo(third));
        System.out.println("compareTo(" + zero + "," + third + ") = " + zero.compareTo(third));
    }


    private static void testEquals() {
        System.out.println("Testing the equals function:");
        System.out.println("equals(" + half + "," + third + ") = " + half.equals(third));
        System.out.println("equals(" + half + "," + minusHalf + ") = " + half.equals(minusHalf));
        System.out.println("equals(" + half + "," + half + ") = " + half.equals(half));
        System.out.println("equals(" + half + "," + zero + ") = " + half.equals(zero));
        System.out.println("equals(" + twoThirds + "," + twoThirds + ") = " + twoThirds.equals(twoThirds));
        System.out.println("equals()(" + zero + "," + zero + ") = " + zero.equals(zero));
    }

    private static void testPow() {
        System.out.println("Testing the pow function:");
        System.out.println("pow(" + half + ",2) = " + half.pow(2));
        System.out.println("pow(" + minusHalf + ",3) = " + minusHalf.pow(3));
        System.out.println("pow(" + quarter + ",4) = " + quarter.pow(4));
        System.out.println("pow(" + minusQuarter + ",0) = " + minusQuarter.pow(0));
    }

    private static void testRandomFraction() {
        System.out.println("Testing the limit = 8 function:");
        System.out.println(new Fraction(8));
        System.out.println(new Fraction(8));
        System.out.println(new Fraction(8));
        System.out.println(new Fraction(8));
        System.out.println(new Fraction(8));
    }

    private static void testCommonDenominator() {
        System.out.println("Testing the commonDenominator function:");
        System.out.println("equals(" + half + "," + quarter + ") = " + MyMath.commonDenominator(half, quarter));
        System.out.println("commonDenominator(" + half + "," + third + ") = " + MyMath.commonDenominator(half, third));
        System.out.println("commonDenominator(" + half + "," + zero + ") = " + MyMath.commonDenominator(half, zero));
        System.out.println("commonDenominator(" + half + "," + minusHalf + ") = " + MyMath.commonDenominator(half, minusHalf));
        System.out.println("commonDenominator(" + third + "," + third + ") = " + MyMath.commonDenominator(third, third));
        System.out.println("commonDenominator(" + third + "," + fivesix + ") = " + MyMath.commonDenominator(third, fivesix));
    }
    private static void testScale() {
        System.out.println("Testing the scale function:");
        System.out.println("scale(" + fivesix + "," + 2 + ") = " + fivesix.scale(2));
        System.out.println("scale(" + fivesix + "," + 6+ ") = " + fivesix.scale(6));
        System.out.println("scale(" + half + "," + 2 + ") = " + half.scale(2));
        System.out.println("scale(" + half + "," + 4 + ") = " + half.scale(4));
        System.out.println("scale(" + half + "," + 5 + ") = " + half.scale(5));
        System.out.println("scale(" + third + "," + 5 + ") = " + third.scale(5));
        System.out.println("scale(" + third + "," + 3 + ") = " + third.scale(3));
        System.out.println("scale(" + zero + "," + 2 + ") = " + zero.scale(2));

    }
    private static void testMax() {
        System.out.println("Testing the max function:");
        System.out.println("max(" + half + "," + third + ") = " + MyMath.max(half, third));
        System.out.println("max(" + half + "," + third + ") = " + MyMath.max(third,half));
        System.out.println("max(" + half + "," + zero + ") = " + MyMath.max(half, zero));
        System.out.println("max(" + minusHalf + "," + third + ") = " + MyMath.max(minusHalf, third));
        System.out.println("max(" + minusHalf + "," + minusQuarter + ") = " + MyMath.max(minusHalf, minusQuarter));

    }
}