package Bank;

public class Transactions {

	Customers c = null;
	
	Transactions(Customers customer)
	{
		c = customer;
	}
	public boolean deposit(double depos)
	{
		if(depos<0)
		{
			System.out.println("Illegal deposit: Negative Numbers " + depos);
			return false;
		}
		c.setBalance(c.getBalance()+depos);
		System.out.println(c.getUserName() + ": Deposited " + depos);
		System.out.println(c.getUserName() + " Total balance " + c.getBalance());
		c.tranHistory.add("1"+ depos);
		return true;
	}
	
	public double viewBalance()
	{
		return c.getBalance();
	}

	public boolean withDraw(double withdrawAmount)
	{
		if(withdrawAmount<0)
		{
			System.out.println("Illegal withdrawl: Negative Numbers " + withdrawAmount);
			return false;
		}
		
		if(withdrawAmount > c.getBalance())
		{
			System.out.println("Denied: Overdrafted balance by " + Math.abs(withdrawAmount-c.getBalance()));
			return false;
		}
		else {
		
			c.setBalance(c.getBalance()-withdrawAmount);
			System.out.println(c.getUserName() +": Withdrawn " + withdrawAmount);
			System.out.println(c.getUserName() +" Total Balance " + c.getBalance());
			c.tranHistory.add("2"+ withdrawAmount);
			return true;
		}
	}
	
	//Transfer amount of balance from current customer owner to a target customer destUserName
	public boolean transfer(double amount, String destUserName)
	{
		if(amount<0)
		{
			System.out.println("Transfer failed: Negative number"); 
			return false;
		}
		if(withDraw(amount)){
			Transactions dest = new Transactions(Database.findCustomers(destUserName));
			if(dest.c == null)
			{
				System.out.println("Transfer failed: Destination UserName do not exist");
				return false;
			}
			c.tranHistory.add("3"+ destUserName + amount);
			dest.deposit(amount);
			System.out.println("Status report: Original Owner"); 
			c.printCustomer();
			System.out.println("Status report: Target"); 
			dest.c.printCustomer();
			
			
			return true;
		}
		else {
			System.out.println("Transfer failed");
			return false;
		}
	}
}
