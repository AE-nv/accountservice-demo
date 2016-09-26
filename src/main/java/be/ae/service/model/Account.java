package be.ae.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(
            name = Account.FIND_ALL,
            query = "select account from Account account"
        )
    })
public class Account {

    public static final String FIND_ALL = "Account.findAll";

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String label;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private String iban;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "BALANCE_EUR"))
    private MoneyAmount balance;

    @ElementCollection
    private List<String> ownerIds;

    public Account(AccountType type, List<String> ownerIds) {
        this.label = generateLabel(type);
        this.type = type;
        this.iban = generateIban();
        this.balance = new MoneyAmount(BigDecimal.ZERO, Currency.getInstance("EUR"));
        this.ownerIds = ownerIds;
    }

    private String generateLabel(AccountType type) {
        switch (type) {
            case CHECKING:
                return "mijn zichtrekening";
            case SAVINGS:
                return "mijn spaarrekening";
            default:
                return "mijn rekening";
        }
    }

    private String generateIban() {
        return "new iban generated";
    }
}
