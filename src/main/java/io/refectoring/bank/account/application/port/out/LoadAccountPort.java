package io.refectoring.bank.account.application.port.out;

import io.refectoring.bank.account.domain.Account;
import io.refectoring.bank.account.domain.Account.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baseLineDate);
}
