package Bank;

import java.util.Scanner;

public class Menu {
	
	public String name;
	public String password;
	public int accountType;
	public double balance;
	
	public final static int ADMINS = 100; //ID for admins
	public final static int EMPLOYEES = 1; //ID for employees
			
	Database data;
	Scanner scan;
	LoginVerification veri;
	MenuCustomers menuC;
	
	//constructor
	public Menu(){
		data = new Database();
		scan = new Scanner(System.in);
		veri = new LoginVerification();
		menuC = new MenuCustomers();
	}
	
	//Starts new customer applications into map appCustomers
	public void startApplication()
	{		
	
		System.out.println("Welcome New Customer");
	do {
		name = veri.enterUserName();
		
		if(Database.appVerify(name)&&Database.customerVerify(name)) //Check name not taken 
		{
			
			System.out.println("User name is taken, try another user name");
		}
		else {
		//	System.out.println("name is good");
		}
	}while(Database.appVerify(name)); //loop until a valid and un-taken name is inputted
		
		password = veri.enterPassword();
		accountType = menuC.pickAccountType();
		balance = menuC.depositBalance();
	
		Main.bank.application(name, password, accountType, balance); //construct and add new applications to map appCustomer
		data.appPrint(name);
		System.out.println("Application successful!");
		System.out.println("Your application is in review, thank you for choosing us and we will get back to you shortly");
		
		
	}
	
	//Employees menu - Print all the customers on record currentCustomers 
	public void viewAllCustomerMenu(Employees e)
	{		
		e.listAllCustomer();
	}
	
	//Employees menu - Find customer given input name, print it
	public void searchCustomerMenu(Employees e)
	{		
		System.out.println("Please Enter Customer's Name");
		name = scan.nextLine();
		e.searchCustomer(name);
	}
	
	//Admin menu - Find customers, print it, and allow customers function such as deposit, withdrawal, and transfer
	public void searchCustomerMenu(Employees e, int i)
	{		
		System.out.println("Please Enter Customer's Name");
		name = scan.nextLine();
		Customers findCustomer = e.searchCustomer(name);
		if(findCustomer != null)
		{
			customerOptions(findCustomer); //Go into customer menu 
		}
	}
	
	//Employee function - Accept or deny applicants in appCustomers
	public void acceptDenyApplicantMenu(Employees e)
	{		
		e.listAllApplicant(); //List all applicants in file
		Customers c;
		System.out.println("Enter Applicant's Name");
		if(scan.hasNext())
		{
			name = scan.nextLine();
			if(!Database.appVerify(name)) //Check customer existed
			{
				System.out.println("No Applicant Found");
				return;
			}
			c=Database.findApplicant(name); //save customer object to c
		}
		else {
			System.out.println("Scanner Error");
			return;
		}
		
		c.printCustomer(); 
		int choice = 1000;
		System.out.println("Accept or Deny?");
		System.out.println("1. Accept");
		System.out.println("2. Deny?");
		if(scan.hasNextInt())
		{
			choice = scan.nextInt();
			scan.nextLine();//clear buffer
			if(choice==1) //Accepts Customer
			{
				System.out.println("Applicant " + c.getUserName()+ " Accepted!");
				e.acceptApplicants(name);				
			}
			else if(choice ==2) { //Delete Customer
				System.out.println("Applicant " + c.getUserName()+ " Denied!");
				e.denyApplicants(name);
			}
			else {
				System.out.println("Denied: Invalid Number");
				return;
			}
			
		}

	}
	
	/*
	 * Employee Menu Selection
	 * View all customers print all customers on currentCustomer
	 * Search Account prints one specific customer given a name
	 * Approve or denying applicants
	 */
	public void employeeMenu(Employees e)
	{
		int choice = 0;
		System.out.println();
		System.out.println("*********** EMPLOYEE MENU *************");
		System.out.println("Please select the following options");
		System.out.println("1. View All Customers");
		System.out.println("2. Search Account");
		System.out.println("3. Approve/Deny Applications");
		System.out.println("0. EXIT");
		System.out.println("*********** EMPLOYEE MENU *************");
		
		if(scan.hasNextInt())
		{
			choice = scan.nextInt();
			scan.nextLine(); //clear buffer
		}
		
		switch(choice)
		{
		case 1: viewAllCustomerMenu(e); employeeMenu(e); break; 
		
		case 2: searchCustomerMenu(e); employeeMenu(e);break;
		
		case 3: acceptDenyApplicantMenu(e); employeeMenu(e); break;
		
		case 0: break;
		
		default: System.out.println("No valid selection"); employeeMenu(e);
		}
	}
	
	//Delete customer from currentCustomer, given inputted name
	public void cancelAccountMenu()
	{
		Customers c = null;
		System.out.println("Enter Applicant's Name");
		if(scan.hasNext())
		{
			name = scan.nextLine();
			if(!Database.customerVerify(name))
			{
				System.out.println("No Applicant Found");
				return;
			}
			c=Database.findCustomers(name);
		}
		else {
			System.out.println("Scanner Error");
			return;
		}
		
		System.out.println("Customer " + c.getUserName()+ " is Cancelled!");
		data.removeCustomer(name);
		
		
	}
	/*
	 * Admin Menu Selection
	 * 1.View all customers, print info only
	 * 2.Search one specific customer given a name, then allow to perform customer function
	 * 3.Approve or deny applicants
	 * 4.Delete one customer given inputted name
	 * 7.View all employees, print info only
	 * 9.Add employees given user input
	 * 0.exit menu
	 * 
	 * Parameters obtained after passing verification process, current employee.
	 */
	public void adminMenu(Employees e)
	{
		int choice = 0;
		System.out.println();
		System.out.println("************ ADMIN MENU ************");
		System.out.println("Please select the following options");
		System.out.println("1. View All Customers");
		System.out.println("2. Search and Edit Account");
		System.out.println("3. Approve/Deny Applications");
		System.out.println("4. Cancel Accounts");
		System.out.println("7. View ALL Employees");
		System.out.println("9. Add Employee");
		System.out.println("0. EXIT");
		System.out.println("************ ADMIN MENU ************");
		
		if(scan.hasNextInt())
		{
			choice = scan.nextInt();
			scan.nextLine(); //clear buffer
		}
		
		switch(choice)
		{
		case 1: viewAllCustomerMenu(e); adminMenu(e); break;
		
		case 2: searchCustomerMenu(e, 1); adminMenu(e); break;
		
		case 3: acceptDenyApplicantMenu(e); adminMenu(e); break;
		
		case 4: cancelAccountMenu(); adminMenu(e);break;
		
		case 7: ((Admins)e).listAllEmployees(); adminMenu(e);break;
		
		case 9: addEmployee(); adminMenu(e);break;
		
		case 0: break;
		
		default: System.out.println("No valid selection"); adminMenu(e);
		}
		
		
	}
	//add employee
	public void addEmployee()
	{
		Employees e = null;
		System.out.println("Enter Employee Name");
		
			name = scan.nextLine();
			
		System.out.println("Enter Employee password");	
			password = scan.nextLine();
			
			if(Database.findEmployees(name)== null)
			{
				data.newEmployee(name, password, 1);
				System.out.println("Employee "+name+" added!");
			}
			else System.out.println("Employee already exists");
		
		
		
	}
	
	/*Customer menu selection
	 * Given user input, allows withdrawl, deposit, view balance, and transfer
	 * Transfer only allows transfer to another member of this bank
	 */
	public void customerOptions(Customers c)
	{
		
		Transactions t = new Transactions(c);
		int choice = 0;
		System.out.println();
		System.out.println("*********** CUSTOMER MENU ***********");
		System.out.println("Please select the following options");
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. View Balance");
		System.out.println("4. Transfer");
		System.out.println("0. EXIT");
		System.out.println("*********** CUSTOMER MENU ***********");
		
		if(scan.hasNextInt())
		{
			choice = scan.nextInt();
			scan.nextLine(); //clear buffer
		}
		
		switch(choice)
		{
		case 1: menuC.withdrawMenu(t); customerOptions(c);break;
		
		case 2: menuC.depositMenu(t); customerOptions(c);break;
		
		case 3: menuC.viewBalanceMenu(t); customerOptions(c);break;
		
		case 4: menuC.transferMenu(t); customerOptions(c);break;
		
		case 0: break;
		
		default: System.out.println("No valid selection (withdraw/deposit/view/transfer)");
		}
	}
	
	
	
	//Determine access level of employee. 1 for regular employee, 100 for admin
	public void employeeOptions(Employees e)
	{
		int employeeType = veri.employeesType(e);
	//	Admins admin = new Admins(null, null, 0);
		switch(employeeType)
		{
			case 1: employeeMenu(e); break;
			case 100: adminMenu(e); break;
			default: System.out.println("Undeclared employee type");
		}
		
		
		
	}
	
	//Start of screen, selecting type of user
	public int welcomeScreen()
	{
		System.out.println("*****Welcome to Bank of Peter*****");
		String choice = choices();
		
		switch(choice)
		{
		case "NCustomer": //System.out.println("It's a new customer"); 
							startApplication(); welcomeScreen();return 1; 
		
		case "ECustomer": //System.out.println("It's an existing customer"); 
							customerOptions(veri.customerloginVer());; return 2;  
							/*(veri.customerLoginVer is a verification access to make sure credential match. 
							 		ONLY RETURNS OBJECT CUSTOMER IF VERIFICATION IS SUCCESSFUL;		*/
		case "Employee":  //System.out.println("It's an employee"); 
							employeeOptions(veri.employeeloginVer());	return 3;
		
		default:System.out.println("No right option selected"); return 0;
		}
		
	}
	
	public String choices()
	{	
		int input = 0;

		do {
		System.out.println("Please Enter 1 for New Customer 2 for Existing Customer 3 for Employee");
		System.out.println("1. New Customer");
		System.out.println("2. Existing Customer");
		System.out.println("3. Employee");
		if(scan.hasNextInt())
		{
		
			input = scan.nextInt();
			scan.nextLine(); //clear buffer
			//System.out.println(input);
			if(input == 1)
			{
			
				return "NCustomer";
			}
			else if(input == 2)
			{
			
				return "ECustomer";
			}
			else if(input ==3)
			{
		
				return "Employee";
			}
			else 
			{
				System.out.println("Not a valid number, please try again");
				System.out.println();
			}
		}
		else {
			System.out.println("Not a number, please enter a number");
			System.out.println();
			scan.nextLine();		
		}
		}while(input !=1 && input != 2);
		

		return "Exceptions";
	}
}
