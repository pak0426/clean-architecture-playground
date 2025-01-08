package io.refectoring.bank.account.application.service;

import io.refectoring.bank.account.application.port.out.AccountLock;
import io.refectoring.bank.account.domain.Account;
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
