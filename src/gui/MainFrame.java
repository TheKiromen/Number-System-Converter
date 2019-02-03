package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
