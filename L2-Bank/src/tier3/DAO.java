package tier3;

import model.Account;
import model.Adminstrator;
import model.Clerk;

import java.util.ArrayList;


public interface DAO {

    Account getAccount(int accountNumber);
    void updateAccount(Account account);
    Adminstrator getAdminstrator(String email, String password);
    ArrayList<Clerk> getAllClerk();
}
