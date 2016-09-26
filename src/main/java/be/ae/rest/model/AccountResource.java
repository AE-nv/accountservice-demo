package be.ae.rest.model;

import be.ae.service.model.AccountType;
import be.ae.service.model.MoneyAmount;
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