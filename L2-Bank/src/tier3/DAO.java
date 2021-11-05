package tier3;

import model.Account;

public interface DAO {

    Account getAccount(int accountNumber);
    void updateAccount(Account account);
}
