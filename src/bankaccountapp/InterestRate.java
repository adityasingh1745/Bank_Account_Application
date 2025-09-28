package bankaccountapp;

public interface InterestRate {
    // Write a method that returns the base interest rate
    default double getBaseRate() {
        return 2.5;
    }
}
