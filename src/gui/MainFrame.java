package gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	MainFrame(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800,500);
	}

}
