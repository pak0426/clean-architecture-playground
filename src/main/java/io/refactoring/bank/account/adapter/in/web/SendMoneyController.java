package io.refactoring.bank.account.adapter.in.web;

import io.refactoring.bank.account.application.port.in.SendMoneyCommand;
import io.refactoring.bank.account.application.port.in.SendMoneyUseCase;
import io.refactoring.bank.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.refactoring.bank.account.domain.Account.*;

@Component
@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
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
