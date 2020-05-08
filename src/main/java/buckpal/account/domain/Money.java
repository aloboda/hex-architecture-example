package buckpal.account.domain;

import lombok.Getter;

import java.math.BigDecimal;

public class Money {
	public static final Money ZERO = new Money(0);
	@Getter
	private final BigDecimal value;

	public Money(double value) {
		this(BigDecimal.valueOf(value));
	}

	public Money(BigDecimal value) {
		this.value = value;
	}

	public static Money add(Money baseValue, Money addValue) {
		return new Money(baseValue.getValue().add(addValue.getValue()));
	}

	public Money negate() {
		return new Money(this.getValue().negate());
	}

	public boolean isPositive() {
		return this.value.compareTo(Money.ZERO.getValue()) > 0;
	}
}
