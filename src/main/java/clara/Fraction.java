package clara;

public class Fraction {
    private int numerator;
    private int denominator;

    @Override
    public String toString() {
        return "Fraction: " + numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            Fraction simplifiedFraction = this.simplify();
            Fraction simplifiedFraction1 = otherFraction.simplify();
            return simplifiedFraction.numerator == simplifiedFraction1.numerator &&
                    simplifiedFraction.denominator == simplifiedFraction1.denominator;
        }
        return false;
    }


    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("Unexpected argument: " + denominator);
        }
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Unexpected argument: " + denominator);
        }
        this.denominator = denominator;
    }

    public int getLCM(int n1, int n2) {
        if (n1 <= n2) {
            for (int i = n1; i <= n1 * n2; i++) {
                if (i % n1 == 0 && i % n2 == 0) {
                    return i;
                }
            }
        }

        for (int i = n2; i <= n1 * n2; i++) {
            if (i % n1 == 0 && i % n2 == 0) {
                return i;
            }
        }
        return n1 * n2;
    }

    public Fraction add(Fraction other) {
        if (denominator == other.denominator) {
            return new Fraction(numerator + other.numerator, denominator);
        }

        int i = getLCM(denominator, other.denominator);
        int newNumerator1 = numerator * i;
        int newNumerator2 = other.numerator * i;
        return new Fraction(newNumerator1 + newNumerator2, i);
    }

    public Fraction subtract(Fraction other) {
        if (denominator == other.denominator) {
            return new Fraction(numerator - other.numerator, denominator);
        }

        int i = getLCM(denominator, other.denominator);
        int newNumerator1 = numerator * i;
        int newNumerator2 = other.numerator * i;
        return new Fraction(newNumerator1 - newNumerator2, i);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    public Fraction simplify() {
        for (int i = numerator; i > 1; i --) {
            if (numerator % i == 0 && denominator % i == 0) {
                return new Fraction(numerator / i, denominator / i);
            }
        }
        return this;
    }

    public float convertToDecimal() {
        return (float) numerator / denominator;
    }
}
