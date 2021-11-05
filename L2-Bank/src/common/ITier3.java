/*
 * 12.09.2018 Original version
 */


package common;


import model.Account;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier3
	extends Remote
{
	 Account getAccount( int accountNumber ) throws RemoteException;
	
	 void updateAccount( Account account ) throws RemoteException;

	 String T3_SERVICE_NAME = "rmi://localhost/T3";
}
