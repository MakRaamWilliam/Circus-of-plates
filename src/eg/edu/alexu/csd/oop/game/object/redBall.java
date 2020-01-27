package eg.edu.alexu.csd.oop.game.object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class redBall extends Shape {

	ImageFlyweight image= ImageFlyweight.getInstance();
	public redBall() {
		super();
		setType("redball");
		setColor("red");
		setWidth(30);
		setHeight(30);
		setImage(image.getImage("redball.png"));
	}
}
