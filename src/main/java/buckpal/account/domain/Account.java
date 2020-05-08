package buckpal.account.domain;

import java.time.LocalDateTime;

public class Account {
	private AccountId id;
	private Money baselineBalance;
	private ActivityWindow activityWindow;

	public Money calculateBalance() {
		return Money.add(this.baselineBalance,
				this.activityWindow.calculateBalance(this.id)
		);
	}

	public boolean withdraw(final Money money, final AccountId targetAccountId) {
		if (!mayWithdraw(money)) {
			return false;
		}
		final Activity withdrawal = new Activity(this.id, this.id, targetAccountId, LocalDateTime.now(), money);

		this.activityWindow.addActivity(withdrawal);
		return true;
	}

	private boolean mayWithdraw(Money money) {
		return Money.add(this.calculateBalance(), money.negate()).isPositive();
	}

	public boolean deposit(final Money money, AccountId sourceAccountId) {
		final Activity deposit = new Activity(this.id, sourceAccountId, this.id, LocalDateTime.now(), money);

		this.activityWindow.addActivity(deposit);

		return true;
	}
}
