/**
 * 
 */

/**
 * @author Gergely A00976672 
 * Assignment 1
 */

public class BankCustomer {

	private String firstName;
	private String lastName;
	private String accountNumber;
	private String passcode;
	private double balance;

	/**
	 * Default constructor
	 */
	public BankCustomer() {
		firstName = null;
		lastName = null;
		accountNumber = null;
		passcode = null;
		balance = 0.0;
	}

	/**Constructor to enter customer details
	 * @param firstName customer first name
	 * @param lastName customer last name
	 * @param accountNumber customer account number
	 * @param passcode customer pass code
	 */
	public BankCustomer(String firstName, String lastName, String accountNumber, String passcode) {
		setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
		setPasscode(passcode);
	}

	/**Adds an amount to the customer balance
	 * @param amount input of amount to add
	 */
	public void addToBalance(double amount) {
		if (amount >= 0) {
			balance += amount;
		} else {
			System.out.println("Entered amount is invalid.");
		}
	}

	/**Accessor for account number
	 * @return gets account Number value
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**Accessor for balance
	 * @return gets balance value
	 */
	public double getBalance() {
		return balance;
	}

	/**Accessor for first name
	 * @return gets first name value
	 */
	public String getFirstName() {
		return firstName;
	}

	/**Accessor for last name
	 * @return gets last name value
	 */
	public String getLastName() {
		return lastName;
	}

	/**Accessor for pass code
	 * @return gets pass code value
	 */
	public String getPasscode() {
		return passcode;
	}

	/**Mutator for account number and verifies parameter
	 * @param accountNumber input of account number
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
		} else {
			System.out.println("Please enter a valid account number.");
		}
	}

	/**Mutator for balance and verifies positive
	 * @param balance input of balance
	 */
	public void setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		} else {
			System.out.println("Please enter a valid balance amount.");
		}
	}

	/**Mutator for first name and verifies + capitalizes
	 * @param firstName input of first name
	 */
	public void setFirstName(String firstName) {
		if (firstName != null && !firstName.trim().isEmpty()) {
			String outputName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
			this.firstName = outputName;
		} else {
			System.out.println("Please enter a valid first name.");
		}
	}

	/**Mutator for last name and verifies
	 * @param lastName input of last name
	 */
	public void setLastName(String lastName) {
		if (lastName != null && !lastName.trim().isEmpty()) {
			String outputName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
			this.lastName = outputName;
		} else {
			System.out.println("Please enter a valid last name.");
		}
	}

	/**Mutator for pass code and verifies
	 * @param passcode input of pass code
	 */
	public void setPasscode(String passcode) {
		if (passcode != null && !passcode.trim().isEmpty()) {
			this.passcode = passcode;
		} else {
			System.out.println("Please enter a valid passcode.");
		}
	}

	/**Subtracts value from balance
	 * @param amount input of amount to subtract
	 */
	public void subtractFromBalance(double amount) {
		if (amount >= 0 && balance >= amount) {
			balance -= amount;
		} else if (amount >= 0 && balance < amount) {
			System.out.println("You cannot overdraw your account!");
		} else {
			System.out.println("Please enter a valid amount to subtract from your balance.");
		}
	}

	/* Edited toString function
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String temp = "BankCustomer [firstName=" + this.firstName + ", lastName=" + this.lastName + ", accountNumber=" + this.accountNumber + ", passcode=" + this.passcode + ", balance=" + this.balance + "]";
		return temp;
	}
}
