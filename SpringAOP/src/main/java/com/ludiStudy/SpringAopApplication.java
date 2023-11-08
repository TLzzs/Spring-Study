package com.ludiStudy;

import com.ludiStudy.Repository.AccountRepository;
import com.ludiStudy.Repository.MembershipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountRepository accountRepository, MembershipRepository membershipRepository){
        return runner -> {
//            System.out.println("Hello world");
            demoBeforeAdvice(accountRepository, membershipRepository);
        };

    }

    private void demoBeforeAdvice(AccountRepository accountRepository, MembershipRepository membershipRepository) {
        accountRepository.addAccount();
        membershipRepository.addAccount();
    }


}
