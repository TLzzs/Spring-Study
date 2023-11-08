package com.ludiStudy.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my work: adding an account");
    }
}
