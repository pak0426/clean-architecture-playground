package io.refectoring.bank.account.application.in;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);
}
