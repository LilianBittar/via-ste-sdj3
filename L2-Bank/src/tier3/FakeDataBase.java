package tier3;

import model.Account;

import java.rmi.RemoteException;

public class FakeDataBase  implements DAO{

    private Account account4711 = new Account(4711, 5321.46);
    public Account getAccount(int accountNumber)
             {
        if (accountNumber == 4711)
            return account4711;
        else
            return null;
    }

    @Override
    public void updateAccount(Account account) {
        if (account.getNumber() == 4711)
            account4711 = account;
        System.out.println("account #4711 balance=" + account4711.getBalance());
    }
}
