package com.ludiStudy.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipRepositoryImpl implements MembershipRepository{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my work: adding a membership account");
    }
}
