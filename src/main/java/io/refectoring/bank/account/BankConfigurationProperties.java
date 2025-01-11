package io.refectoring.bank.account;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "bank")
public class BankConfigurationProperties {
    private long transferThreshold = Long.MAX_VALUE;
}
