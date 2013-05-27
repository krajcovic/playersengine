package cz.krajcovic.playersengine.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cz.krajcovic.playersengine.base.Player;

@RemoteServiceRelativePath("players")
public interface PlayersService extends RemoteService {

	void add(Player player) throws DelistedException;

	void update(int playerId, Player player) throws DelistedException;
	
	boolean remove(int playerId);
	
	boolean remove(Player player);
	
	Player getById(int playerId);
	
	List<Player> getAll();
}
