package io.refactoring.bank.account.application.service;

import io.refactoring.bank.account.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferProperties {

    private Money maximumTransferThreshold = Money.of(1_000_000L);

}
