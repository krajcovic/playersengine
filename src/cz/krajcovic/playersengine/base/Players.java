package cz.krajcovic.playersengine.base;

public interface Players {
	public void add(Player newPlayer);

	public void edit(Player oldPlayer, Player newPlayer);

	public void remove(Player player);
}
