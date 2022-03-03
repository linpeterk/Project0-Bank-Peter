package Bank;

/**
Customer information: User name, login, balance, and account type

*/
public class Customers implements Person, java.io.Serializable{
	
	private String  userName; //login user name
	private String password;  // login password
	private int accountType; // 1= checking, 2=saving, 3=joint
	private double balance;
	
	//constructor
	Customers(String username, String password, int accountType, double balance)
	{
		this.userName = username;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
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
		System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " + accountType+ " balance= " + balance);
	}
}