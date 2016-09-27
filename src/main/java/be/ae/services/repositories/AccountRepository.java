package be.ae.services.repositories;

import be.ae.services.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public AccountRepository() {
    }

    public List<Account> getAccounts() {
        return em.createNamedQuery(Account.FIND_ALL).getResultList();
    }

    public Account getById(String id) {
        final Account account = em.find(Account.class, id);
        return account;
    }

    public void delete(Account account) {
        em.remove(account);
    }

    public void save(Account account) {
        em.persist(account);
    }
}