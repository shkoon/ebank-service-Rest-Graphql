package ma.enset.ebankservice.web;

import lombok.AllArgsConstructor;
import ma.enset.ebankservice.dto.BankAccountRequestDto;
import ma.enset.ebankservice.dto.BankAccountResponseDto;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.repositories.BankAccountRepository;

import ma.enset.ebankservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public  BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto bankAccount){

        return accountService.addAccount(bankAccount);
    }


    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Found"));
        if(bankAccount.getBalance()!=null)
        account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAt()!=null)
        account.setCreatedAt(bankAccount.getCreatedAt());
        if(bankAccount.getType()!=null)
        account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)
        account.setCurrency(bankAccount.getCurrency());

        return  bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }



}
