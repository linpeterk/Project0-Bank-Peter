package Bank;

import java.util.Map;

public class Employees implements Person, java.io.Serializable{
	private String  employeeName; //login user name
	private String  password;  // login password
	private int accessLevel; // 100 for admin, 1 for employees
	Database data ;
	
	public Employees(String userName, String password, int access)
	{
		this.employeeName = userName;
		this.password = password;
		accessLevel = access;
		data = new Database();
	}
	
	public void viewCustomer(String customerName)
	{
		
	}
	
	//List all customers name
	public void listAllCustomer()
	{
		
		if(Database.currentCustomers.size() == 0)
		{
			System.out.println("No Customers");
		}
		
		for(Map.Entry m: Database.currentCustomers.entrySet())
			{
				String userName, password;
				int accountType;
				double balance;
				userName = ((Customers) m.getValue()).getUserName();
				password = ((Customers) m.getValue()).getPassword();
				accountType = ((Customers) m.getValue()).getAccountType();
				balance = ((Customers) m.getValue()).getBalance();				
				System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " +accountType + " balance= " + balance);
			}
	
	}
	
	public void listAllApplicant()
	{
		if(Database.appCustomers.size() == 0)
		{
			System.out.println("No applicants");
		}
		for(Map.Entry m: Database.appCustomers.entrySet())
			{
				String userName, password;
				int accountType;
				double balance;
				userName = ((Customers) m.getValue()).getUserName();
				password = ((Customers) m.getValue()).getPassword();
				accountType = ((Customers) m.getValue()).getAccountType();
				balance = ((Customers) m.getValue()).getBalance();				
				System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " +accountType + " balance= " + balance);
			}
	
	}
	
	public Customers searchCustomer(String customerName)
	{
		
		if (Database.customerVerify(customerName))
		{
			Customers c = Database.findCustomers(customerName);
			c.printCustomer();
			return c;
		}
		 else 
			 {
			 	System.out.println("No customer with user name " + customerName);
			 	return null;
			 }
	
	}
	
	public String getUserName()
	{
		return employeeName;
	}
	
	// set user name
	public void setUserName(String userName)
	{
		this.employeeName =  userName;
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
	public int getaccessLevel()
	{
		return accessLevel;
	}
		
		// set accountType
	public void setaccessLevel(int access)
	{
		this.accessLevel =  access;	
	}	
	
	public void acceptApplicants(String customerName)
	{
		Customers c;
		if(!Database.customerVerify(customerName))
		{
			if(Database.appVerify(customerName))
			{
				c = Database.findApplicant(customerName);
				data.newCustomer(c);
				data.removeApplication(customerName);
			}
			else {
				System.out.println("Applicants don't exist"); 
				return;
			}
		}
		else {
			System.out.println("Applicant is already a customer name");
		}
	}	
	
	public void denyApplicants(String customerName)
	{
		if(Database.appVerify(customerName))
		{
			data.removeApplication(customerName);
		}
		else {
			System.out.println("Applicant user name doesn't exist");
		}
	}	
	
	public void printCustomer() // Print employees data
	
	{
		System.out.println("Username= " + this.employeeName + " Password= "+ this.password + " Account Type= " + this.accessLevel);
	}
	

	
	
}
