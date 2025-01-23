package com.braindata.bankmanagement.serviceImpl;

import java.util.Scanner;

import com.braindata.bankmanagement.model.Account;
import com.braindata.bankmanagement.service.Rbi;

public class Sbi implements Rbi {
	Scanner sc = new Scanner(System.in);
	Account account = new Account();

	@Override
	public void createAccount() {
		System.out.println("Enter AccountNo(8 digit) :");
		while (true) {
			int accNo = sc.nextInt();
			int count=0;
			int temp=accNo;
			
			while (accNo != 0) {
				accNo = accNo / 10;
				count++;
			}
			if (count == 8) {
			
				account.setAccNo(temp);
				break;
			} else {
				System.out.println("Please Check your accNo and try again");
			}
		}
		sc.nextLine();
		System.out.println("Enter Account Holder Name (only alphabate) :");
		while (true) {
			String name = sc.nextLine();
			if ( name.isEmpty() || name.matches("[a-zA-Z ]+")) {
				account.setName(name);
				break;
			} else {
				System.out.println("Please Check your Name and try again");
			}
		}
		
		System.out.println("Enter Mobile Number (10 digit):");
		while (true) {
			String mobNo = sc.next();
			int i = mobNo.length();
			if (i == 10) {
				account.setMobNo(mobNo);
				break;
			} else {
				System.out.println("Please Check your mobNo and try again ");
			}
		}
		System.out.println("Enter Adhar Number (12 digit):");
		while (true) {
			String adharNo = sc.next();
			int j = adharNo.length();
			if (j == 12) {
				account.setAdharNo(adharNo);
				break;
			} else {
				System.out.println("Please Check your adharNo and try again");
			}
		}
		System.out.println("Enter Gender (male-female):");
		while (true) {
			sc.nextLine();
			String gender = sc.next();
			if (gender.equals("male") || gender.equals("female")) {
				account.setGender(gender);
				break;
			} else {
				System.out.println("Enter gender Does not match");
			}
		}
		System.out.println("Enter your Age (18-50):");
		while (true) {
			int age = sc.nextInt();
			if (age >= 18 && age <= 50) {
				account.setAge(age);
				break;
			} else {
				System.out.println("Please Check your Enterd age and try again");
			}
		}
		while (true) {
			System.out.println("Enter Balance :");
			double balance = sc.nextDouble();
			if (balance >= 500) {
				account.setBalance(balance);
				break;
			} else {
				System.out.println("Currunt balance is:" + account.getBalance());
			}
		}
		System.out.println("***********************************");
	}

	@Override
	public void displayAllDetails() {
	
			System.out.println("Enter your acNo");
			int ac=sc.nextInt();
			if(ac==account.getAccNo()) {
			System.out.println("Account Number : " + account.getAccNo());
			System.out.println("Name : " + account.getName());
			System.out.println("Mobile No :" + account.getMobNo());
			System.out.println("Adhar No :" + account.getAdharNo());
			System.out.println("Gender :" + account.getGender());
			System.out.println("Age :" + account.getAge());
			System.out.println("Balance :" + account.getBalance());
		} else {
			System.out.println("account Not exist..!!");
		}
		System.out.println("***********************************");
	}

	@Override
	public void depositeMoney() {
		System.out.println("Enter accNo :");
		int ac=sc.nextInt();
		if (ac == account.getAccNo()) {
			System.out.println("Enter Deposite Ammount");
			double deposite = sc.nextDouble();
			if (deposite > 0) {
				account.setBalance(account.getBalance() + deposite);
				System.out.println(account.getBalance() + "" + " Money Deposite Succesfully..!!!");
			} else {
				System.out.println("sorry deposite money must have gretter than 0");
			}
		} else {
			System.out.println("account dose not exists.....!!");
		}
		System.out.println("***********************************");
	}

	@Override
	public void withdrawal() {
		System.out.println("Enter accNo :");
		int ac=sc.nextInt();
		if (ac == account.getAccNo()) {
			System.out.println("Enter Withdraw Ammount");
			double withdraw = sc.nextDouble();
			if (withdraw <= account.getBalance()) {
				account.setBalance(account.getBalance() - withdraw);
				System.out.println("Remaining balance : = " + account.getBalance() + "" + " Money Withdraw Succefull..!!!");
			} else if (withdraw > account.getBalance()) {
				System.out.println("Insuccicient balance");
			} else {
				System.out.println("Withdraw amount amount must be gretter than 0");
			}
		} else {
			System.out.println("account dose not exist");
		}
		System.out.println("***********************************");
	}

	@Override
	public void balanceCheck() {
		System.out.println("Enter accNo :");
		int ac=sc.nextInt();
		if (ac == account.getAccNo()) {
			System.out.println("Current Account Balance : " + account.getBalance());
		} else {
			System.out.println("account dose not exists...");
		}
		System.out.println("***********************************");
	}
}
