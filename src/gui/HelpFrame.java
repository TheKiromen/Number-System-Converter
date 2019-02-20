package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class HelpFrame extends JFrame {
	
	JTextArea help;
	JPanel pane;
	GridBagConstraints cns = new GridBagConstraints();
	
	HelpFrame(){
		super("Help");
		setSize(300,200);
		setResizable(false);
		help=new JTextArea("Help: \n\n"
				+ "Convert from - Base for number system we are converting from. \n"
				+ "Convert to - Base for number system we are converting to. \n"
				+ "Both should be between 2 and 36!");
		help.setPreferredSize(new Dimension(250,150));
		help.setEditable(false);
		help.setLineWrap(true);
		help.setWrapStyleWord(true);
		help.setBackground(UIManager.getColor("Label.background"));
		pane=new JPanel(new GridBagLayout());
		setContentPane(pane);
		cns.gridx=0;
		cns.gridy=0;
		cns.fill=GridBagConstraints.BOTH;
		add(help,cns);
	}
}
