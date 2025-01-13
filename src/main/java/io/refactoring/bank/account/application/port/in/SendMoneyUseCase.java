package io.refactoring.bank.account.application.port.in;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand command);
}
