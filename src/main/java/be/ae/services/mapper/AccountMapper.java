package be.ae.services.mapper;

import be.ae.rest.model.AccountResource;
import be.ae.services.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    public AccountMapper() {
    }

    public List<AccountResource> map(List<Account> accounts) {
        List<AccountResource> resources = new ArrayList<>();

        for (Account account : accounts) {
            resources.add(map(account));
        }
        return resources;
    }

    public AccountResource map(Account account) {
        AccountResource resource = new AccountResource();

        //TODO

        return resource;
    }
}
