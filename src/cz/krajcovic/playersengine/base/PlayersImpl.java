package cz.krajcovic.playersengine.base;

import java.util.ArrayList;

@Deprecated
public class PlayersImpl implements Players {
	
	private ArrayList<Player> playersList = new ArrayList<Player>();

	@Override
	public void add(Player newPlayer) {
		playersList.add(newPlayer);
		
	}

	@Override
	public void edit(Player oldPlayer, Player newPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Player player) {
		// TODO Auto-generated method stub
		
	}

}
