package com.capgemini.view;
import com.capgemini.exceptions.*;
import com.capgemini.modle.Bank;
import com.capgemini.controller.BankOfIndia;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Bank bank = new BankOfIndia();
		Scanner sc = new Scanner(System.in);
		Integer accNo;
		Integer amt;
		while(true)
		{
			System.out.println("MENU:");
			System.out.println("1.Create New Account\n2.Existing Account\n3.EXIT\nENTER YOUR CHOICE");
			int choice= sc.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				System.out.println("Enter Deposit Amount:");
				Integer deposit = sc.nextInt();
				if(bank.CreateAccount(accNo, deposit))
					System.out.println("Account Created Successfully!");
				else
					System.out.println("Unable to open Account!");
				break;
			case 2:
				System.out.println("Enter Account Number:");
				accNo = sc.nextInt();
				try {
					if(bank.validateAccount(accNo) ) 
					{
						System.out.println("WELCOME!");
						System.out.println("MENU:");
						System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Check Balance\n"
								+ "5.Exit\nENTER YOUR CHOICE");
						int ch= sc.nextInt();
						switch (ch)
						{
						case 1:
							System.out.println("Enter Amount:");
							amt = sc.nextInt();
							if(bank.depositAmount(accNo, amt)) {
								System.out.println("Amount Deposit Successfully!");
							}
							break;
						case 2:
							System.out.println("Enter Amount:");
							amt = sc.nextInt();
							try {
								if(bank.withdrawAmount(accNo, amt)) {
									System.out.println("Amount Withdrawn Successfully!");
								}
							} catch (Exception e) {
								System.out.println("INSUFFICIENT BALANCE!");
							}
							
							break;
						case 3:
							System.out.println("Enter Reciever's Account No:");
							Integer rAcc = sc.nextInt();
							try {
								if(bank.validateAccount(rAcc)) {
									System.out.println("Enter Amount:");
									amt = sc.nextInt();
									try {
										if(bank.fundTransfer(accNo,rAcc,amt)) {
											System.out.println("Amount Trasferred Successfully!");
										}
									} catch (Exception e) {
										System.out.println("INSUFFICIENT BALANCE!");
									}
								}
							} catch (Exception e) {
								System.out.println("Reciever's Account Not Found!");
							}
							
							break;
						case 4:
							System.out.println("Your Balance is: "+bank.checkBalance(accNo));
							break;
						case 5:
							System.exit(0);
						default:
							System.out.println("Please Enter Valid Choice!");
						}
					}
				} catch (AccountNotFoundException e) {
					System.out.println("INVALID ACCOUNT NUMBER: No record found for entered number");
				}
				
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Please Enter Valid Choice!");
			}
		}
	}
}

