package ma.enset.ebankservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.ebankservice.enums.AccountType;

import java.util.Date;
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class BankAccountResponseDto {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
