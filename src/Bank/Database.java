package Bank;

import java.util.*;


public class Database implements java.io.Serializable{

	public static HashMap<String, Customers> currentCustomers = new HashMap<String, Customers>(); //Current approved Customers
	public static HashMap<String, Customers> appCustomers = new HashMap<String, Customers>(); //Customers waiting for approval
	public static HashMap<String, Employees> employees = new HashMap<String, Employees>(); //Customers waiting for approval
	

	//appCustomer parameter Customer objects
	public void application(String userName, String password, int accountType, double balance)
	{
		Customers c = new Customers(userName.toUpperCase(), password, accountType, balance);
		appCustomers.put(userName.toUpperCase(), c);
	}
	//appCustomer parameter Customer Object
	public void application(Customers c)
	{
		appCustomers.put(c.getUserName().toUpperCase(), c);
	}
	
	//currentCustomer added parameters data
	public void newCustomer(String userName, String password, int accountType, double balance)
	{
		Customers c = new Customers(userName.toUpperCase(), password, accountType, balance);
		currentCustomers.put(userName.toUpperCase(), c);
	}
	//currentCustomer added parameter customer object
	public void newCustomer(Customers c)
	{
		currentCustomers.put(c.getUserName().toUpperCase(), c);
	}
		
	//new employee parameters datas name
	public void newEmployee(String userName, String password, int accessLevel)
	{
		Employees e = new Employees(userName.toUpperCase(), password, accessLevel);
		employees.put(userName.toUpperCase(), e);
	}
	//add new admin
	public void newAdmin(String userName, String password, int accessLevel)
	{
		Employees e = new Admins(userName.toUpperCase(), password, accessLevel);
		employees.put(userName.toUpperCase(), e);
	}
	//new employee parameter object
	public void newEmployee(Employees e)
	{	
		employees.put(e.getUserName().toUpperCase(), e);
	}
	
		
	//Deny application with username, delete from appCustomers
	public void removeApplication(String userName)
	{
		if(appVerify(userName))
		appCustomers.remove(userName.toUpperCase());
		else System.out.println("Applicant Does Not Exist");
	}
	//remove customer given user name parameter
	public void removeCustomer(String userName)
	{
		if(customerVerify(userName))
			currentCustomers.remove(userName.toUpperCase());
			else System.out.println("Database: Customer Does Not Exist");
	}

	
	//Find current existing Customers
	public static Customers findCustomers(String userName)
	{
		return currentCustomers.get(userName.toUpperCase());
	}
	
	public static Employees findEmployees(String userName)
	{
		return employees.get(userName.toUpperCase());
	}
	
	//Find applicant 
	public static Customers findApplicant(String userName)
	{
		return appCustomers.get(userName.toUpperCase());
	}
	
	//Check customer exist
	public static boolean customerVerify(String userName)
	{

		Customers c = currentCustomers.get(userName.toUpperCase());
		 if(c==null)
		 {
			 return false;
		 }
		 else return true;
	}
	
	
	//check customer username and password
	public static boolean customerVerify(String userName, String password)
	{
		if (customerVerify(userName))
		{
			Customers c = findCustomers(userName);
			if (c.getPassword().equals(password)) {
					return true;
			}
			else return false;
		}
		 else 
			 {
			 	return false;
			 }
	}
	
	//Check applicant exist
		public static boolean appVerify(String userName)
		{
			Customers c = appCustomers.get(userName.toUpperCase());
			 if(c==null)
			 {
				 return false;
			 }
			 else return true;
		}
		
		//Check applicant username and password
		public boolean appVerify(String userName, String password)
		{
			Customers c = appCustomers.get(userName.toUpperCase());
			 if(c==null)
			 {
				 return false;
			 }
			 else return true;
		}
	
	//verify if employee exist
	public static boolean employeeExist(String userName, String password)
	{
		Employees e = employees.get(userName.toUpperCase());
		 if(e==null)
		 {
			 System.out.println("No such employees");
			 return false;
		 }
		 else
		 {
				
				if (e.getPassword().equals(password)) {
					System.out.println("Employees Found");
					return true;
				}
				else return false;
			
		 }
		
	}
	
	
	
	//find applicant and print its information
	public void appPrint(String userName)
	{
		Customers c = appCustomers.get(userName.toUpperCase());
		c.printCustomer();
	}
	
	//find customers and print its information
	public void customerPrint(String userName)
	{
		Customers c = currentCustomers.get(userName.toUpperCase());
		c.printCustomer();
	}
	
}
