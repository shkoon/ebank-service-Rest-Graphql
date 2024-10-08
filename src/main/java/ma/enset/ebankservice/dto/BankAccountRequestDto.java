package ma.enset.ebankservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ebankservice.enums.AccountType;

@Data@NoArgsConstructor@AllArgsConstructor@Builder

public class BankAccountRequestDto {
    private Double balance;
    private String currency;
    private AccountType type;
}
