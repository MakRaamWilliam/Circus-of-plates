package eg.edu.alexu.csd.oop.game;

import java.io.IOException;
import java.util.logging.Logger;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Observer {
 
	game1 game;
	public Observer(game1 game) {this.game=game;}
	public void update() {
		Logger logger=Logger.getLogger("circus logger");
		game.setScore(game.getScore()+1);
		logger.info("The score has been increased by one");
	}
}
