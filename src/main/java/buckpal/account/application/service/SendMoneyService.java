package buckpal.account.application.service;

import buckpal.account.application.port.in.SendMoneyCommand;
import buckpal.account.application.port.in.SendMoneyUseCase;
import buckpal.account.application.port.out.LoadAccountPort;
import buckpal.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Transactional //TODO:andrii.loboda:2020-05-07: make transactional
public class SendMoneyService implements SendMoneyUseCase {
	private final LoadAccountPort loadAccountPort;
	private final UpdateAccountStatePort updateAccountStatePort;

	@Override
	public boolean sendMoney(SendMoneyCommand command) {
		//TODO:andrii.loboda:2020-05-02: validate business rules
		//TODO:andrii.loboda:2020-05-02: manipulate model
		//TODO:andrii.loboda:2020-05-02: return output
		return true;
	}
}
