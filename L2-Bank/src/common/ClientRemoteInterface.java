package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRemoteInterface extends Remote {
    void updateBalance(int newBalance) throws RemoteException;
    int getClientAccountNumber() throws RemoteException;
}
