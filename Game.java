package MonopolyGame;

import java.io.IOException;

public class Game {

	public static void main(String[] args) throws IOException {	
		System.out.println("Welcome to Monopoly Game!\nThis Game is for 3 Players.");
		
		Monopoly monopoly = new Monopoly();
		monopoly.setupGame();
		monopoly.playGame();
	}

}
