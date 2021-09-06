/**
 * Represents an expression
 */
public class Expression {

    private static final char[] OPS = {'+', '-', '*', ':', '>'};

    // The operands and operator of this expression
    private Fraction op1;
    private Fraction op2;
    private char op;

    /**
     * Constructs an expression.
     *
     * @param f1 1st Fraction
     * @param f2 2nd Fraction
     * @param op char of operation between f1 # f2
     */
    public Expression(Fraction f1, Fraction f2, char op) {
        op1 = f1;
        op2 = f2;
        this.op = op;
    }

    /**
     * Constructs a random expression.
     * A random expression consists of two random fractions, each with the given
     * limit, and a randomly selected operation which is either +, -, *, /, or >.
     *
     * @param limit must be at least 2
     */
    public Expression(int limit) {
        op1 = new Fraction(limit);
        op2 = new Fraction(limit);
        this.op = OPS[(int) (Math.random() * OPS.length)];
    }

    /**
     * Returns the first operand of this expression.
     *
     * @return the first operand of this expression (a fraction)
     */
    public Fraction getOp1() {
        return op1;
    }

    /**
     * Returns the second operand of this expression.
     *
     * @return the second operand of this expression (a fraction)
     */
    public Fraction getOp2() {
        return op2;
    }

    /**
     * Returns the operator of this expression.
     *
     * @return the second operand of this expression (a fraction)
     */
    public char getOp() {
        return op;
    }

    /**
     * Returns the value of this expression, as a fraction.
     * If the operator (op) is '>', returns op1 minus op2, as a fraction.
     *
     * @return the value of this expression, as fraction.
     */
    public Fraction value() {
        // Replace the following statement with your code todo
        switch (op) {
            case '+':
                return op1.add(op2);
            case '*':
                return op1.multiply(op2);
            case ':':
                return op1.divide(op2);
            case '>':
            case '-':
            default:
                return op1.subtract(op2);
        }
    }

    /**
     * Returns an expression that serves as a hint for this expression.
     * Note: Multiplication expressions have no hints.
     *
     * @return an expression that has the same value as this expression
     */
    public Expression hint() {
        switch (op) {
            case '+':
                return this.addHint();
            case '-':
                return this.subHint();
            case '*':
                return null;
            case ':':
                return this.divHint();
            case '>':
                return this.compHint();
            default:
                return this;
        }
    }

    /**
     * Returns an expression that serves as a hint for solving this addition expression.
     * For example, the hint for 1/2 + 2/3 is 3/6 + 4/6.
     *
     * @return an expression that has the same value as this expression
     */
    public Expression addHint() {
        int common = MyMath.commonDenominator(op1,op2);
        return new Expression(op1.scale(common),op2.scale(common),op);
    }

    /**
     * Returns an expression that serves as a hint for solving this subtraction expression.
     * For example, the hint for 1/2 - 2/3 is 3/6 - 4/6.
     *
     * @return an expression that has the same value as this expression
     */
    public Expression subHint() {
        int common = MyMath.commonDenominator(op1,op2);
        return new Expression(op1.scale(common),op2.scale(common),op);
    }


    /**
     * Returns an expression that serves as a hint for solving this division expression.
     * For example, the hint for 1/2 : 2/3 is 1/2 * 3/2.
     *
     * @return a multiplication expression that has the same value as this expression
     */
    public Expression divHint() {
        return new Expression(op1, op2.invert(), '*');
    }

    /**
     * Returns an expression that serves as a hint for solving this comparison expression.
     * For example, the hint for 1/2 > 2/3 is 1/2 - 2/3.
     *
     * @return a subtraction expression
     */
    public Expression compHint() {
        return new Expression(op1, op2, '-');
    }

    /**
     * Returns a string representation of this expression.
     * If the operand is negative, encloses the operand with parentheses.
     * For example, if op1 = 1/5, op2 = -1/3, and op = "-", returns "1/5 - (-1/3)".
     *
     * @return a string representation of this expression.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(op1 + " " + op + " ");
        if (op2.signum() < 0) {
            str.append("(" + op2 + ")");
        } else {
            str.append(op2);
        }
        return str.toString();
    }
}