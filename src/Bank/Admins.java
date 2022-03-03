package Bank;

import java.util.Map;

public class Admins extends Employees implements java.io.Serializable{

	//constructor
	public Admins(String userName, String password, int access) {
		super(userName, password, access);
		// TODO Auto-generated constructor stub
	}
	
	//print all employees on record
	public void listAllEmployees()
	{	
			if(Database.employees.size() == 0)
			{
				System.out.println("No Employees");
			}
			//loop through map, print it
			for(Map.Entry m: Database.employees.entrySet())
				{
					String userName, password;
					int access;

					userName = ((Employees) m.getValue()).getUserName();
					password = ((Employees) m.getValue()).getPassword();
					access = ((Employees) m.getValue()).getaccessLevel();
		
					System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " + access);
				}
				
	}
}
