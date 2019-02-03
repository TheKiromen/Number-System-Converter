package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	JComboBox baseFrom,baseTo;
	JLabel baseFromLabel,baseToLabel,convertFromLabel,convertToLabel;
	String[] options = {"Binary","Octal","Decimal","Hexadecimal","Custom"};

	Panel(){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets=new Insets(10,20,0,10);
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.fill=GridBagConstraints.NONE;
		
		
		//FIRST COLUMN
		//Convert from option
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.01;
		c.weightx=1;
		baseFromLabel=new JLabel("Convert from:");
		add(baseFromLabel,c);
		
		c.gridy=1;
		c.weighty=0.01;
		baseFrom=new JComboBox(options);
		baseFrom.setFocusable(false);
		add(baseFrom,c);
		
		
		//Convert to option
		c.gridy=2;
		c.weighty=0.01;
		baseToLabel=new JLabel("Convert to:");
		add(baseToLabel,c);
		
		c.gridy=3;
		c.weighty=2.0;
		baseTo=new JComboBox(options);
		baseTo.setFocusable(false);
		add(baseTo,c);
		
		
		//SECOND COULMN
				
		//Convert from input
		c.gridx=1;
		c.gridy=0;
		c.weighty=0.1;
		c.weightx=1;
		convertFromLabel=new JLabel("Convert from ");
		add(convertFromLabel,c);
		
		
	}
}
