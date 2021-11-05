/*
 * 12.09.2018 Original version
 */


package tier2;

import common.ClientRemoteInterface;
import common.ITier2;
import common.ITier3;
import model.Account;
import model.Adminstrator;
import model.Clerk;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Tier2Controller
	extends UnicastRemoteObject
	implements ITier2
{
	private ITier3 tier3;
	private ArrayList<ClientRemoteInterface> listeningClients;

	public Tier2Controller()
		throws RemoteException
	{
		try {
			Naming.rebind( T2_SERVICE_NAME, this );
			tier3 = (ITier3) Naming.lookup(ITier3.T3_SERVICE_NAME );
			listeningClients = new ArrayList<>();
		} catch( Exception ex ) {
			ex.printStackTrace();
			System.exit( 1 );
		}
	}
	
	
	public boolean withdraw( int accountNumber, double amount )
		throws RemoteException
	{
		Account account = tier3.getAccount( accountNumber );
		
		if( account == null )
			return false;
		else if( amount <= 0.0 || amount > account.getBalance() )
			return false;
		else {
			account.updateBalance( -amount );
			tier3.updateAccount( account );
			for(ClientRemoteInterface client: listeningClients) if (client.getClientAccountNumber() == accountNumber) {
				client.updateBalance((int) account.getBalance());
				break;
			}
			return true;
		}
	}

	public boolean login(String email, String password)
		throws RemoteException
	{
		Adminstrator adminstrator = tier3.getAdminstrator(email,password);
		return adminstrator != null;
	}

	public Clerk GetFirstAvailableClerk()
	throws RemoteException
	{
		ArrayList<Clerk> clerks = tier3.getAllClerk();
       for(Clerk clerk: clerks) if(clerk.isAvailable()) return clerk;
	   return null;
	}

	@Override
	public int getNumberOfCustomers() throws RemoteException {
		return tier3.getNumberOfCustomers();
	}

	@Override
	public void subscribe(ClientRemoteInterface client) throws RemoteException {
		 listeningClients.add(client);
	}

	@Override
	public void desubscribe(ClientRemoteInterface client) throws RemoteException {
		listeningClients.remove(client);
	}


}
