package bankaccountapp;

public abstract class Account implements InterestRate {
    // List common properties for savings and checking accounts
    private String name; // Account holder name
    private String sSN; // Social Security Number
    private double balance; // Account balance
    private static int index = 10000; // Static index to generate unique account numbers
    protected String accountNumber; // Account number
    protected double rate; // Interest rate
    private String rupee = "\u20B9";

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();

    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index; // This should be a static variable that increments with each new account
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: " + rupee + accruedInterest);
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing " + rupee + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing " + rupee + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring " + rupee + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: " + rupee + balance);
    }

    // Show info
    public void showInfo() {
        System.out.println("NAME: " + name);
        System.out.println("ACCOUNT NUMBER: " + accountNumber);
        System.out.println("BALANCE: " + rupee + balance);
        System.out.println("RATE: " + rate + "%");
    }

}
