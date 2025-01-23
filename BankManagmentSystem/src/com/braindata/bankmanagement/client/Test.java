package com.braindata.bankmanagement.client;
import java.util.Scanner;

import com.braindata.bankmanagement.service.*;
import com.braindata.bankmanagement.serviceImpl.*;
public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Rbi bank=new Sbi();
		int i=1;
		while(i<=5) {
			System.out.println("Bank Managemnet System");
			System.out.println(" .Choose an option: ");
			System.out.println(" 1.Create Account");
			System.out.println(" 2.Display All Details");
			System.out.println(" 3.Deposite Amount");
			System.out.println(" 4.Withdraw Amount");
			System.out.println(" 5.Check Balance");
			System.out.println(" 6. Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			bank.createAccount();
			break;
		case 2:
			bank.displayAllDetails();
			break;
		case 3:
			bank.depositeMoney();
			break;
		case 4:
			bank.withdrawal();
			break;
		case 5:
			bank.balanceCheck();
			break;
		case 6:
			System.exit(0);
			default:
				System.out.println("Invalid Choice......");
		}
		}
	}
}
