package buckpal.account.adapter.out.persistence;

import buckpal.account.application.port.out.LoadAccountPort;
import buckpal.account.application.port.out.UpdateAccountStatePort;
import buckpal.account.domain.Account;

public class AccountPersistenceAdapter implements UpdateAccountStatePort, LoadAccountPort {
	@Override
	public void updateAccount(Account account) {
		throw new UnsupportedOperationException();
	}
}
