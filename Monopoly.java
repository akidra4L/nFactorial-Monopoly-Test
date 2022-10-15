package MonopolyGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Monopoly {
	private Board board;
	
	public Monopoly() {
		this.board = new Board();
	}
	
	public void setupGame() {
		this.board.initializeGameBoard();
		this.board.initializePlayers();
		this.board.pickFirstRandomly();
	}
	
	public void playGame() throws IOException {
		Vector<Player> allPlayers = new Vector<Player>();
		Vector<BoardLocation> gameBoard = new Vector<BoardLocation>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		allPlayers = Board.getAllPlayers();
		gameBoard = Board.getGameBoard();
		
		while(true) {
			if(allPlayers.size() <= 0) {
				System.out.println("Game Over");
				break;
			}
			for(Player p: allPlayers) {
				
				if(p.getBankrupt()) {
					allPlayers.remove(p);
				}
				
				System.out.println(p.getName() + " your turn.");
				board.rollDice();
				int dice = board.getDiceValue();
				p.setPosition((p.getPosition() + dice) % 8);
				
				if(gameBoard.get(p.getPosition()).getPosition() == 0) {
					p.setMoney(p.getMoney() + 500000);
				}
				
				if(gameBoard.get(p.getPosition()).isAvailable()) {
					System.out.println(p.getName() + " you are on the " + gameBoard.get(p.getPosition()) + " location, would you like to buy it? (Yes : No)");
					String command = reader.readLine();
					if(command.equals("yes") || command.equals("Yes")) {
						gameBoard.get(p.getPosition()).setAvailable(false);
					}
				} else {
					System.out.println(p.getName() + " this spot is not Available to buy. You should pay.\n");
					p.setMoney(p.getMoney() - 250000);
				}
			}
		}
	}
}
