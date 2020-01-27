package eg.edu.alexu.csd.oop.game.object;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject {
	
	private int x;
	private int y;
	private int savedX;
	private int SavedY;
	private BufferedImage[] allImage = new BufferedImage[1];
	private static Clown instance;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private Clown( ) {
		Logger logger=Logger.getLogger("circus logger");
		try {
			allImage[0] = ImageIO.read(new File("clown1.png") );
		} catch (IOException e) {
		}
		x = (screenSize.width - getWidth()) / 2;
		y = screenSize.height - getHeight() - 150;
		logger.info("The clown has been created");
	}

	public static Clown getInstance( ) {
		if (instance == null)
			instance = new Clown();
		return instance;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		// this.y = y;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return allImage[0].getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return allImage[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		try {
			allImage[0] = ImageIO.read(new File("clown1.png") );
		} catch (IOException e) {
		}
		return allImage;
	}

	public int getSavedX() {
		return savedX;
	}

	public void setSavedX(int savedX) {
		this.savedX = savedX;
	}

	public int getSavedY() {
		return SavedY;
	}

	public void setSavedY(int savedY) {
		SavedY = savedY;
	}

}