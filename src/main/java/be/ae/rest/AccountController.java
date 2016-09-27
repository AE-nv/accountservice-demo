package be.ae.rest;

import be.ae.rest.model.AccountResource;
import be.ae.rest.model.CreateAccountCommand;
import be.ae.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountResource>> list() {
        final List<AccountResource> accounts = accountService.getAccounts();
        return ResponseEntity.ok(accounts);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<AccountResource> get(@PathVariable String id) {
        final AccountResource accountResource = accountService.get(id);
        return ResponseEntity.ok(accountResource);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody CreateAccountCommand createAccountCommand) {
        final String id = accountService.create(createAccountCommand);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}