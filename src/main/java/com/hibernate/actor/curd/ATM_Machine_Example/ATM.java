package com.hibernate.actor.curd.ATM_Machine_Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
	private int pin=9063;
	private float balance;
	private List<String> transactionhistory = new ArrayList<String>();
	
	public void checkpin()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your PIN :");
		int enterpin=sc.nextInt();
		if(enterpin==pin)
		{
			menu();
		}
		else
		{
			System.out.println("Please Enter a valid PIN number");
			checkpin();
		}
		sc.close();
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("Choose the option below");
		System.out.println("1.Deposite Money");
		System.out.println("2.Withdraw Money");
		System.out.println("3.Check Balance");
		System.out.println("4.Transaction History");
		System.out.println("5.Exit");
		
		Scanner sc=new Scanner(System.in);
		 int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			depositemoney();
			break;
		case 2:
			withdrawmoney();
			break;
		case 3:
			checkbalance();
			break;
		case 4:
			Transactionhistory();
		case 5:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Inavild Option please try again");
			menu();
			break;
		}
		sc.close();
	}

	private void Transactionhistory() {
		// TODO Auto-generated method stub
		System.out.println("Transaction History :");
		for(String transaction : transactionhistory)
		{
			System.out.println(transaction);
		}
		menu();
	}

	private void checkbalance() {
		// TODO Auto-generated method stub
		System.out.println("Balance is "+balance);
		transactionhistory.add("Checked Balance :"+balance);
		menu();
	}

	private void withdrawmoney() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount to withdraw");
		float draw=sc.nextFloat();
		if(balance>=draw)
		{
			balance = balance-draw;
			System.out.println("Money Withdraw Successfully");
			transactionhistory.add("Withdraw $:"+draw);
		}
		else
		{
			System.out.println("Insufficent Funds");
		}
		menu();
		sc.close();
	}

	private void depositemoney() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Deposite Amount");
		float amount=sc.nextFloat();
		balance=balance+amount;
		System.out.println("Amount deposited Successfully");
		transactionhistory.add("Deposited $:"+amount);
		menu();
		sc.close();
	}
}