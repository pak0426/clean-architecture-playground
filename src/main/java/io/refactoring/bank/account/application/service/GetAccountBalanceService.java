package io.refactoring.bank.account.application.service;

import io.refactoring.bank.account.application.port.in.GetAccountBalanceQuery;
import io.refactoring.bank.account.application.port.out.LoadAccountPort;
import io.refactoring.bank.account.domain.Account.AccountId;
import io.refactoring.bank.account.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
