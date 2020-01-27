package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageFlyweight {

	private static ImageFlyweight instance;
	private ImageFlyweight() {}
	public static ImageFlyweight getInstance( ) {
		if (instance == null)
			instance = new ImageFlyweight();
		return instance;
	}
private static HashMap<String,BufferedImage> images=new HashMap<String,BufferedImage>();
public BufferedImage getImage(String path) {
	if(images.containsKey(path)) {
		return images.get(path);}
	else {
		try {
			BufferedImage temp=ImageIO.read (new File(path));
			images.put(path, temp);
			return temp;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        return null;
		}
	}
}
}
