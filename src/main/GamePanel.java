package main;

import java.awt.Color;
import java.awt.Dimension;

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
		
	}
}
