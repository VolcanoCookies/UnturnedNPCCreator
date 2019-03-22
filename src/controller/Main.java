package controller;

import java.awt.EventQueue;

public class Main {
	
	static final String VERSION = "0.4.0";
	//Settings object to dictate settings object to dictate settings for this session.
	
	public static void main(String[] args) {
		
		//Standby window
		StandbyWindow standbyWindow = new StandbyWindow();
		
		//Run before main window opens
		new Init(VERSION);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					standbyWindow.dispose();
					new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
