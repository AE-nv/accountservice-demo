package be.ae.rest.model;

import be.ae.services.model.AccountType;
import lombok.Data;

import java.util.List;

@Data
public class CreateAccountCommand {
    private AccountType type;
    private List<String> ownerIds;
}
