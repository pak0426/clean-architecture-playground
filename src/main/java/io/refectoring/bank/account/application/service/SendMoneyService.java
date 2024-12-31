package io.refectoring.bank.account.application.service;

import io.refectoring.bank.account.application.in.SendMoneyCommand;
import io.refectoring.bank.account.application.in.SendMoneyUseCase;
import io.refectoring.bank.account.application.out.AccountLock;
import io.refectoring.bank.account.application.out.LoadAccountPort;
import io.refectoring.bank.account.application.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;


    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // TODO: 비즈니스 규칙 검증
        // TODO: 모델 상태 조작
        // TODO: 출력 값 반환
        return false;
    }
}
