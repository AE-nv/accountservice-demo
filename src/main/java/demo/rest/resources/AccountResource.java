package demo.rest.resources;

import demo.services.domain.accounts.AccountType;
import demo.services.domain.shared.MoneyAmount;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

@Data
public class AccountResource extends ResourceSupport {
    private String label;
    private AccountType type;
    private List<String> owners = new ArrayList<>();
    private String iban;
    private MoneyAmount balance;
}