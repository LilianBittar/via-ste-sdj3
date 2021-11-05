/*
 * 12.09.2018 Original version
 */


package tier1;


import common.ClientRemoteInterface;
import common.ITier2;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Tier1 implements ClientRemoteInterface
{
	private int accountNumber;

	public Tier1(){
		this.accountNumber = 4711;
		try {
			UnicastRemoteObject.exportObject(this, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	// Just a simple test driver. Should be client
	
	public static void main( String[] args )
	{
		try {
			Tier1 tier1 = new Tier1();
			ITier2 tier2 = (ITier2) Naming.lookup(ITier2.T2_SERVICE_NAME );
			double amount = 853.17;
			tier2.subscribe(tier1);
			while( tier2.withdraw( 4711, amount ) ) System.out.println( "Withdrawn: " + amount );
			System.out.println("Login as administrator: " + tier2.login("sally@gmail.com","miaw"));
			System.out.println("First available clerk: " + tier2.GetFirstAvailableClerk().getName());
			System.out.println("number of customers: " + tier2.getNumberOfCustomers());
			tier2.desubscribe(tier1);
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateBalance(int newBalance) throws RemoteException {
		System.out.println("NewBalance: " + newBalance);
	}

	@Override
	public int getClientAccountNumber() throws RemoteException {
		return accountNumber;
	}

}
