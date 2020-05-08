package buckpal.account.application.port.out;

import buckpal.account.domain.Account;

public interface UpdateAccountStatePort {

	void updateAccount(Account account);
}
