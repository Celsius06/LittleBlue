// Sound manager for the game
package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	// Constructor
	public Sound() {
		// Theme Music
		soundURL[0] = getClass().getResource("/thememusic/BlueBoyAdventure.wav");
		// SFX
		soundURL[1] = getClass().getResource("/sfx/coin.wav");
		soundURL[2] = getClass().getResource("/sfx/powerup.wav");
		soundURL[3] = getClass().getResource("/sfx/unlock.wav");
		soundURL[4] = getClass().getResource("/sfx/fanfare.wav");
	}
	
	// Methods
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch(Exception e) {}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
}
