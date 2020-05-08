package buckpal.account.application.service;

import buckpal.account.application.port.in.SendMoneyCommand;
import buckpal.account.application.port.in.SendMoneyUseCase;
import buckpal.account.application.port.out.LoadAccountPort;
import buckpal.account.application.port.out.UpdateAccountStatePort;
import buckpal.account.domain.Account;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Transactional //TODO:andrii.loboda:2020-05-07: make transactional
public class SendMoneyService implements SendMoneyUseCase {
	private final LoadAccountPort loadAccountPort;
	private final UpdateAccountStatePort updateAccountStatePort;

	@Override
	public boolean sendMoney(SendMoneyCommand command) {
		final Account sourceAccount = loadAccountPort.loadAccount(command.getSourceAccountId());
		final Account targetAccount = loadAccountPort.loadAccount(command.getTargetAccountId());
		final boolean withdraw = sourceAccount.withdraw(command.getMoney(), targetAccount.getId());
		if (!withdraw) {
			throw new IllegalStateException(String.format("Can't withdraw from account, %s", sourceAccount));
		}
		targetAccount.deposit(command.getMoney(), sourceAccount.getId());

		updateAccountStatePort.updateAccount(sourceAccount);
		updateAccountStatePort.updateAccount(targetAccount);
		//TODO:andrii.loboda:2020-05-02: validate business rules
		//TODO:andrii.loboda:2020-05-02: manipulate model
		//TODO:andrii.loboda:2020-05-02: return output
		return true;
	}
}
