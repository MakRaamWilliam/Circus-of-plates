package eg.edu.alexu.csd.oop.game;

//Java program to play an Audio 
//file using Clip Object 
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class SimpleAudioPlayer 
{ 

	Long currentFrame; 
	Clip clip; 
	
	String status; 
	
	AudioInputStream audioInputStream; 
	static String filePath; 

	public SimpleAudioPlayer(String path) 
		throws UnsupportedAudioFileException, 
		IOException, LineUnavailableException 
	{ 
	
		audioInputStream = 
				AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile()); 
		
		clip = AudioSystem.getClip(); 
		clip.open(audioInputStream); 
		  play(); 
			
//			int numbeeps = 1000;
//
//			for(int x=0;x<numbeeps;x++)
//			{
//		  java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
//			}
		 
		
		
	} 

	
	
	public void play() 
	{ 
		
		clip.start(); 
		
	} 
	
	

} 
