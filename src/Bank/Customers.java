package Bank;

import java.util.ArrayList;

/**
Customer information: User name, login, balance, and account type

*/
public class Customers implements Person, java.io.Serializable{
	
	private String  userName; //login user name
	private String password;  // login password
	private int accountType; // 1= checking, 2=saving, 3=joint
	private double balance;
	ArrayList<String> tranHistory = new ArrayList<String>();
	//DEPOSIT IS 1, WITHDRAW IS 2, TRANSFER IS 3

	//constructor
	Customers(String username, String password, int accountType, double balance)
	{
		this.userName = username;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
		
	}
	
	//print transhistory
	public void printHistory()
	{
		System.out.println("============= TransAction History ==================");
		
		for(String a:tranHistory)
		{
			String type = a.substring(0, 1); //type of transaction
			String rest = a.substring(1, a.length()-2); //Rest of stuff
			if(type.equals("1")) //deposit
			{
				System.out.println("Deposit: "+ rest);
		
			}
			else if(type.equals("2")) //withdraw
			{
				System.out.println("Withdraw: "+ rest);
			}
			else if(type.equals("3")) //transfer
			{
				System.out.println("Transfer: "+ rest);
			}
			
		}
		System.out.println("\"============= TransAction History ==================\"");
	}
	// get user name
	public String getUserName()
	{
		return userName;
	}
	
	// set user name
	public void setUserName(String userName)
	{
		this.userName =  userName;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	// set user name
	public void setBalance(Double balance)
	{
		this.balance =  balance;
	}
	
	// get password 
	public String getPassword()
	{
		return password;
	}
	
	// set password
	public void setPassword(String password)
	{
		this.password =  password;
	}
	
	// get accountType 1=checking 2=saving 3=joint account
	public int getAccountType()
	{
		return accountType;
	}
		
		// set accountType
	public void setAccountType(int accountType)
	{
		this.accountType =  accountType;	
	}	
	
	public void printCustomer()
	{
		String temp = "";
		switch(accountType)
		{
		case 1: temp= "Checking";break;
		case 2: temp= "Savings";break;
		case 3: temp= "Joint";break;
		default: temp= "Checking";
		}
		System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " + temp + " balance= " + balance);
	}
}
