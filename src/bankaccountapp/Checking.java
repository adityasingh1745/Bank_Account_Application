package bankaccountapp;

public class Checking extends Account {
    // List properties specific to checking accounts
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    // List any methods specific to checking accounts
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: CHECKING");
        super.showInfo();
        System.out.println(" Your Checking Account Features " + "\n DEBIT CARD NUMBER: " + debitCardNumber);
        System.out.println(" DEBIT CARD PIN: " + debitCardPIN);
    }
}
