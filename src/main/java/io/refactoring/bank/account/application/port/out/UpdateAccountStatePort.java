package io.refactoring.bank.account.application.port.out;

import io.refactoring.bank.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
