package com.mybank.rfa.exceptions;

/**
 * Exception thrown when a invalid operation is done on the account of a client
 * 
 * @author rfa
 */
public class InvalidOperationException extends Exception {
	private static final long serialVersionUID = 5949229150334881094L;

	public InvalidOperationException(String message) {
		super(message);
	}
}
