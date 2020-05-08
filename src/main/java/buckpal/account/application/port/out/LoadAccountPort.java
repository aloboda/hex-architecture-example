package buckpal.account.application.port.out;

import buckpal.account.domain.Account;
import buckpal.account.domain.AccountId;

public interface LoadAccountPort {
	Account loadAccount(AccountId id);
}
