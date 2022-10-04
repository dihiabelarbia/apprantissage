package test;

import java.io.IOException;

import IHM.MainGui;

public class Test {
	
	public static void main(String[] args) throws IOException {

		MainGui gameMainGUI = new MainGui("APRENTISSAGE");
		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start(); 
	}
}
