package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	MainFrame(String title){
		//Window Settings
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,300);
		setLocationRelativeTo(null);
		
		
		
		//Layout
		setContentPane(new Panel());
		
	}

}
