package main;

import java.awt.Component;
import javax.swing.JFrame;

/**
 * The main class responsible for starting the game.
 */
public class Main {

	/**
	 * The entry point of the program.
	 * Creates the game window, initializes the game panel, and starts the game.
	 * 
	 * @param args The command-line arguments (unused).
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(3);
		window.setResizable(false);
		window.setTitle("Dungeon Escape");
		

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo((Component) null);
		window.setVisible(true);

		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}










