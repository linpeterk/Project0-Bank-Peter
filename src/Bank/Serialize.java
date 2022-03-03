package Bank;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;


public  class Serialize {
	
	public static String customersPath = "./src/customers.ser";
	public static String appPath = "./src/applicants.ser";
	public static String employeePath = "./src/employees.ser";
	
	public static void serializeOut(Object obj, String path){
		try {
	
				FileOutputStream fileOut
					= new FileOutputStream(
							path);

				ObjectOutputStream out
				= new ObjectOutputStream(fileOut);

				out.writeObject((HashMap) obj);
				
				out.close();
				fileOut.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	
	public static void serializeCustomerIn() {
		HashMap <String, Customers>map = new HashMap<String, Customers>();
		try {
				FileInputStream fileIn
					= new FileInputStream(
							customersPath);
					
				ObjectInputStream in
				= new ObjectInputStream(fileIn);
		
					map = (HashMap<String, Customers>) in.readObject();
					Database.currentCustomers.putAll(map);
				
			//	System.out.println("Customers size = " + map.size());
				//Database.currentCustomers = map;
				
				in.close();
				fileIn.close();
				
		}
		catch(IOException e)
		{
			if(e instanceof IOException)
			{
				//do nothing 
				return;
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	public static void serializeAppIn() {
		HashMap <String, Customers>map = new HashMap<String, Customers>();
		try {
				FileInputStream fileIn
					= new FileInputStream(
							appPath);
					
				ObjectInputStream in
				= new ObjectInputStream(fileIn);
		
					map = (HashMap<String, Customers>) in.readObject();
					Database.appCustomers.putAll(map);
				
			//	System.out.println("Applicant size = " + map.size());
				//Database.currentCustomers = map;
				
				in.close();
				fileIn.close();
				
		}
		catch(IOException e)
		{
			if(e instanceof IOException)
			{
				//do nothing 
				return;
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	public static void serializeEmployeeIn() {
		HashMap <String, Employees>map = new HashMap<String, Employees>();
		try {
				FileInputStream fileIn
					= new FileInputStream(
							employeePath);
					
				ObjectInputStream in
				= new ObjectInputStream(fileIn);
		
					map = (HashMap<String, Employees>) in.readObject();
					Database.employees.putAll(map);
				
				//System.out.println("Employees size = " + map.size());
				//Database.currentCustomers = map;
				
				in.close();
				fileIn.close();
				
		}
		catch(IOException e)
		{
			if(e instanceof IOException)
			{
				//do nothing 
				return;
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
		
	
	/*
	public static void serializeCustomersOut(){
		//HashMap <String, Customers>map = new HashMap<String, Customers>();
		try {
			System.out.println("Attempting serialized");
				FileOutputStream fileOut
					= new FileOutputStream(
							customersPath);

				ObjectOutputStream out
				= new ObjectOutputStream(fileOut);
			//	map.putAll(Database.currentCustomers);
				out.writeObject(Database.currentCustomers);
				
				out.close();
				fileOut.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	*/
	
}
