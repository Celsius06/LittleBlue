package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	// Screen Settings
	final int originalTileSize = 16;	// 16x16 tile (default size of in-game character, npc,......)
	final int scale = 3;
	final int tileSize = originalTileSize * scale;	// 48 * 48 tile (actual tile size on the game screen)
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;	// 48 * 16 = 768 pixels
	final int screenHeight = tileSize * maxScreenRow;	// 48 * 12 = 576 pixels
	
	Thread gameThread;
	
	// Constructor
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null) {
//			System.out.println("The game loop is running.");
			// Functionality 1: Update game data like char.positions
			update();
			// Functionality 2: Draw screen with updated data
			repaint();
		}
	}
	
	public void update() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(100, 100, tileSize, tileSize);
		g2.dispose();
	}
}
