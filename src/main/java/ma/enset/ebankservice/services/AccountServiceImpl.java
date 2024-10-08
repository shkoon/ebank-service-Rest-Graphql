package ma.enset.ebankservice.services;

import ma.enset.ebankservice.dto.BankAccountRequestDto;
import ma.enset.ebankservice.dto.BankAccountResponseDto;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.mappers.AccountMapper;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {

        BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString())
                .currency("CHF")
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType()).build();
        BankAccount savedAccount=bankAccountRepository.save(bankAccount);


        return accountMapper.fromBankAccount(savedAccount);
    }

    @Override
    public BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=BankAccount.builder().id(id)
                .currency("CHF")
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType()).build();
        BankAccount savedAccount=bankAccountRepository.save(bankAccount);


        return accountMapper.fromBankAccount(savedAccount);
    }
    @Override
    public void deleteAccount(String id) {
         bankAccountRepository.deleteById(id);
    }


}
