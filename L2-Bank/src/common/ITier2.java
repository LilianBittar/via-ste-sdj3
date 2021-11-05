/*
 * 12.09.2018 Original version
 */


package common;


import model.Clerk;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier2
	extends Remote
{
	 boolean withdraw( int accountNumber, double amount ) throws RemoteException;
	boolean login( String email, String password) throws RemoteException;
	Clerk GetFirstAvailableClerk() throws RemoteException;
	int getNumberOfCustomers() throws RemoteException;
	void subscribe(ClientRemoteInterface client) throws RemoteException;
	void desubscribe(ClientRemoteInterface client) throws RemoteException;

	 String T2_SERVICE_NAME = "rmi://localhost/T2";
}
