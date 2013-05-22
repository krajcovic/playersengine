package cz.krajcovic.playersengine.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PlayersEngine implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable playersTable = new FlexTable();

	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSecondName = new TextBox();
	private TextBox newFirstName = new TextBox();
	private TextBox newDescription = new TextBox();

	private Button addNewPlayerButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();

	private ArrayList<Player> playersList = new ArrayList<Player>();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// TODO Create table for players.
		playersTable.setText(0, 0, "Second name");
		playersTable.setText(0, 1, "First name");
		playersTable.setText(0, 2, "Description");
		playersTable.setText(0, 3, "Edit");
		playersTable.setText(0, 4, "Remove");

		// TODO Assemble Add new player.
		// TextBoxHandler handle = new TextBoxHandler();
		// newSecondName.addKeyPressHandler(handle);
		// newFirstName.addKeyPressHandler(handle);
		// newDescription.addKeyPressHandler(handle);
		addPanel.add(newSecondName);
		addPanel.add(newFirstName);
		addPanel.add(newDescription);
		addPanel.add(addNewPlayerButton);

		// TODO Assemble Main panel.
		mainPanel.add(playersTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);

		// TODO Associate the Main panel with the HTML host page.
		RootPanel.get("playersList").add(mainPanel);

		// TODO Move cursor focus to the input box.
		newSecondName.setFocus(true);

		// Listen for mouse events on the add button
		addNewPlayerButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addPlayer();

			}
		});
	}

	/**
	 * Add stockk to FlexTable. Executed when the user clicks the
	 * addNewPlayerButton or press enter in the newTextBox.
	 */
	protected void addPlayer() {
		final Player newPlayer = new Player();
		newPlayer.setSecondName(newSecondName.getText().trim());
		newPlayer.setFirstName(newFirstName.getText().trim());
		newPlayer.setDescription(newDescription.getText().trim());

		if (!newPlayer.validate()) {
			Window.alert("'" + newPlayer.toString()
					+ "' are not a valid symbols.");
			return;
		}

		// TODO Add the stock to the table.
		playersList.add(newPlayer);
		int lastRow = playersTable.getRowCount();
		playersTable.setText(lastRow, 0, newPlayer.getSecondName());
		playersTable.setText(lastRow, 1, newPlayer.getFirstName());
		playersTable.setText(lastRow, 2, newPlayer.getDescription());

		// TODO Add a button to edit and remove this player from the table.
		Button changePlayerButton = new Button("e");
		playersTable.setWidget(lastRow, 3, changePlayerButton);

		Button removePlayerButton = new Button("x");
		removePlayerButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				int removedIndex = playersList.indexOf(newPlayer);
				playersList.remove(removedIndex);
				playersTable.removeRow(removedIndex + 1);

			}
		});
		playersTable.setWidget(lastRow, 4, removePlayerButton);

		// TODO Get the stock price.

	}

	// public class TextBoxHandler extends Composite implements KeyPressHandler
	// {
	//
	// @Override
	// public void onKeyPress(KeyPressEvent event) {
	//
	// Widget sender = (Widget) event.getSource();
	//
	// if (sender == newSecondName) {
	//
	// } else if (sender == newFirstName) {
	//
	// } else if (sender == newDescription) {
	// char code = event.getCharCode();
	// if (event.getCharCode() == KeyCodes.KEY_ENTER) {
	// addPlayer();
	// }
	// }
	//
	// }
	//
	// }
}
