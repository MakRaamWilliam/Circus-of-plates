package eg.edu.alexu.csd.oop.game.object;

import java.awt.image.BufferedImage;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Shape implements GameObject , Cloneable{

	private static final int MAX_MSTATE = 1;
	private int x;
	private int y;
	private String color;
	private int width;
	private int height;
	private String type;
	private boolean visable;
	private BufferedImage[] image;
	private boolean movable = true;

	public Shape() {
		super();
		image = new BufferedImage[MAX_MSTATE];
		visable = true;
		x = 0;
		y = 0;
	}

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	

	public void setVisable(boolean visable) {
		this.visable = visable;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public void setImage(BufferedImage i) {
		image[0] = i;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		if (movable) {
			this.y = y;
		}
	}

	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visable;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return image;
	}
	
	public Object clone() {
	      Object clone = null;
	      try {

	    	  clone = super.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      
	      return clone;
	   }

}