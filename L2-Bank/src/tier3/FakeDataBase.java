package tier3;

import model.Account;
import model.Adminstrator;
import model.Clerk;

import java.util.ArrayList;
import java.util.List;


public class FakeDataBase  implements DAO{

    private Account account4711 = new Account(4711, 5321.46);
    private List<Adminstrator> adminstrators = new ArrayList<>();
    private ArrayList<Clerk> clerks = new ArrayList<>();


    public FakeDataBase(){
        adminstrators.add(new Adminstrator("sally@gmail.com","miaw"));
        adminstrators.add(new Adminstrator("nar@gmail.com","123"));
        clerks.add(new Clerk("Dino", true));
        clerks.add(new Clerk("Vino", false));
    }



    public Account getAccount(int accountNumber)
             {
        if (accountNumber == 4711)
            return account4711;
        else
            return null;
    }

    @Override
    public void updateAccount(Account account) {
        if (account.getNumber() == 4711) account4711 = account;
    }

    public Adminstrator getAdminstrator(String email, String password){
           for(Adminstrator adminstrator : adminstrators) if (adminstrator.getEmail().equals(email) && adminstrator.getPassword().equals(password)) return adminstrator;
           return null;
    }

    @Override
    public ArrayList<Clerk> getAllClerk() {
        return clerks;
    }

}
