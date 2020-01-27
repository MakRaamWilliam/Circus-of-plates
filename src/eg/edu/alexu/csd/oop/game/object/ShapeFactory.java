package eg.edu.alexu.csd.oop.game.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.logging.Logger;

public class ShapeFactory {
	Logger logger=Logger.getLogger("circus logger");
	public Shape getShape(int type) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
		DynamicLoader l=DynamicLoader.getInstance("Shapes.jar");
		HashMap<String,Class<Shape>> t=l.getClasses();
	switch (type) {
	case 0:
		Constructor<Shape>r=t.get("blueBall").getConstructor();
		logger.info("New blue ball has been created");
		return (Shape)r.newInstance();
	case 1:
		Constructor<Shape>r2=t.get("blueGift").getConstructor();
		logger.info("New blue gift has been created");
		return (Shape)r2.newInstance();
	case 2:
		Constructor<Shape>r3=t.get("pinkBall").getConstructor();
		logger.info("New pink ball has been created");
		return (Shape)r3.newInstance();
	case 3:
		Constructor<Shape>r4=t.get("pinkGift").getConstructor();
		logger.info("New pink gift has been created");
		return (Shape)r4.newInstance();
	case 4:
		Constructor<Shape>r5=t.get("redBall").getConstructor();
		logger.info("New red ball has been created");
		return (Shape)r5.newInstance(); 
	case 5:
		Constructor<Shape>r6=t.get("redGift").getConstructor();
		logger.info("New red gift has been created");
		return (Shape)r6.newInstance();
	default:
		return null;
	}	
	}
}
