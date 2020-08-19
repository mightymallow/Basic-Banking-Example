/**
 * 
 */

/**
 * @author Gergely A00976672 
 * Assignment 1
 */

public class ATM {

	private InputReader reader;
	private BankCustomer someCustomer;
	private Bank someBank;
	private boolean isLoggedIn = false;

	/**Builds the ATM and runs run()
	 * @param args
	 */
	public static void main(String[] args) {
		ATM atm = new ATM();
	}

	/**
	 * Default constructor
	 */
	public ATM() {
		reader = new InputReader();
		someBank = new Bank();
		run();
	}

	/**
	 * Displays the information of the logged in customer
	 */
	public void displayAccountInformation() {
		if(isLoggedIn == true) {
			System.out.println("Here are your account details:");
			System.out.println(someCustomer.toString());
		} else {
			verifyCustomer();
		}
	}

	/**
	 * Puts initial customers into the Bank HashMap
	 */
	public void initialize() {
		BankCustomer customer1 = new BankCustomer("joe", "devola", "t1020", "crazy");
		BankCustomer customer2 = new BankCustomer("jerry", "seinfeld", "t1021", "comedian");
		BankCustomer customer3 = new BankCustomer("cosmo", "kramer", "t1022", "funny");
		BankCustomer customer4 = new BankCustomer("george", "costanza", "t1023", "hopeless");
		BankCustomer customer5 = new BankCustomer("elaine", "benice", "t1024", "sarcastic");
		BankCustomer customer6 = new BankCustomer("bob", "sacamano", "t1025", "myfriend");
		someBank.createAccount(customer1);
		someBank.createAccount(customer2);
		someBank.createAccount(customer3);
		someBank.createAccount(customer4);
		someBank.createAccount(customer5);
		someBank.createAccount(customer6);
	}

	/**
	 * Starts the program and loops until exited
	 */
	public void run() {
		initialize();
		int choice = 0;
		System.out.println("Welcome to Bullwinkle's Bank.");

		while (choice != 5) {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
			choice = reader.getIntInput();

			switch (choice) {
			case 1: verifyCustomer();
				break;
			case 2: transactDeposit();
				break;
			case 3: transactWithdraw();
				break;
			case 4: displayAccountInformation();
				break;
			case 5: System.out.println("Thank you for banking at Bullwinkle's Bank.");
					System.out.println("DEBUG: Displaying all the accounts in the bank.");
					someBank.displayAllCustomers();
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

	/**
	 * Calls the method to deposit to the customer account
	 */
	public void transactDeposit() {
		if(isLoggedIn == true) {
			System.out.println("Please enter amount to deposit.");
			double amount = reader.getDoubleInput();
			someCustomer.addToBalance(amount);
		}else {
			verifyCustomer();
		}
	}

	/**
	 * Calls the method to withdraw from the customer account
	 */
	public void transactWithdraw() {
		if(isLoggedIn == true) {
			System.out.println("Please enter amount to withdraw.");
			double amount = reader.getDoubleInput();
			someCustomer.subtractFromBalance(amount);
		}else {
			verifyCustomer();
		}
	}

	/**
	 * Checks Bank HashMap for matching key/value with input account number/passcode
	 */
	public void verifyCustomer() {
		System.out.println("Please enter your account number.");
		String accountNumberVerify = reader.getStringInput();
		System.out.println("Please enter your passcode.");
		String passcodeVerify = reader.getStringInput();
		
		if (!accountNumberVerify.equals("null") && !accountNumberVerify.trim().isEmpty() && !passcodeVerify.equals("null") && !passcodeVerify.trim().isEmpty()) {
			if(Bank.theBank.containsKey(accountNumberVerify) && Bank.theBank.get(accountNumberVerify).getPasscode().equals(passcodeVerify)) {
				System.out.println("Welcome to Bullwinkle's Bank.");
				someCustomer = Bank.theBank.get(accountNumberVerify);
				isLoggedIn = true;
			} else {
			System.out.println("Either account number or passcode is not correct.");
		} 
		} else {
			System.out.println("Please enter valid values.");
		}
	}
}