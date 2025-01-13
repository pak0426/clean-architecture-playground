package io.refactoring.bank.account.application.port.out;

import static io.refactoring.bank.account.domain.Account.*;

public interface AccountLock {
    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);
}
