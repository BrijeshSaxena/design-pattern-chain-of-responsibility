package org.trishinfotech.responsibility;

public class FiftyDispenser extends PaperCurrencyDispenser {

	public FiftyDispenser() {
		super();
	}

	@Override
	public void dispense(PaperCurrency currency) {
		if (currency != null) {
			int amount = currency.getAmount();
			int remainder = amount;
			if (amount >= 50) {
				int count = amount / 50;
				remainder = amount % 50;
				System.out.printf("Dispensing '%d' 50$ currency note.\n", count);
			}
			if (remainder > 0 && this.nextDispenser != null) {
				this.nextDispenser.dispense(new PaperCurrency(remainder));
			}
		}
	}

}
