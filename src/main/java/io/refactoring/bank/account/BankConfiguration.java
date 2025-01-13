package io.refactoring.bank.account;

import io.refactoring.bank.account.application.service.MoneyTransferProperties;
import io.refactoring.bank.account.domain.Money;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class BankConfiguration {
    @Bean
    public MoneyTransferProperties moneyTransferProperties(BankConfigurationProperties bankConfigurationProperties) {
        return new MoneyTransferProperties(Money.of(bankConfigurationProperties.getTransferThreshold()));
    }
}
