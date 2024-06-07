package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Transaction;
import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class UserView {

	public static void main(String[] args) {

		createUser();
		getUsers();
		Scanner sc = new Scanner(System.in);
		UserService us = new UserServiceImpl();
		
		System.out.println("------------------------- ATM INTERFACE -------------------------");
		System.out.print("Enter user account number: ");
		int accNum = sc.nextInt();
		
		System.out.print("Enter pin: ");
		int pin = sc.nextInt();
		
		
		int n = 0;
		
		if(us.userExists(accNum, pin)) {
			do {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("Choose an option: ");
				System.out.println("1: Transactions History");
				System.out.println("2: Withdraw");
				System.out.println("3: Deposit");
				System.out.println("4: Transfer");
				System.out.println("5: Quit");
				System.out.print("Choose an option (1-5): ");
				n = sc.nextInt();
	
				switch (n) {
	
				case 1:
					transactionHistory();
					break;
	
				case 2:
					withdraw();
					break;
	
				case 3:
					deposit();
					break;
	
				case 4:
					transfer();
					break;
	
				case 5:
					System.out.println("Exited Successfully");
					break;
	
				default:
					System.out.println("Invalid Input");
	
				}
	
			} while (n != 5);

		}else {
			System.out.println("Incorrect Account Number or Pin");
		}
	}

	static void createUser() {

		UserService us = new UserServiceImpl();

		User u1 = new User();
		u1.setAccountNumber(111);
		u1.setAccountName("User1");
		u1.setBalance(17000);
		u1.setPin(1234);

		us.addUser(u1);

		User u2 = new User();
		u2.setAccountNumber(222);
		u2.setAccountName("User2");
		u2.setBalance(18500);
		u2.setPin(4321);

		us.addUser(u2);

	}

	static void getUsers() {
		UserService us = new UserServiceImpl();

		List<User> userList = us.getAllUsers();
		System.out.println(userList);
	}

	static void deposit() {

		UserService us = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Account Number: ");
		int accountNumber = sc.nextInt();

		System.out.print("Enter Amount to be deposited: ");
		int amount = sc.nextInt();

		us.deposit(accountNumber, amount);

	}

	static void withdraw() {
		UserService us = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Account Number: ");
		int accountNumber = sc.nextInt();

		System.out.print("Enter Amount to be withdrawn: ");
		int amount = sc.nextInt();

		us.withdraw(accountNumber, amount);

	}

	static void transfer() {
		UserService us = new UserServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Sender Account Number: ");
		int sender = sc.nextInt();
		
		System.out.print("Enter Receiver Account Number: ");
		int receiver = sc.nextInt();

		System.out.print("Enter Amount to be transferred: ");
		int amount = sc.nextInt();

		us.transfer(sender, receiver, amount);

	}

	static void transactionHistory() {
		UserService us = new UserServiceImpl();
		List<Transaction> tList = us.transactionHistory();
		System.out.println(tList);
	}

}
