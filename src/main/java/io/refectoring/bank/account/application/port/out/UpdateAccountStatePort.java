package io.refectoring.bank.account.application.port.out;

import io.refectoring.bank.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
