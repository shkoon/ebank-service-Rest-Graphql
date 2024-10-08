package ma.enset.ebankservice.web;


import lombok.AllArgsConstructor;
import ma.enset.ebankservice.dto.BankAccountRequestDto;
import ma.enset.ebankservice.dto.BankAccountResponseDto;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.entities.Customer;
import ma.enset.ebankservice.mappers.AccountMapper;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import ma.enset.ebankservice.repositories.CustomerRepository;
import ma.enset.ebankservice.services.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller@AllArgsConstructor
public class BankAcoountGraphQlController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount getAccount(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not Found"));   }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount){
        return  accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id,@Argument BankAccountRequestDto bankAccount){
        return  accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
          accountService.deleteAccount(id);
          return true;
    }

    @QueryMapping
    public List<Customer> customersList(){
        return customerRepository.findAll();
    }

   /* record BankAccountDTO(Double balance,String currency,String type){

    }*/
}


