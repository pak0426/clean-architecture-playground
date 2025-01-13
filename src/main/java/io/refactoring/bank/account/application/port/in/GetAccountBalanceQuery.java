package io.refactoring.bank.account.application.port.in;

import io.refactoring.bank.account.domain.Account;
import io.refactoring.bank.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);
}
