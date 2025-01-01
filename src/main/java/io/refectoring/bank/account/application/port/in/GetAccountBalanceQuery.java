package io.refectoring.bank.account.application.port.in;

import io.refectoring.bank.account.domain.Account;
import io.refectoring.bank.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);
}
