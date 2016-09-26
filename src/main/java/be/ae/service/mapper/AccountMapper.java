package be.ae.service.mapper;

import be.ae.rest.model.AccountResource;
import be.ae.service.model.Account;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class AccountMapper {

    @Autowired
    private EntityLinks entityLinks;

    public List<AccountResource> map(List<Account> accounts) {
        List<AccountResource> resources = new ArrayList<>();

        for (Account account : accounts) {
            resources.add(map(account));
        }
        return resources;
    }

    public AccountResource map(Account account) {
        AccountResource resource = new AccountResource();
        resource.add(entityLinks.linkToSingleResource(AccountResource.class, account.getId()));
        resource.setLabel(account.getLabel());
        resource.setType(account.getType());
        resource.setOwners(account.getOwnerIds());
        resource.setIban(account.getIban());
        resource.setBalance(account.getBalance());

        return resource;
    }
}
