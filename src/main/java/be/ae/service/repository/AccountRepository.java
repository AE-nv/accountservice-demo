package be.ae.service.repository;

import be.ae.service.exceptions.UnknownResourceException;
import be.ae.service.model.Account;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@NoArgsConstructor
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Account> getAccounts() {
        return em.createNamedQuery(Account.FIND_ALL).getResultList();
    }

    public Account getById(String id) {
        final Account account = em.find(Account.class, id);
        if (account == null) {
            throw new UnknownResourceException();
        }
        return account;
    }

    public void delete(Account account) {
        em.remove(account);
    }

    public void save(Account account) {
        em.persist(account);
    }
}