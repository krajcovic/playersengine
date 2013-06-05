package cz.krajcovic.playersengine.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cz.krajcovic.playersengine.base.Player;

public interface PlayersServiceAsync {

	void add(Player player, AsyncCallback<Void> callback);

	void update(int playerId, Player player, AsyncCallback<Void> callback);
	
	void remove(int playerId, AsyncCallback<Boolean> callback);
	
	void remove(Player player, AsyncCallback<Boolean> callback);

	void getById(int playerId, AsyncCallback<Player> callback);

	void getAll(AsyncCallback<List<Player>> callback);

}
