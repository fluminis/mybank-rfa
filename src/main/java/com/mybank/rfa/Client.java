package com.mybank.rfa;

import java.math.BigDecimal;

import com.mybank.rfa.exceptions.InvalidOperationException;

/**
 * Client class representing a client of the mybank company.
 * <p>
 * For the brevity of the Kata, a client has one and only one account and an
 * account is only represented by its balance.
 * 
 * @author rfa
 */
public class Client {

	/** name of the client */
	private String name;

	/** balance of the client's account */
	private BigDecimal balance;

	/**
	 * @param name
	 *            name of the client
	 * @param balance
	 *            balance of the client's account
	 */
	public Client(String name, BigDecimal balance) {
		this.setName(name);
		this.setBalance(balance);
	}

	/**
	 * @return the name of the client
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the new name of the client
	 * @throws IllegalArgumentException
	 *             if the name is null or empty
	 */
	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("the client name should not be null or blank");
		}
		this.name = name;
	}

	/**
	 * @return the current balance of the account
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Set the balance of the client account.
	 * <p>
	 * The method is PRIVATE as the balance should only be set by the
	 * constructor or through the #withdraws(BigDecimal) method.
	 * 
	 * @param balance
	 */
	private void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void withdraws(BigDecimal amount) throws InvalidOperationException {
		if (amount == null) {
			throw new IllegalArgumentException(String.format("amount should not be null: Client=%1$s", getName()));
		}
		if (amount.signum() == -1) {
			throw new InvalidOperationException(
					String.format("amount should not be negative: Client=%1$s, Amount=%2$s", getName(), amount));
		}
		setBalance(getBalance().subtract(amount));
	}
}
