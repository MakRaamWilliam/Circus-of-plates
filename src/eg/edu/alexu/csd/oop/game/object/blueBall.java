package eg.edu.alexu.csd.oop.game.object;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class blueBall extends Shape {
		ImageFlyweight image= ImageFlyweight.getInstance();
		public blueBall() {
			super();
			setType("blueball");
			setColor("blue");
			setWidth(30);
			setHeight(30);
			setImage(image.getImage("blueball.png"));
		}
}
