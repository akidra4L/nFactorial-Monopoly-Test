package MonopolyGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How much Players will play?");
		int number = Integer.parseInt(reader.readLine());
		
		System.out.println("Welcome to Monopoly Game!\nThis Game is for " + number + " players");
		
		Monopoly monopoly = new Monopoly();
		monopoly.setupGame(number);
		System.out.println();
		monopoly.playGame();
	}

}
