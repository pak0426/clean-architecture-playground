package io.refactoring.bank.common;

import io.refactoring.bank.account.adapter.out.persistence.AccountMapper;
import io.refactoring.bank.account.adapter.out.persistence.AccountPersistenceAdapter;
import io.refactoring.bank.account.adapter.out.persistence.ActivityRepository;
import io.refactoring.bank.account.adapter.out.persistence.SpringDataAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class PersistenceAdapterConfiguration {

    @Bean
    AccountPersistenceAdapter accountPersistenceAdapter(
            SpringDataAccountRepository accountRepository,
            ActivityRepository activityRepository,
            AccountMapper accountMapper) {

        return new AccountPersistenceAdapter(
                accountRepository,
                activityRepository,
                accountMapper
        );
    }

    @Bean
    AccountMapper accountMapper() {
        return new AccountMapper();
    }
}
