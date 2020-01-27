package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

public class Main {

	static GameController gameController;
	static game1 game;
	static long time=0;
	static long time1;
	static long timeload;
    static boolean flag=false;
	static boolean load=false;
	static boolean first=true;
	static Facade f = new Facade();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final JFrame frame = new JFrame("Game");
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		
		JButton button = new JButton("Normal");
		button.setBounds(80, 30, 120, 30);
		button.setVisible(true);
		frame.getContentPane().add(button);
		
		JButton button1 = new JButton("Easy");
		button1.setBounds(80, 90, 120, 30);
		button1.setVisible(true);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("Hard");
		button2.setBounds(80, 150, 120, 30);
		button2.setVisible(true);
		frame.getContentPane().add(button2);
		
		final JButton loadB = new JButton("load");
		loadB.setBounds(80, 210, 120, 30);
		loadB.setVisible(true);
		frame.getContentPane().add(loadB);
		
		frame.setVisible(true);
		
		final JMenuBar  menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New/load");
		final JMenuItem pauseMenuItem = new JMenuItem("Pause");
		final JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem SaveMenuItem = new JMenuItem("Save");
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menu.addSeparator();
		menu.add(SaveMenuItem);
		menuBar.add(menu);
       
	
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    game= new game1(900, 700);
			    game.Strategy = f.GameLevel("normal");
			    game.maxtime= game.Strategy.getMaxtime();
			    game.startTime=System.currentTimeMillis();
			    if(first==true) {gameController = GameEngine.start("Game Circus", game , menuBar, Color.WHITE);
                first=false;}
			    else {gameController.changeWorld(game);
          		pauseMenuItem.doClick();
    			resumeMenuItem.doClick();}
			    frame.setVisible(false);
}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game= new game1(900, 700);
				game.Strategy = f.GameLevel("easy");
				game.maxtime= game.Strategy.getMaxtime();
				game.startTime=System.currentTimeMillis();
				 if(first==true) {gameController = GameEngine.start("Game Circus", game , menuBar, Color.WHITE);
                                  first=false;}
                else {gameController.changeWorld(game);
                      pauseMenuItem.doClick();
                      resumeMenuItem.doClick();}
				frame.setVisible(false);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game= new game1(900, 700);
				game.Strategy = f.GameLevel("hard");
				game.maxtime= game.Strategy.getMaxtime();
				game.startTime=System.currentTimeMillis();
				 if(first==true) {gameController = GameEngine.start("Game Circus", game , menuBar, Color.WHITE);
                 first=false;}
				 else {gameController.changeWorld(game);
				 pauseMenuItem.doClick();
      			resumeMenuItem.doClick();}
				 frame.setVisible(false);
			}
		});  
	
		loadB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File temp=new File(System.getProperty("user.dir")+"/saved");
				if((!temp.exists())||(temp.listFiles().length==0)) {JOptionPane.showMessageDialog(null, "You have to save the game first", "Error", JOptionPane.ERROR_MESSAGE);}
				else {	
				final JFrame frameload = new JFrame("Saved Games");
				frameload.setSize(300, 300);
				frameload.setResizable(false);
				frameload.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameload.getContentPane().setLayout(null);
				final JLabel loadL = new JLabel("load:");
				loadL.setBounds(20, 30, 80, 20);
				loadL.setVisible(true);
				frameload.getContentPane().add(loadL);
				final JComboBox<String> box=new JComboBox<String>();
				box.setBounds(80, 30, 80, 20);
				box.setVisible(true);
				frameload.add(box);
				if(temp.exists()) { 
					File[] listOfFiles=temp.listFiles();
					for(int i=0;i<listOfFiles.length;i++) {
					String name=listOfFiles[i].getName();
					if(name.endsWith(".xml")) {
					String path=name.substring(0,name.lastIndexOf('.'));
				     box.addItem(path);} }
					frameload.setVisible(true); 
				   box.addActionListener(new ActionListener() {
						@Override 
						public void actionPerformed(ActionEvent e) {
							game= new game1(900, 700);
								game.load(box.getSelectedItem().toString());
								 if(first==true) {gameController = GameEngine.start("Game Circus", game , menuBar, Color.WHITE);
                                 first=false;}
								 else {gameController.changeWorld(game);
								 pauseMenuItem.doClick();
								 resumeMenuItem.doClick();}
								 frameload.setVisible(false);}
				   });}
								frame.setVisible(false);
				}
		}});  
		
		    newMenuItem.addActionListener(new ActionListener() {
			@Override    
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
	            gameController.pause();
				//gameController.changeWorld(new eg.edu.alexu.csd.oop.game.game1(1000, 730));
			    }
			});
			pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag==false) {
					 gameController.pause();
					 time1=System.currentTimeMillis();
					 flag=true;
				}
			}
			});
			resumeMenuItem.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				if(flag==true) {
			            time=System.currentTimeMillis()-time1;
			            flag=false;
			            game1.startTime=game1.startTime+time;
			            if(load==true) {
			            	timeload=System.currentTimeMillis()-game1.time;
			            	game1.startTime=game1.startTime-time+timeload;
			            	load=false;
			            }
			            gameController.resume();
				}
		            
				}			});
			SaveMenuItem.addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				File temp=new File(System.getProperty("user.dir")+"/saved");
				if(!temp.exists()) {temp.mkdirs();}
				if(flag==false) {
				   pauseMenuItem.doClick();
				   String path=JOptionPane.showInputDialog("Enter the name of the game");
				   if(path==null) {resumeMenuItem.doClick();}
				   else{game.save(path);
				    resumeMenuItem.doClick();}
				}
			else {String path=JOptionPane.showInputDialog("Enter the name of the game");
				game.save(path);}}
			});
 		
	}

}

