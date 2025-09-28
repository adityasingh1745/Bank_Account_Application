package bankaccountapp;

public class Savings extends Account {
    // List properties specific to savings accounts
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize savings account properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to savings accounts
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: SAVINGS");
        super.showInfo();
        System.out.println(" Your Savings Account Features " + "\n SAFETY DEPOSIT BOX ID: " + safetyDepositBoxID);
        System.out.println(" SAFETY DEPOSIT BOX KEY: " + safetyDepositBoxKey);
    }
}
