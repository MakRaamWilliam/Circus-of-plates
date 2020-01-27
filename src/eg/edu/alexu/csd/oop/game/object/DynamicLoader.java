package eg.edu.alexu.csd.oop.game.object;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.logging.Logger;

public class DynamicLoader {
	private static DynamicLoader instance;
	private static HashMap<String,Class<Shape>> classes=new HashMap<String,Class<Shape>>();
	Logger logger=Logger.getLogger("circus logger");
	private DynamicLoader(String path) throws ClassNotFoundException {
		try {
			File file=new File(path);
			URL url=file.toURI().toURL();
			URLClassLoader loader=new URLClassLoader(new URL[] {url},ClassLoader.getSystemClassLoader());
			JarInputStream jarFile=new JarInputStream(new FileInputStream(path));
			JarEntry jar;
			while(true) {
				jar=jarFile.getNextJarEntry();
				if(jar==null) {break;}
				if(jar.getName().endsWith(".class")) {
					String temp=jar.getName().replaceAll("/","\\.");
					String className=temp.substring(0,temp.lastIndexOf('.'));
					Class<Shape> classt=(Class<Shape>) loader.loadClass(className);
					String tempString=className.substring(className.lastIndexOf('.')+1);
					classes.put(tempString, classt);
					logger.info("The shapes classes have been dynamically loaded");
				}
			}
		} catch (FileNotFoundException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static HashMap<String, Class<Shape>> getClasses() {
		return classes;
	}
	public static void setClasses(HashMap<String, Class<Shape>> classes) {
		DynamicLoader.classes = classes;
	}
	public static DynamicLoader getInstance(String path) throws ClassNotFoundException {
		if (instance == null)
			instance = new DynamicLoader(path);
		return instance;
	}
}
