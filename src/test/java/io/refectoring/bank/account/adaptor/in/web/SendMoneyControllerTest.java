package io.refectoring.bank.account.adaptor.in.web;

import io.refectoring.bank.account.application.port.in.SendMoneyCommand;
import io.refectoring.bank.account.application.port.in.SendMoneyUseCase;
import io.refectoring.bank.account.domain.Account;
import io.refectoring.bank.account.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static io.refectoring.bank.account.domain.Account.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SendMoneyController.class)
class SendMoneyControllerTest {

    @MockitoBean
    private SendMoneyUseCase sendMoneyUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSendMoney() throws Exception {
        // given
        ArgumentCaptor<SendMoneyCommand> commandCaptor
                = ArgumentCaptor.forClass(SendMoneyCommand.class);

        // when
        mockMvc.perform(post("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}",
                41L, 42L, 500)
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());

        // then
        verify(sendMoneyUseCase).sendMoney(commandCaptor.capture());
        SendMoneyCommand command = commandCaptor.getValue();

        assertThat(command.getSourceAccountId()).isEqualTo(new AccountId(41L));
        assertThat(command.getTargetAccountId()).isEqualTo(new AccountId(42L));
        assertThat(command.getMoney()).isEqualTo(Money.of(500L));
    }
}