package eg.edu.alexu.csd.oop.game.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class pinkBall extends Shape{

	ImageFlyweight image= ImageFlyweight.getInstance();
	public pinkBall() {
		super();
		setType("pinkball");
		setColor("pink");
		setWidth(30);
		setHeight(30);
		setImage(image.getImage("pinkball.png"));
	}
	
}

