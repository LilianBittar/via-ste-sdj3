/*
 * 12.09.2018 Original version
 */


package common;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ITier2
	extends Remote
{
	 boolean withdraw( int accountNumber, double amount ) throws RemoteException;
	
	
	 String T2_SERVICE_NAME = "rmi://localhost/T2";
}
