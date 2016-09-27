package be.ae.services.repositories;

import be.ae.services.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AccountRepository {

    //TODO

    public AccountRepository() {
    }

    public List<Account> getAccounts() {
        //TODO
        return null;
    }

    public Account getById(String id) {
        //TODO
        return null;
    }

    public void delete(Account account) {
        //TODO
    }

    public void save(Account account) {
        //TODO
    }
}