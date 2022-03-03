package Bank;

import java.util.Scanner;

public class MenuCustomers {
	
	Scanner scan = new Scanner(System.in);
	public String name;
	public String password;
	public int accountType;
	public double balance;
	
	public int pickAccountType() {

		do{
		System.out.println("Please select enter Account Type. 1 for Checking, 2 for Savings, 3 for Joint");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println("3. Joint");
		
		if(scan.hasNextInt())
		{
		
			accountType = scan.nextInt();
			scan.nextLine(); //clear buffer

			if(accountType != 1 && accountType != 2 && accountType != 3)
			{
				System.out.println("Not a valid option, please try again");

			}
		
		}
		else {
			System.out.println("Not a number, please try again");
			scan.nextLine();
		}
		 //exception handling later
		
		}while(accountType != 1 && accountType != 2 && accountType != 3);
		return accountType;
	}
	
	public double depositBalance() {

		do{
		System.out.println("Deposit amount?");		
		if(scan.hasNextDouble())
		{
		
			balance = scan.nextDouble();
			scan.nextLine(); //clear buffer
			break;

		}
		else {
			System.out.println("Not a number, please try again");
			System.out.println();
			scan.nextLine();		
		}
		 //exception handling later
		
		}while(true);
		return balance;
	}
	
	public void withdrawMenu(Transactions t)
	{

		double withdraw = 0;
		System.out.println("Enter withdrawl amount");
		if(scan.hasNextDouble())
		{
			withdraw = scan.nextDouble();
			scan.nextLine(); //clear buffer
			
				t.withDraw(withdraw);
		}
		else System.out.println("Cannot withdrawl: Not a number");
	}
	
	public void depositMenu(Transactions t)
	{
		double depos = 0;
		System.out.println("Enter deposit amount");
		if(scan.hasNextInt())
		{
			depos = scan.nextInt();
			scan.nextLine(); //clear buffer
			if(depos<0) {
				System.out.println("Cannot deposit: Negative number");
			}
				t.deposit(depos);
		}
		else System.out.println("Cannot Deposit: Not a number");
	}
	
	public void viewBalanceMenu(Transactions t)
	{
		System.out.println("Total Balance = " + t.viewBalance());

		
	}
	
	
	public void transferMenu(Transactions t)
	{
		double transfer = 0;
		String destUserName = null;
		
		System.out.println("Enter Destination user name");
		destUserName = scan.nextLine();

		
		Transactions dest = new Transactions(Database.findCustomers(destUserName)); //Find target customer's data
		
			if(dest.c == null) {
				System.out.println("Transfer failed: Destination UserName: " + destUserName + " do not exist.");
				return;
			}
		
		
		System.out.println("Enter transfer amount");
		if(scan.hasNextInt())
		{
			transfer = scan.nextInt();
			scan.nextLine(); //clear buffer
			if(transfer<0) {
				System.out.println("Cannot transfer: Negative number");
				return;
			}
			
		}
		else {
			System.out.println("Cannot Transfer: Not a number");
			return;
		}
		
			t.transfer(transfer, destUserName);
	}
	
	
}
