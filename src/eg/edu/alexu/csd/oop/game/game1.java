package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import eg.edu.alexu.csd.oop.game.object.BackGround;
import eg.edu.alexu.csd.oop.game.object.Clown;
import eg.edu.alexu.csd.oop.game.object.Objectpool;
import eg.edu.alexu.csd.oop.game.object.Shape;
import eg.edu.alexu.csd.oop.game.object.ShapeFactory;

public class game1 implements World{
	IStrategy Strategy = new StrategyNormal();
	private int score = 0;
    static long time=0;
    static long  startTime = System.currentTimeMillis();
	long pausetime =0,changetime=0,savetime=0,loadtime=0;
	  long maxtime=Strategy.getMaxtime();
	private  List<GameObject> constant = new LinkedList<GameObject>();
	private List<GameObject> moving = new LinkedList<GameObject>();
	private final List<GameObject> control = new LinkedList<GameObject>();
	private final int width;
	private final int height;
	Objectpool ob=new Objectpool();
	int c=0;
	Stack right=new Stack();
	Stack left=new Stack();
	Logger logger=Logger.getLogger("circus logger");
	save_load ob1=new save_load();
	public game1(int width,int height) {
		FileHandler fh;
		try {
			fh=new FileHandler(System.getProperty("user.dir")+"/logger.txt");
			logger.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.width=width;
		this.height=height;
		control.add(Clown.getInstance());
		constant.add( new BackGround());

		for(int i=0; i<3; i++) {
			Shape sh;
			try {
				sh = new ShapeFactory().getShape((int)(Math.random()*6));
				sh.setX((int)(Math.random()*width));
				moving.add(sh);
			} catch (ClassNotFoundException | NoSuchMethodException
					| SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
	private boolean intersectLeft(GameObject o1, GameObject o2){
		boolean leftStack=(Math.abs(Math.abs((o1.getX()+o1.getWidth()/2)-(o2.getX()+10))-(5))<20) &&(Math.abs((o1.getY()+o1.getHeight())-(o2.getY()))<5);
		return (leftStack);}
	private boolean intersectRight(GameObject o1, GameObject o2){
		boolean rightStack=(Math.abs(Math.abs((o1.getX()+o1.getWidth()/2)-(o2.getX()+o2.getWidth()-10))-(5))<20) &&(Math.abs((o1.getY()+o1.getHeight())-(o2.getY()))<5);
		return (rightStack);}
	public void save(String path) {
		if(Main.flag==true) {
			ob1=new save_load(moving, right.getShapes(),left.getShapes(),Main.time1-startTime,score,Strategy,control.get(0).getX());
		}
		else {
			ob1=new save_load(moving, right.getShapes(),left.getShapes(), System.currentTimeMillis()-startTime,score,Strategy,control.get(0).getX());
		}
		try {
			ob1.sava(path);
			logger.info("The game is saved sucessfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void load(String path) {
		gameMomento m;
		try {
			if(Main.flag==true) {
				time=System.currentTimeMillis();
				Main.load=true;
			}
			m = ob1.load(path);
			logger.info("The game is loaded sucessfully");
			moving=m.getmoving();
			right.setShapes(m.getright());
			right.setHeight(right.getShapes().size()*30);
			left.setShapes(m.getleft());
			left.setHeight(left.getShapes().size()*30);
			constant.clear();
			for(int i=0;i<right.getShapes().size();i++) {
				constant.add(right.getShapes().get(i));
			}
			for(int i=0;i<left.getShapes().size();i++) {
				constant.add(left.getShapes().get(i));
			}
			Strategy=m.getstrategy();
			control.get(0).setX(m.getposition());
			constant.add( new BackGround());
			startTime=System.currentTimeMillis()-m.gettime();
			score=m.getScore();
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<GameObject> getConstantObjects() {
		return constant;
	}

	
	public List<GameObject> getMovableObjects() {
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return control;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
	public int getScore() {
		return score;
	}
public void setScore(int score) {
		this.score = score;
	}
	public boolean refresh() {
		Check f=new Check();
		Observer s=new Observer(this);
		SubjectObserved o=new SubjectObserved(f,s);
		boolean timeout = System.currentTimeMillis()-startTime-pausetime >maxtime;
		if(c% Strategy.getnumShape() ==0) {
		moving.add(Objectpool.getInstance(width, height));}
		ArrayList<GameObject> temp=new ArrayList<GameObject>(); 
		for(GameObject p:moving) {
			if(p.isVisible()) {
				p.setY(p.getY()+1);
				if(p.getY()>=height) {
					ob.addInstance(p);
					temp.add(p);
				}
				GameObject obj2;
				if(right.empty()) {obj2=control.get(0);}
				else {obj2=right.getLast();}
				if(intersectRight(p,obj2)) {
					if(right.canAdd((Shape)p)) {
					right.setHeight(right.getHeight()+p.getHeight());
					temp.add(p);
					constant.add(p);
					ArrayList<Shape> removed=f.CheckStack(right);
					o.notification();
					if(removed!=null) {
						ArrayList<Shape> ss=right.getShapes();
						for(Shape r:removed) {
							ss.remove(r);
							constant.remove(r);
						}
						right.setShapes(ss);
					}
					if(right.getShapes().size()==11) {right.setState(new FullStack(right));}
					}
				}
				if(left.empty()) {obj2=control.get(0);}
				else {obj2=left.getLast();}
				if(intersectLeft(p,obj2)) {
					if(left.canAdd((Shape)p)) {
					left.setHeight(left.getHeight()+p.getHeight());
					temp.add(p);
					constant.add(p);
					ArrayList<Shape> removed=f.CheckStack(left);
					o.notification();
					if(removed!=null) {
						ArrayList<Shape> ss=left.getShapes();
						for(Shape r:removed) {
							ss.remove(r);
							constant.remove(r);
						}
						left.setShapes(ss);
					}
					if(left.getShapes().size()==11) {left.setState(new FullStack(left));}
					}
				}
			}
		}
		for(GameObject p:temp) {moving.remove(p);}
		for(GameObject p:constant ) { 
	if(right.getShapes().contains(p)) p.setX(control.get(0).getX() + 80);
	else p.setX(control.get(0).getX() );
		}
			c++;
		 boolean full=(right.getType().equals("full"))||(left.getType().equals("full"));
		return (!full&!timeout);
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub 
		return "circus of plates   |   score: "+score+"   |   time: "+((System.currentTimeMillis()-startTime )/1000);
	}

	@Override
	public int getSpeed() {
		return Strategy.getsped();
	}

	@Override
	public int getControlSpeed() {
		return Strategy.getcontrolSpeed();
	}
	
//	public static void main(String []args) {
//		GameEngine.start("our game", new eg.edu.alexu.csd.oop.game.game1(700, 700), Color.WHITE);
//	}

}
