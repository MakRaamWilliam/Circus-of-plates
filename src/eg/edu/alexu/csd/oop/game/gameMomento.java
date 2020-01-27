package eg.edu.alexu.csd.oop.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.object.Shape;

public class gameMomento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GameObject> moving ;
	private  ArrayList<Shape> right ;
	private  ArrayList<Shape> left ;
	private  long time;
	private int score;
	private IStrategy Strategy;
	private int clownposition;
	gameMomento(){
		
	}
	public  gameMomento(List<GameObject> moving,ArrayList<Shape> right,ArrayList<Shape> left,long time,int score,IStrategy Strategy,int clownposition) {
		super();
		this.moving=moving;
		this.right=right;
		this.left=left;
		this.time=time;
		this.Strategy=Strategy;
		this.clownposition=clownposition;
		this.score=score;
	}
	public List<GameObject>getmoving(){
		return moving;
	}
	public ArrayList<Shape>getright(){
		return right;
	}
	public ArrayList<Shape>getleft(){
		return left;
	}
	public long gettime() {
		return time;
	}
	public IStrategy getstrategy() {
		return Strategy;
	}
	public int getposition() {
		return clownposition;
	}
	public void setmoving(List<GameObject> moving){
		this.moving=moving;
	}
	public void setright(ArrayList<Shape>right){
		this.right=right;
	}
	public void setleft(ArrayList<Shape>left){
		this.left=left;
	}
	public void settime(int time) {
		this.time=time;
	}
	public void setposition(int p) {
		clownposition=p;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
