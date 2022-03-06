package Bank;

import java.util.Scanner;

public class LoginVerification {
	
		String name;
		String password;
		Scanner scan;
		
		public LoginVerification(Scanner scan) {
			this.scan = scan;
		}

	public  String enterUserName() {
		
		System.out.println("Please Enter a User Name");
		if(scan.hasNext()){
			name = scan.nextLine(); //exception check later
		}
		else {
			System.out.println("There's nothing in scanner, error");
		}
		return name;

}

public  String enterPassword() {

	do {
		System.out.println("Please Enter a Password with at least 5 characters or digits");
		password = scan.nextLine();
	
		if(password.length()>4) 
		{
			break;
		}
		else 
		{
			System.out.println("Password too short, please try again");

		}
	}while(password.length()<5);
	
	return password;

	}

public Customers customerloginVer()
{		
	boolean verified = false;

	//verify credential matches, try again if not
	while(!verified)
	{

	
		 name = enterUserName();
		 password = enterPassword();
		if ((verified = Database.customerVerify(name, password)) == false)
		{
			System.out.println("Credential you provided don't match, please try again");
			System.out.println();
		}
		
	}
	
	
	System.out.println("Login Success, Welcome " + name + " !");
	
		return Database.findCustomers(name);

 }

	public Employees employeeloginVer()
	{		
		boolean verified = false;
	//verify credential matches, try again if not
		while(!verified)
		{
	
			name = enterUserName();
			password = enterPassword();
			if ((verified = Database.employeeExist(name, password)) == false)
			{
			System.out.println("Credential you provided don't match, please try again");
			System.out.println();
			}
		
		}
	
	
		System.out.println("Login Success, Welcome " + name + " !");
	
		return Database.findEmployees(name);

	}
	
	public int employeesType(Employees e)
	{		
	//	Admins admin = new Admins(null, null, 0);
	//	Employees employee = new Employees(null, null, 0);
		if(e instanceof Admins)
		{
			return Menu.ADMINS;
		}
		else if(e instanceof Employees)
		{
			return Menu.EMPLOYEES;
		}
		return 0; //no employees found
	}

}
