package be.ae.services;

import be.ae.rest.model.AccountResource;
import be.ae.rest.model.CreateAccountCommand;
import be.ae.services.mapper.AccountMapper;
import be.ae.services.model.Account;
import be.ae.services.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public AccountService() {
    }

    @Transactional(readOnly = true)
    public List<AccountResource> getAccounts() {
        final List<Account> accounts = accountRepository.getAccounts();
        return accountMapper.map(accounts);
    }

    public AccountResource get(String id) {
        Account account = accountRepository.getById(id);
        return accountMapper.map(account);
    }

    public String create(CreateAccountCommand command) {
        final Account account = new Account();//TODO instantiate correctly
        accountRepository.save(account);
        return null;//TODO return id
    }

    public void delete(String id) {
        Account account = accountRepository.getById(id);
        accountRepository.delete(account);
    }
}