package cz.krajcovic.playersengine.client.langs;

import com.google.gwt.i18n.client.Messages;

public interface PlayersEngineMessages extends Messages {

	@DefaultMessage("Added new player.")
	String addNewPlayerSuccess();
	
	@DefaultMessage("Adding new player failed.")
	String addNewPlayerFailed();

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	@DefaultMessage("An error occurred while attempting to contact the server. Please check your network connection and try again.")
	String serverError();
	
	@DefaultMessage("''{0}'' is not a valid symbol.")
	String invalidSymbol(String symbol);

	@DefaultMessage("Update a player failed.")
	String playerUpdateFailed();

	@DefaultMessage("Remove a player failed.")
	String playerRemoveFailed();

}
