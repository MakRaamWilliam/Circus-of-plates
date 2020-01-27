package eg.edu.alexu.csd.oop.game.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class blueGift extends Shape {

	ImageFlyweight image= ImageFlyweight.getInstance();
	public blueGift() {
		super();
		setType("bluegift");
		setColor("blue");
		setWidth(30);
		setHeight(30);
		setImage(image.getImage("bluegift.png"));
	}
	
}
