/*
 * 12.09.2018 Original version
 */


package tier3;


import common.ITier3;
import model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Tier3Controller
        extends UnicastRemoteObject
        implements ITier3 {

    private DAO dao;

    public Tier3Controller(DAO dao)
            throws RemoteException {
        this.dao = dao;
        try {
            Naming.rebind(T3_SERVICE_NAME, this);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public Account getAccount(int accountNumber) throws RemoteException {
        return dao.getAccount(accountNumber);
    }

    public void updateAccount(Account account)
            throws RemoteException {
       dao.updateAccount(account);
    }
}
