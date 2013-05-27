package cz.krajcovic.playersengine.client;

import java.io.Serializable;

public class DelistedException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2897603368901494366L;

	private String symbol;

	public DelistedException() {

	}

	public DelistedException(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
