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
	public void updateAccount(Account account) {
		accountRepo.put(account.getId(), account);
	}

	@Override
	public Account loadAccount(AccountId id) {
		return accountRepo.get(id);
	}
}
