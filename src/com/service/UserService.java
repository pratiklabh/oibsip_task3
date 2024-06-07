package com.service;

import java.util.List;

import com.model.Transaction;
import com.model.User;

public interface UserService {
	void addUser(User user);
	
	boolean userExists(int accountNumber, int pin);

	void deposit(int accountNumber, int amount);
	
	void withdraw(int accountNumber, int amount);
	
	void transfer(int sender, int receiver, int amount);
	
	List<Transaction> transactionHistory();
	
	List<User> getAllUsers();
	
}
