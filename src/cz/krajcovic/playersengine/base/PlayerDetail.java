package cz.krajcovic.playersengine.base;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.i18n.client.DateTimeFormat;

public class PlayerDetail extends JavaScriptObject {

	/**
	 * Overlay types always have protected, zero argument constructors.
	 */
	protected PlayerDetail() {

	}

	// JSNI methods to get player details.
	public final native Integer getPlayerId() /*-{
		return this.playerId;
	}-*/;

	public final native Integer getWeight() /*-{
		return this.weight;
	}-*/;

	public final native DateTimeFormat getCreated() /*-{
		return this.created;
	}-*/;

	// Non-JSNI method to return
	public final String getWeightInfo() {
		return this.getPlayerId().toString() + " have " + this.getWeight()
				+ " kg at " + getCreated().parse("dd.MM.yy");
	}

}
