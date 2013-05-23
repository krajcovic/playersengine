package cz.krajcovic.playersengine.client;

import com.google.gwt.i18n.client.Messages;

public interface PlayersEngineMessages extends Messages {

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	@DefaultMessage("An error occurred while attempting to contact the server. Please check your network connection and try again.")
	String serverError();
	
	@DefaultMessage("''{0}'' is not a valid symbol.")
	String invalidSymbol(String symbol);

}
