package eg.edu.alexu.csd.oop.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import eg.edu.alexu.csd.oop.game.Stack;
import eg.edu.alexu.csd.oop.game.object.Shape;

public class Check {
   
	ArrayList<Shape> temp=new ArrayList<Shape>();
	private int same = 0;
	public int getSame() {
		return same;
	}
	public ArrayList<Shape> CheckStack(Stack ss) {
		Logger logger=Logger.getLogger("circus logger");
		Shape s1,s2,s3;
		Iterator<Shape> it = ss.getShapes().iterator();
		if(it.hasNext() && ss.getShapes().size()>2) {
			 s1 = it.next();
			 s2 = it.next();
			 s3 = it.next();
			 if(s1.getColor() == s2.getColor() && s2.getColor() == s3.getColor()) {
				   logger.info("Three consecutive shapes from the same color have been collected");   
				 same = 1;
					ss.setHeight(ss.getHeight()-(30*3));
					temp.add(s1);
					temp.add(s2);
					temp.add(s3);
					return temp;
			 }
			 else {
				 Shape temp1 = s2;
			     Shape temp2 = s3;
				 while(it.hasNext()) {
					 Shape temp3 = it.next();
				     if(temp1.getColor() == temp2.getColor() && temp2.getColor()==temp3.getColor()) {
				    	    same = 1;
							ss.setHeight(ss.getHeight()-(30*3));
							temp.add(temp1);
							temp.add(temp2);
							temp.add(temp3);
							return temp;
				     }
				     temp1 = temp2;
				     temp2 = temp3;
				 }
			 }
		}
		return null;
	}
	
}
