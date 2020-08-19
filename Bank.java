import java.util.HashMap;
import java.util.Set;

/**
 * @author Gergely A00976672 
 * Assignment 1
 */

public class Bank {

	private String accountNumber;
	private BankCustomer customer;
	public static HashMap<String, BankCustomer> theBank;

	/**
	 * Default constructor to create the HashMap
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}

	/**Removes an account from the HashMap
	 * @param accountNumber user input of account number to remove
	 */
	public void closeAccount(String accountNumber) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			System.out.println("Please enter a valid account number.");
		} else if (theBank.containsKey(accountNumber)) {
			theBank.remove(accountNumber);
		} else {
			System.out.println("No matching account was found.");
		}
	}

	/**Adds an account to the Bank HashMap
	 * @param customer the object to be added to the HashMap
	 */
	public void createAccount(BankCustomer customer) {
		if (customer != null) {
			theBank.put(customer.getAccountNumber(), customer);
		} else {
			System.out.println("Please select a valid customer to create an account for.");
		}
	}

	/**Deposits funds to the appropriate customer account
	 * @param accountNumber user input of account to edit
	 * @param amount user input of amount to add to balance
	 */
	public void deposit(String accountNumber, double amount) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			System.out.println("Please enter a valid account number.");
		} else if (theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).addToBalance(amount);
		} else {
			System.out.println("No matching account was found.");
		}
	}

	/**
	 * Displays the info of all customers in the bank
	 */
	public static void displayAllCustomers() {
		if (theBank.size() > 0) {
			Set<String> accounts = theBank.keySet();
			for (String members : accounts) {
				System.out.println(theBank.get(members).toString());
			}
		} else {
			System.out.println("There are no bank customers to display.");
		}
	}

	/**Displays a single customers information
	 * @param customer user select of which customer to display
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		if (customer != null) {
			System.out.println(customer.toString());
		}
	}

	/**Withdraws an amount from a customer account
	 * @param accountNumber user input of account to be edited
	 * @param amount user input of amount to be withdrawn from balance
	 */
	public void withdraw(String accountNumber, double amount) {
		if (accountNumber == null || accountNumber.trim().isEmpty()) {
			System.out.println("Please enter a valid account number.");
		} else if (theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).subtractFromBalance(amount);
		} else {
			System.out.println("No matching account was found.");
		}
	}
}
