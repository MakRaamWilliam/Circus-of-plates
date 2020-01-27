package eg.edu.alexu.csd.oop.game.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class redGift extends Shape {

	ImageFlyweight image= ImageFlyweight.getInstance();
	public redGift() {
		super();
		setType("redgift");
		setColor("red");
		setWidth(30);
		setHeight(30);
		setImage(image.getImage("redgift.png"));
	}
}
