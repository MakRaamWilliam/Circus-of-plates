package eg.edu.alexu.csd.oop.game;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.object.Shape;

public class Originator {
	private List<GameObject> moving ;
	private  List<Shape> right ;
	private  List<Shape> left ;
	private  long time;
	private int score;
	private int clownposition;
	private IStrategy Strategy;
	public void setmoving(List<GameObject> moving) {
		this.moving=moving;
	}
	public void setright(List<Shape>right) {
		this.right=right;
	}
	public void setleft(List<Shape>left) {
		this.left=left;
	}
	public void settime(long time) {
		this.time=time;
	}
	public void setposition(int p) {
		clownposition=p;
	}
	public void setstrategy(IStrategy Strategy) {
		this.Strategy=Strategy;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public gameMomento createmomento(List<GameObject> moving,ArrayList<Shape> right,ArrayList<Shape> left,long time,int score, IStrategy Strategy,int position){
		 return new gameMomento(moving,right,left,time,score,Strategy,position);
	}
	public void restoremomento(gameMomento m) {
		moving=m.getmoving();
		right=m.getright();
		left=m.getleft();
		time=m.gettime();
		Strategy=m.getstrategy();
		clownposition=m.getposition();
		score=m.getScore();
	}
	public List<GameObject>getmoving(){
		return moving;
	}
	public List<Shape>getright(){
		return right;
	}
	public List<Shape>getleft(){
		return left;
	}
	public long gettime() {
		return time;
	}
	public IStrategy getstrategy() {
		return Strategy;
	}
	public int getScore() {
		return score;
	}

}
