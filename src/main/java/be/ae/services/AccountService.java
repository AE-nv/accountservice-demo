package be.ae.services;

import be.ae.rest.model.AccountResource;
import be.ae.rest.model.CreateAccountCommand;
import be.ae.services.exceptions.BusinessException;
import be.ae.services.exceptions.ErrorCode;
import be.ae.services.mapper.AccountMapper;
import be.ae.services.model.Account;
import be.ae.services.repositories.AccountRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private EntityLinks entityLinks;

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
        if (!isValidCreateAccountCommand(command)) {
            throw new BusinessException(ErrorCode.MISSING_CREATE_ACCOUNT_INFORMATION);
        }
        final Account account = new Account(command.getType(), command.getOwnerIds());
        accountRepository.save(account);
        return account.getId();
    }

    private boolean isValidCreateAccountCommand(@RequestBody CreateAccountCommand createAccountCommand) {
        return createAccountCommand.getType() != null && createAccountCommand.getOwnerIds() != null && !createAccountCommand.getOwnerIds().isEmpty();
    }

    public void delete(String id) {
        Account account = accountRepository.getById(id);
        accountRepository.delete(account);
    }
}