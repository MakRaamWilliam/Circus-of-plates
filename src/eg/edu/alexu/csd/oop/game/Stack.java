package eg.edu.alexu.csd.oop.game;

import java.sql.Statement;
import java.util.ArrayList;

import eg.edu.alexu.csd.oop.game.object.Shape;

public class Stack{
   private int height=0;
   private ArrayList<Shape> shapes=new ArrayList<Shape>();
   private StackState state=new AvialbleStack(this);
   
   private String type="avialable";
   public String getType() {
   	return type;
   }
   public void setType(String type) {
   	this.type = type;
   }
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public Shape getLast() {
	return shapes.get(shapes.size()-1);
}
public ArrayList<Shape> getShapes() {
		return shapes;
	}
public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

public StackState getState() {
		return state;
	}

public void setState(StackState state) {
		this.state = state;
	}

public boolean empty() {
		if(height==0) {return true;}
		return false ;
}

public boolean canAdd(Shape s) {
		return state.add(s);
}
public void add(Shape s) {
	shapes.add(s);
}
}
