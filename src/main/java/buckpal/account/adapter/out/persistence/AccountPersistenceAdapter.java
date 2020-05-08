package buckpal.account.adapter.out.persistence;

import buckpal.account.application.port.out.LoadAccountPort;
import buckpal.account.application.port.out.UpdateAccountStatePort;
import buckpal.account.domain.Account;
import buckpal.account.domain.common.AccountId;

import java.util.HashMap;
import java.util.Map;

class AccountPersistenceAdapter implements UpdateAccountStatePort, LoadAccountPort {
	private final Map<AccountId, Account> accountRepo = new HashMap<>();

	@Override
	public void updateAccount(final Account account) {
		this.accountRepo.put(account.getId(), account);
	}

	@Override
	public Account loadAccount(final AccountId id) {
		return this.accountRepo.get(id);
	}
}
