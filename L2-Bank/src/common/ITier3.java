/*
 * 12.09.2018 Original version
 */


package common;


import model.Account;
import model.Adminstrator;
import model.Clerk;
import model.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ITier3
	extends Remote
{
	 Account getAccount( int accountNumber ) throws RemoteException;

	 Adminstrator getAdminstrator(String email, String password) throws RemoteException;
	
	 void updateAccount( Account account ) throws RemoteException;

	 ArrayList<Clerk> getAllClerk() throws RemoteException;

	 int getNumberOfCustomers() throws RemoteException;

	 String T3_SERVICE_NAME = "rmi://localhost/T3";
}
