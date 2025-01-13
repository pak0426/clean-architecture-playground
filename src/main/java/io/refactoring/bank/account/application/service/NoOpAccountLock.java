package io.refactoring.bank.account.application.service;

import io.refactoring.bank.account.application.port.out.AccountLock;
import io.refactoring.bank.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {
    @Override
    public void lockAccount(Account.AccountId accountId) {
        // do noting
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        // do noting
    }
}
