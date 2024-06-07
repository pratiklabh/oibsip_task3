package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Transaction;
import com.model.User;

public class UserServiceImpl implements UserService {

	static List<User> users = new ArrayList<User>();
	static List<Transaction> transaction = new ArrayList<Transaction>();

	@Override
	public void addUser(User user) {
		users.add(user);
		// System.out.println("-----New User Created Successfully-----");
	}

	@Override
	public boolean userExists(int accountNumber, int pin) {
		
		for (User u : users) {
			if(accountNumber==u.getAccountNumber() && u.getPin()==pin) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deposit(int accountNumber, int amount) {

		for (User u : users) {
			if (u.getAccountNumber() == accountNumber) {

				int balance = u.getBalance() + amount;
				u.setBalance(balance);
				System.out.println(amount + " has been deposited in " + accountNumber);
				System.out.println("Current Balance: " + balance);
				System.out.println("--------------------------------------------------------------------------");

				Transaction t = new Transaction();
				t.setAccountName(u.getAccountName());
				t.setAccountNumber(accountNumber);
				t.setAmount(amount);
				t.setRemarks("Deposit");

				transaction.add(t);

				break;
			} else {
				System.out.println("Account doesn't exist.");
			}
		}

	}

	@Override
	public void withdraw(int accountNumber, int amount) {

		for (User u : users) {
			if (u.getAccountNumber() == accountNumber && amount < u.getBalance()) {

				int balance = u.getBalance() - amount;
				u.setBalance(balance);
				System.out.println(amount + " has been withdrawn from " + accountNumber);
				System.out.println("Current Balance: " + balance);
				System.out.println("--------------------------------------------------------------------------");

				Transaction t = new Transaction();
				t.setAccountName(u.getAccountName());
				t.setAccountNumber(accountNumber);
				t.setAmount(amount);
				t.setRemarks("Withdrawal");

				transaction.add(t);

				break;
			} else {
				System.out.println("Account doesn't exist.");
			}
		}

	}

	@Override
	public List<Transaction> transactionHistory() {
		return transaction;
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void transfer(int sender, int receiver, int amount) {

		for (User u : users) {
			if (u.getAccountNumber() == sender && amount < u.getBalance()) {

				for (User u1 : users) {
					if (u1.getAccountNumber() == receiver) {

						int senderbalance = u.getBalance() - amount;
						u.setBalance(senderbalance);

						int receiverbalance = u1.getBalance() + amount;
						u1.setBalance(receiverbalance);

						System.out.println(amount + " has been transferred from " + sender + " to " + receiver);
						System.out.println("Current Balance of " + sender + " = " + senderbalance);
						System.out.println("Current Balance of " + receiver + " = " + receiverbalance);
						System.out
								.println("--------------------------------------------------------------------------");

						Transaction t = new Transaction();
						t.setAccountName(u.getAccountName());
						t.setAccountNumber(sender);
						t.setAmount(amount);
						t.setRemarks("Trasferred to " + receiver);

						transaction.add(t);
						break;
					} else {
						System.out.println("Receiver Account doesn't exist.");
					}
				}

			}
		}

	}

}
