package io.refectoring.bank.account.adaptor.in.web;

import io.refectoring.bank.account.application.port.in.SendMoneyCommand;
import io.refectoring.bank.account.application.port.in.SendMoneyUseCase;
import io.refectoring.bank.account.domain.Account;
import io.refectoring.bank.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static io.refectoring.bank.account.domain.Account.*;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    void setSendMoneyUseCase(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }
}
