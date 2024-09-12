// The front displaying of the game
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	// Screen Settings
	final int originalTileSize = 16;	// 16x16 tile (default size of in-game character, npc,......)
	final int scale = 3;
	public final int tileSize = originalTileSize * scale;	// 48 * 48 tile (actual tile size on the game screen)
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;	// 48 * 16 = 768 pixels
	final int screenHeight = tileSize * maxScreenRow;	// 48 * 12 = 576 pixels
	
	// Frames Per Second (FPS)
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);
	TileManager tileM = new TileManager(this);
	
	// Constructor
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	// 1st game loop: sleep
//	@Override
//	public void run() {
//		double drawInterval = 1000000000 / FPS;	// ~ 0.0167 seconds per interval
//		double nextDrawTime = System.nanoTime() + drawInterval;
//	
//		while (gameThread != null) {
//			update();
//			repaint();
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime / 1000000;
//				
//				if (remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long) remainingTime);
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//		}
//	}
	
	// 2nd game loop: delta
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while (gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime); 
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);		
		player.draw(g2);
	
		
		g2.dispose();
		

	}
}
