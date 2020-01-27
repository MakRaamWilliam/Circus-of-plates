package eg.edu.alexu.csd.oop.game.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class pinkGift extends Shape {

	ImageFlyweight image= ImageFlyweight.getInstance();
	public pinkGift() {
		super();
		setType("pinkgift");
		setColor("pink");
		setWidth(30);
		setHeight(30);
		setImage(image.getImage("pinkgift.png"));	
		}
}
