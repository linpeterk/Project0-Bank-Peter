package Bank;


//import java.util.Scanner;

public class Main {
	static Database bank;

	
	static void  initalize()
	{
		bank = new Database();
		
		Serialize.serializeCustomerIn(); //Get Customers data from file
		Serialize.serializeAppIn(); //Get Applicants data from file
		Serialize.serializeEmployeeIn(); //Get Employees data from file
		
		bank.newAdmin("admin", "a12345", 100);	
	/*
		bank.newCustomer("Tenny", "a12345", 2, 600);
		bank.newCustomer("tom", "a12345", 1, 700);
		bank.newCustomer("Mary", "a12345", 3, 800);
		bank.newCustomer("Ken", "a12345", 3, 800);
		
		bank.application("Peter", "a12345", 3, 2);
		bank.application("Ean", "a12345", 1, 100);
		bank.application("Harry", "a12345", 2, 1000);
			
		bank.newEmployee("pogo", "a12345", 1);
		bank.newEmployee("manny", "a12345", 1);
		bank.newEmployee("lori", "a12345", 1);		
		*/
		
		//NEW COMMENTS
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		initalize();
		
		Menu menu = new Menu();
	
		menu.welcomeScreen();
		
		Serialize.serializeOut((Object) Database.currentCustomers, Serialize.customersPath); // write customers to file
		Serialize.serializeOut((Object) Database.appCustomers, Serialize.appPath); //write applicants to file
		Serialize.serializeOut((Object) Database.employees, Serialize.employeePath); //write employees to file
		
		
	}

}
