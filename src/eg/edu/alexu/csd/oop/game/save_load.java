package eg.edu.alexu.csd.oop.game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import eg.edu.alexu.csd.oop.game.object.Shape;
import eg.edu.alexu.csd.oop.game.object.ShapeFactory;
//import com.google.gson.*;

public class save_load {
	
	static Originator ob;
	static gameMomento m;
	save_load(){
		
	}
	 save_load(List<GameObject> moving,ArrayList<Shape> right,ArrayList<Shape> left,long time,int score,IStrategy Strategy,int position){
		ob=new Originator();
		m=ob.createmomento(moving,right,left, time,score,Strategy,position);
	}
	public void sava(String path) throws IOException{
		
			File f=new File(System.getProperty("user.dir")+"/saved/"+path+".xml");
			 DocumentBuilderFactory documentFactory =DocumentBuilderFactory.newInstance();
		      DocumentBuilder documentBuilder;
			try {
				documentBuilder = documentFactory.newDocumentBuilder();
				Document document =documentBuilder.newDocument();
			      Element root=document.createElement("game1");
			      document.appendChild(root);
			      Element moving=document.createElement("moving");
			      root.appendChild(moving);
			      for(int i=0;i<m.getmoving().size();i++) {
			    	  Element object=document.createElement("object");
				      moving.appendChild(object);
				      Element x=document.createElement("x");
				      object.appendChild(x);
				      x.appendChild(document.createTextNode(Integer.toString(m.getmoving().get(i).getX())));
				      Element y=document.createElement("y");
				      object.appendChild(y);
				      y.appendChild(document.createTextNode(Integer.toString(m.getmoving().get(i).getY())));
				      Shape sh=(Shape) m.getmoving().get(i);
				      Element type=document.createElement("type");
				      object.appendChild(type);
				      type.appendChild(document.createTextNode(Integer.toString(getfactory(sh.getType()))));
			      }
			
			      Element right=document.createElement("right");
			      root.appendChild(right);
			      for(int i=0;i<m.getright().size();i++) {
			    	  Element object=document.createElement("object");
				      right.appendChild(object);
				      Element x=document.createElement("x");
				      object.appendChild(x);
				      x.appendChild(document.createTextNode(Integer.toString(m.getright().get(i).getX())));
				      Element y=document.createElement("y");
				      object.appendChild(y);
				      y.appendChild(document.createTextNode(Integer.toString(m.getright().get(i).getY())));
				      Shape sh=(Shape) m.getright().get(i);
				      Element type=document.createElement("type");
				      object.appendChild(type);
				      type.appendChild(document.createTextNode(Integer.toString(getfactory(sh.getType()))));
			      }
		
			      Element left=document.createElement("left");
			      root.appendChild(left);
			      for(int i=0;i<m.getleft().size();i++) {
			    	  Element object=document.createElement("object");
				      left.appendChild(object);
				      Element x=document.createElement("x");
				      object.appendChild(x);
				      x.appendChild(document.createTextNode(Integer.toString(m.getleft().get(i).getX())));
				      Element y=document.createElement("y");
				      object.appendChild(y);
				      y.appendChild(document.createTextNode(Integer.toString(m.getleft().get(i).getY())));
				      Shape sh=(Shape) m.getleft().get(i);
				      Element type=document.createElement("type");
				      object.appendChild(type);
				      type.appendChild(document.createTextNode(Integer.toString(getfactory(sh.getType()))));
			      }
			      Element time=document.createElement("time");
			      root.appendChild(time);
			      time.appendChild(document.createTextNode(Long.toString(m.gettime())));
			      
			      Element score=document.createElement("score");
			      root.appendChild(score);
			      score.appendChild(document.createTextNode(Integer.toString(m.getScore())));
			      
			      Element strategy=document.createElement("strategy");
			      root.appendChild(strategy);
			      strategy.appendChild(document.createTextNode(Integer.toString(getstratgy(m.getstrategy()))));
			      
			      Element position=document.createElement("position");
			      root.appendChild(position);
			      position.appendChild(document.createTextNode(Integer.toString(m.getposition())));
			      
			      try {
			    	  Transformer transformer=TransformerFactory.newInstance().newTransformer();
						Source source=new DOMSource(document);
						Result result=new StreamResult(f);
						transformer.transform(source, result);
			     
			      } catch (Exception e) {
						// TODO: handle exception
					} 
			      
			      
			}
			catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		
		
	}
	
	public gameMomento load(String path) throws IOException{
		List<GameObject>moving=new ArrayList<GameObject>();
		ArrayList<Shape>right=new ArrayList<Shape>();
		ArrayList<Shape>left=new ArrayList<Shape>();
		long time=0;
		int score=0;
		IStrategy strategy;
		int position =0;
		ShapeFactory factory = new ShapeFactory();
		try {
			
			File f=new File(System.getProperty("user.dir")+"/saved/"+path+".xml");
			 DocumentBuilderFactory documentFactory =DocumentBuilderFactory.newInstance();
		      DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		      Document document =documentBuilder.parse(f);
		      document.getDocumentElement().normalize();
		    
		      NodeList n=document.getChildNodes();
		      NodeList r=n.item(0).getChildNodes();
		      NodeList k=r.item(0).getChildNodes();
		
		      for (int temp = 0; temp < k.getLength(); temp++) {
		  		Node nNode = k.item(temp);
		  		Element eElement = (Element) nNode;
		  		Shape g=factory.getShape(Integer.parseInt(eElement.getElementsByTagName("type").item(0).getTextContent()));
		  		g.setX(Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent()));
		  		g.setY(Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent()));
		  		moving.add(g);
		  	}
		      k=r.item(1).getChildNodes();
		      for (int temp = 0; temp < k.getLength(); temp++) {
			  		Node nNode = k.item(temp);
			  		Element eElement = (Element) nNode;
			  		Shape g=factory.getShape(Integer.parseInt(eElement.getElementsByTagName("type").item(0).getTextContent()));
			  		g.setX(Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent()));
			  		g.setY(Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent()));
			  		right.add(g);
			  	}
		      
		      k=r.item(2).getChildNodes();
		      for (int temp = 0; temp < k.getLength(); temp++) {
			  		Node nNode = k.item(temp);
			  		Element eElement = (Element) nNode;
			  		Shape g=factory.getShape(Integer.parseInt(eElement.getElementsByTagName("type").item(0).getTextContent()));
			  		g.setX(Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent()));
			  		g.setY(Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent()));
			  		left.add(g);
			  	}
		      time=Long.parseLong(document.getElementsByTagName("time").item(0).getTextContent());
		      score=Integer.parseInt(document.getElementsByTagName("score").item(0).getTextContent());
		      int st=Integer.parseInt(document.getElementsByTagName("strategy").item(0).getTextContent());
		      if(st==1) {
		    	  strategy=new StrategyEasy();
		      }
		      else if(st==2) {
		    	  strategy=new StrategyNormal();
		      }
		      else {
		    	  strategy=new StrategyHard();
		      }
		      position=Integer.parseInt(document.getElementsByTagName("position").item(0).getTextContent());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "You have to save the game first", "Error", JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException();
		}
		m=new gameMomento(moving,right,left,time,score,strategy,position);
		return m;
	}
	private int getfactory(String type) {
		switch(type) {
		case "blueball":
			return 0;
		case "bluegift":
			return 1;
		case "pinkball":
			return 2;
		case "pinkgift":
			return 3;
		case "redball":
			return 4;
		case "redgift":
			return 5;
			default:
				return -1;
		}
	}
	public int getstratgy(IStrategy s) {
		if(s.getsped()==12) {
			return 1;
		}
		if(s.getsped()==10) {
			return 2;
		}
		if(s.getsped()==8) {
			return 3;
		}
		return 0;
		
	}

}
