package buckpal.account.domain;

import buckpal.account.domain.common.AccountId;
import buckpal.account.domain.common.Money;

import java.util.LinkedList;
import java.util.List;

public class ActivityWindow {
	private final List<Activity> activities = new LinkedList<>();

	public Money calculateBalance(final AccountId id) {
		return null;
	}

	public void addActivity(final Activity activity) {
		this.activities.add(activity);
	}
}
