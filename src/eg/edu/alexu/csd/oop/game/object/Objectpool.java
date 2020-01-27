package eg.edu.alexu.csd.oop.game.object;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Objectpool {

	private static ArrayList<GameObject>pool=new ArrayList<GameObject>();
	static Logger logger=Logger.getLogger("circus logger");
	public static GameObject getInstance(int width,int height) {
		if(pool.size()==0) {
			Shape sh;
			try {
				sh = new ShapeFactory().getShape((int)(Math.random()*6));
				sh.setX((int)(width*Math.random()));
				return sh;
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		GameObject ob=pool.get(pool.size()-1);
		ob.setX((int)(Math.random()*width));
		ob.setY(0);
		pool.remove(pool.size()-1);
		logger.info("The shape has been reused");
		return ob;
	}
	public void addInstance(GameObject ob) {
		pool.add(ob);
		logger.info("The shape is added to the pool");
	}
	public int getSize() {
		return pool.size();
	}
}
