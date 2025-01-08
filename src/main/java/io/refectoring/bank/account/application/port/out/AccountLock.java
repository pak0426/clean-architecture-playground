package io.refectoring.bank.account.application.port.out;

import io.refectoring.bank.account.domain.Account;

import static io.refectoring.bank.account.domain.Account.*;

public interface AccountLock {
    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);
}
