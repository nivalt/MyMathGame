/**
 * Represents a signed fraction, e.g. 2/3 or -1/5.
 * A fraction has a numerator (int), and a denominator (int).
 */
public class Fraction {

    // The fields of this Fraction
    private int numerator;
    private int denominator;

    /**
     * Constructs a fraction.
     * The newly constructed fraction is reduced.
     * For example, given 6 and 9, constructs the fraction 2/3.
     * If the denominator is negative, converts the signs of both the numerator and the denominator.
     * For example, 2/-3 becomes -2/3, and -2/-3 becomes 2/3.
     *
     * @param numerator   can be signed
     * @param denominator can be signed
     */
    public Fraction(int numerator, int denominator) {
        // Handles the signs of the numerator and denominator
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
        // Initializes the object's fields
        this.numerator = numerator;
        this.denominator = denominator;
        // Divides the numerator and denominator by their greatest common divisor
//        no need to implement reduce...
//        this.reduce();
    }


    /**
     * Constructs a random fraction.
     * The denominator is a random positive random number which is less than limit, and
     * the numerator is a random positive random number which is less than the denominator.
     *
     * @param limit must be greater or equal to 2
     */
    public Fraction(int limit) {
        // Put your code here todo
        int randDenom = (int) (Math.random() * (limit - 2) + 2);
        int randNum = (int) (Math.random() * (randDenom - 1) + 1);
        this.numerator = randNum;
        this.denominator = randDenom;
    }

    /**
     * Returns the numerator of this fraction.
     *
     * @return the numerator of this fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns the denominator of this fraction.
     *
     * @return the denominator of this fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Returns a fraction which is the sum of this fraction and the other one.
     *
     * @param other the fraction to which this fraction is added
     * @return a fraction which is the sum of this fraction and the other one
     */
    public Fraction add(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction((numerator + other.numerator),this.denominator);
        }
        return new Fraction(
                (numerator * other.denominator + other.numerator * denominator),
                denominator * other.denominator);
    }



    /**
     * Returns a fraction which is the product of this fraction and the other one.
     *
     * @param other the fraction by which this fraction is multiplied
     * @return a fraction which is the product of this fraction and the other one
     */
    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator,
                denominator * other.denominator);
    }

    /**
     * Returns a fraction which is the reciprocal of this fraction.
     *
     * @return the reciprocal of this fraction
     */
    public Fraction invert() {
        return new Fraction(denominator, numerator);
    }

    /**
     * Returns a fraction which is the division of this fraction and the other one.
     *
     * @param other the fraction by which this fraction is divided
     * @return a fraction which is the division of this fraction and the other one
     */
    public Fraction divide(Fraction other) {
        return multiply(other.invert());
    }

    /**
     * Returns a fraction which is the value of this fraction raised to the power of n.
     *
     * @param n the exponent. Must be at least 0
     * @return this fraction raised to the power of n
     */
    public Fraction pow(int n) {
        int powdNum = (int) Math.pow(this.numerator, n);
        int powdDenum = (int) Math.pow(this.denominator, n);
        Fraction powered = new Fraction(powdNum, powdDenum);
        return powered;
    }

    /**
     * Returns a string representation of this fraction, in the form "numerator/denominator".
     * Special cases:
     * If the numerator is 0, returns "0". If the denominator is 1, returns the numerator.
     *
     * @return a textual representation of this Fraction, in the form "numerator/denominator
     */
    public String toString() {
        String result;
        if (numerator == 0)
            result = "0";
        else
            result = numerator + "/" + denominator;
        return result;
    }

    /**
     * Reduces this fraction by dividing its numerator and denominator by
     * their greatest common divisor (GCD).
     */
    public void reduce() {
        if (numerator != 0) {
            int gcd = MyMath.gcd(Math.abs(numerator), denominator);
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
    }

    /**
     * Returns the absolute value of this fraction.
     * For example, if this fraction is -1/3, returns the fraction 1/3.
     *
     * @return the absolute value of this fraction.
     */
    public Fraction abs() {
        int num = this.numerator;
        if (num < 0) {
            num = num * (-1);
        }
        Fraction abs = new Fraction(num, this.denominator);
        return abs;
    }

    /**
     * Returns the signum of this fraction.
     *
     * @return -1 if this fraction is negative, 0 if this fraction equals 0,
     * and 1 if this fraction is greater than 0.
     */
    public int signum() {
        int sign;
        if (this.numerator < 0) {
            sign = -1;
        } else if (this.numerator == 0) {
            sign = 0;
        } else {
            sign = 1;
        }
        return sign;
    }

    /**
     * Returns a fraction which is the negative value of this fraction.
     * For example, if this fraction is 1/3, returns -1/3.
     * If this fraction is -1/3, returns 1/3.
     * If this fraction is 0, returns 0.
     *
     * @return the negative value of this fraction.
     */
    public Fraction convert() {
        return this.multiply(new Fraction(-1, 1));
    }

    /**
     * Returns a fraction which is this fraction minus the other fraction.
     *
     * @param other the fraction to subtract
     * @return this fraction minus the other fraction
     */
    public Fraction subtract(Fraction other) {
        return this.add(other.convert());
    }

    /**
     * Compares this fraction to the other fraction
     *
     * @param other the fraction to compare to
     * @return 1 if this fraction is greater than the other fraction
     * 0 if the two fractions are equal
     * -1 if this fraction is less than the other fraction
     */
    public int compareTo(Fraction other) {
        return this.subtract(other).signum();
    }
    /**
     * Scales this fraction by an integer
     *
     * @param n an integer to scale numerator and denominator, should be multipication of original denominator
     * @return fraction scaled by the number
     */
    public Fraction scale(int n) {
        if (denominator == n) {
            return this;
        }
            int res = n/denominator;
            return new Fraction(this.numerator * res, this.denominator * res);
        }


    /**
     * Checks if this fraction equals the other fraction.
     * Two fractions are equal if they have the same numerator and the same denominator.
     *
     * @param other the fraction to compare to
     * @return true the two fractions are equal, false otherwise.
     */
    public boolean equals(Fraction other) {
        return (this.compareTo(other) == 0);
    }


}