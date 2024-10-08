package ma.enset.ebankservice.services;


import ma.enset.ebankservice.dto.BankAccountRequestDto;
import ma.enset.ebankservice.dto.BankAccountResponseDto;

public interface AccountService {

     BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
     BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto);
     void deleteAccount(String id);
}
