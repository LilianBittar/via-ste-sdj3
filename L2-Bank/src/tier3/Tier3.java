/*
 * 12.09.2018 Original version
 */


package tier3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Tier3
{
	public static void main( String[] args ) throws RemoteException {
		LocateRegistry.createRegistry(1099);
		try {
			Tier3Controller controller = new Tier3Controller(new FakeDataBase());
			
			System.out.println( "Tier3 ready" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
