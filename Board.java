package MonopolyGame;

import java.util.*;

public class Board {
	private Player player;
	private int diceValue;
	private static Vector <Player> allPlayers = new Vector<Player>();
	private static Vector <BoardLocation> gameBoard = new Vector<BoardLocation>(); 
	
	public void pickFirstRandomly() {
		Collections.shuffle(allPlayers);
	}
	
	public void nextTurn() {
		this.player = allPlayers.remove(0);
	}
	
	public void endTurn() {
		allPlayers.add(player);
	}
	
	public void rollDice() {
		this.diceValue = (int)(Math.random() * 6) + 1;
		System.out.println("You rolled a " + this.diceValue);
	}
	
	public void movePlayer(Player p) {
		p.setPosition(p.getPosition() + this.diceValue);
	}
	
	public void initializePlayers() {
		Player p1 = new Player("Alikhan", 0);
		Player p2 = new Player("Aliya", 0);
		Player p3 = new Player("Rayymbek", 0);
		
		allPlayers.add(p1);
		allPlayers.add(p2);
		allPlayers.add(p3);
	}
	
	public void initializeGameBoard() {
		gameBoard.add(new CornerSquare(0, "Start"));
		gameBoard.add(new CornerSquare(1, "Almaty"));
		gameBoard.add(new CornerSquare(2, "Astana"));
		gameBoard.add(new CornerSquare(3, "Uralsk"));
		gameBoard.add(new CornerSquare(4, "Aksay"));
		gameBoard.add(new CornerSquare(5, "Aktau"));
		gameBoard.add(new CornerSquare(6, "Taraz"));
		gameBoard.add(new CornerSquare(7, "Shymkent"));
	}
	
	public int getDiceValue() {
		return this.diceValue;
	}
	
	public static Vector<Player> getAllPlayers() {
		return allPlayers;
	}
	
	public static Vector<BoardLocation> getGameBoard() {
		return gameBoard;
	}
	
	public String toString() {
		return this.player + " " + this.diceValue;
	}
	
}
