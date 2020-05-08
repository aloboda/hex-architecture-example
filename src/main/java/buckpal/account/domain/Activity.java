package buckpal.account.domain;

import buckpal.account.domain.common.AccountId;
import buckpal.account.domain.common.Money;

import java.time.LocalDateTime;

public class Activity {
	public Activity(AccountId accountId, final AccountId sourceAccountId, final AccountId targetAccountId, final LocalDateTime transactionTime, final Money valueChange) {

	}
}
