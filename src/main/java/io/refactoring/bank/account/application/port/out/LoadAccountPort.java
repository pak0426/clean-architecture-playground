package io.refactoring.bank.account.application.port.out;

import io.refactoring.bank.account.domain.Account;
import io.refactoring.bank.account.domain.Account.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baseLineDate);
}
