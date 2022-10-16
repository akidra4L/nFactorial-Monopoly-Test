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
	
	public void setupGame(int number) throws IOException {
		this.board.initializeGameBoard();
		this.board.initializePlayers(number);
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
				if(p.getMoney() <= 0) {
					p.setBankrupt(true);
				}
				
				if(p.getBankrupt()) {
					allPlayers.remove(p);
				}
				
				System.out.println(p.getName() + " your turn. Would you like to roll dice?");
				String action = reader.readLine().toLowerCase();
				if(action.equals("yes")) {
					board.rollDice();
					int dice = board.getDiceValue();
					p.setPosition((p.getPosition() + dice) % 8); 
				}
				
				if(gameBoard.get(p.getPosition()).getPosition() == 0) {
					System.out.println("Congratulations player: " + p.getName() + " you receive 500 000 tenge.");
					p.setMoney(p.getMoney() + 500000);
				}
				
				if(gameBoard.get(p.getPosition()).isAvailable() && gameBoard.get(p.getPosition()).getPosition() != 0) {
					System.out.println(p.getName() + " you are on the " + gameBoard.get(p.getPosition()).getName() + " location, would you like to buy it? (Yes : No)");
					String command = reader.readLine().toLowerCase();
					if(command.equals("yes")) {
						p.buy(gameBoard.get(p.getPosition()));
						gameBoard.get(p.getPosition()).setOwner(p);
						gameBoard.get(p.getPosition()).setAvailable(false);
					}
				}
				else if(!gameBoard.get(p.getPosition()).isAvailable()) {
					if(p.getPosition() != 7 && gameBoard.get(p.getPosition()).getOwner() == gameBoard.get(p.getPosition() + 1).getOwner()) {
						if(gameBoard.get(p.getPosition()).getColor() == gameBoard.get(p.getPosition() + 1).getColor() && gameBoard.get(p.getPosition()).getColor() != Color.WHITE) {
							System.out.println(p.getName() + ", this spot is owned by " + gameBoard.get(p.getPosition()).getOwner() + " and next spot is also his. So you pay 2X");
							p.setMoney(p.getMoney() - 1000000);
							gameBoard.get(p.getPosition()).getOwner().addMoney(1000000);
						}
					} else {
						System.out.println(p.getName() + ", this spot is not available. You should pay.");
						p.setMoney(p.getMoney() - 1000000);
						gameBoard.get(p.getPosition()).getOwner().addMoney(500000);
					}
				}
				System.out.println(p.getPosition() + " " + p.getName());
				System.out.println(gameBoard + "\n");
			}
		}
	}
}
