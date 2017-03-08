/**
 * RatNum is an immutable type representing rational numbers.
 */
public class RatNum {

    private final int numerator;
    private final int denominator;

    // Rep invariant:
    //   denominator > 0
    //   numerator/denominator is in reduced form, i.e. gcd(|numerator|,denominator) = 1
    // Abstraction function:
    //   AF(numerator, denominator) = numerator/denominator
    // Safety from rep exposure:
    //   All fields are private and immutable.

    /**
     * Make a new RatNum == n.
     * @param n value
     */
    public RatNum(int n) {
        numerator = n;
        denominator = 1;
        checkRep();
    }

    /**
     * Make a new RatNum == (n / d).
     * @param n numerator
     * @param d denominator
     * @throws ArithmeticException if d == 0
     */
    public RatNum(int n, int d) throws ArithmeticException {
        // reduce ratio to lowest terms
        int g = gcd(n, d);
        n = n / g;
        d = d / g;

        // make denominator positive
        if (d < 0) {
            numerator = -n;
            denominator = -d;
        } else {
            numerator = n;
            denominator = d;
        }
        checkRep();
    }

    /////////////////////////////////////////
    // other methods should go here
    //    producers: add(), subtract(), multiply(), divide(), etc.
    //    observers: isPositive(), intValue(), etc.
    //    mutators: none

    // Check that the rep invariant is true
    // *** Warning: this does nothing unless you turn on assertion checking
    // by passing -enableassertions to Java
    private void checkRep() {
        assert denominator > 0;
        assert gcd(Math.abs(numerator), denominator) == 1;
    }
    
    /**
     * @return a string representation of this rational number
     */
    @Override
    public String toString() {
        checkRep();
        return (denominator > 1) ? (numerator + "/" + denominator) : (numerator + "");
    }

    // compute greatest common divisor of a and b
    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }    
    
    // TODO: this immutable type needs equals() and hashCode()
}
