package tier3;

import model.Account;
import model.Adminstrator;

public interface DAO {

    Account getAccount(int accountNumber);
    void updateAccount(Account account);
    Adminstrator getAdminstrator(String email, String password);
}
