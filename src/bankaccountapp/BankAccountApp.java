package bankaccountapp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) throws IOException {
		List<Account> accounts = new LinkedList<>();

		// Checking chkacc1 = new Checking("Tommy Walker", "123456789", 1500);

		// Savings savacc1 = new Savings("Bruce Wayne", "987654321", 2500);

		// // savacc1.compound();

		// savacc1.showInfo();
		// System.out.println("*********************************************");
		// chkacc1.showInfo();

		// Read a CSV file then create new accounts based on that data

		String file = "X:\\Projects\\Bank_Application\\NewBankAccounts.csv";

		List<String[]> accountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : accountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);

			// System.out.println("NEW ACCOUNT: " + name + " " + sSN + " " + accountType + "
			// $" + initDeposit);

			// Create account based on account type
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}

		// accounts.get(5).showInfo();

		for (Account acc : accounts) {
			System.out.println("\n*********************************************");
			acc.showInfo();
		}

	}

}
