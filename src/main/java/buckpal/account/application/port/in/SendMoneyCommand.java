package buckpal.account.application.port.in;

import buckpal.account.domain.common.AccountId;
import buckpal.account.domain.common.Money;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class SendMoneyCommand {
	@NonNull
	private final AccountId sourceAccountId;
	@NonNull
	private final AccountId targetAccountId;
	@NonNull
	private final Money money;

	public SendMoneyCommand(final AccountId sourceAccountId, final AccountId targetAccountId, final Money money) {
		requireGreaterThan(money, Money.ZERO);
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.money = money;
	}

	//TODO:andrii.loboda:2020-05-02: builder but with validation
	private void requireGreaterThan(final Money money, final Money baseline) {
		if (money.getValue().compareTo(baseline.getValue()) <= 0) {
			throw new IllegalArgumentException(
					String.format("Passed money: %s should be more than %s", money, baseline)
			);
		}
	}
}
