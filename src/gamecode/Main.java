package gamecode;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		GameBoard gb = new GameBoard();
		
		JFrame gw = new JFrame();
		gw.setTitle("Space Invaders");
		gw.setSize(600, 600);
		gw.add(gb);
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setVisible(true);
		
		
	}

}
