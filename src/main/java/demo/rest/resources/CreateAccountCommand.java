package demo.rest.resources;

import demo.services.domain.accounts.AccountType;
import lombok.Data;

import java.util.List;

@Data
public class CreateAccountCommand {
    private AccountType type;
    private List<String> ownerIds;
}
