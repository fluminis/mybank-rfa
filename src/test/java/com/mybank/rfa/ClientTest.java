package com.mybank.rfa;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.mybank.rfa.exceptions.InvalidOperationException;

/**
 * Test the {@link Client} class
 * 
 * @author rfa
 */
public class ClientTest {

	@Test
	public void an_existing_client_withdraws_from_his_account() throws InvalidOperationException {
		// Given an existing client named "pierre-jean" with 100.0 EUR in his
		// account
		Client client = getExistingClient();

		// When he withdraws 10.0 EUR from his account
		client.withdraws(new BigDecimal("10.0"));

		// Then the new balance is 90.0 EUR
		Assert.assertEquals(new BigDecimal("90.0"), client.getBalance());
	}

	@Test
	public void initializing_a_client_set_his_name() throws InvalidOperationException {
		// Given an existing client named "pierre-jean" with 100.0 EUR in his
		// account
		Client client = getExistingClient();

		// Then the name is Pierre-Jean
		Assert.assertEquals("Pierre-Jean", client.getName());
	}

	@Test
	public void initializing_a_client_set_his_balance() throws InvalidOperationException {
		// Given an existing client named "pierre-jean" with 100.0 EUR in his
		// account
		Client client = getExistingClient();

		// Then the name is Pierre-Jean
		Assert.assertEquals(new BigDecimal("100.0"), client.getBalance());
	}

	@Test(expected = IllegalArgumentException.class)
	public void an_existing_client_withdraws_a_null_amount() throws InvalidOperationException {
		// Given an existing client named "pierre-jean" with 100.0 EUR in his
		// account
		Client client = getExistingClient();

		// When he withdraws null from his account
		client.withdraws(null);

		// Then expected IllegalArgumentException
	}

	@Test(expected = InvalidOperationException.class)
	public void an_existing_client_withdraws_a_negative_amount() throws InvalidOperationException {
		// Given an existing client named "pierre-jean" with 100.0 EUR in his
		// account
		Client client = getExistingClient();

		// When he withdraws null from his account
		client.withdraws(new BigDecimal("-10.0"));

		// Then expected InvalidOperationException
	}

	private Client getExistingClient() {
		return new Client("Pierre-Jean", new BigDecimal("100.0"));
	}

}
