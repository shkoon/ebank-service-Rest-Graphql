package ma.enset.ebankservice;

import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.entities.Customer;
import ma.enset.ebankservice.enums.AccountType;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import ma.enset.ebankservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args->{

            Stream.of("Mohammed","Yassine","Imane","Hanaz").forEach(c->{
                Customer customer=Customer.builder().name(c).build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(Math.random()*90000)
                            .createdAt(new Date())
                            .currency("Dh")
                            .customer(customer).build();
                    bankAccountRepository.save(bankAccount);

                }
            });
            };
    }

}
