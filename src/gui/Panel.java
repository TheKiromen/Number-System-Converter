package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	JScrollPane convertFromScroll,convertToScroll;
	JTextArea convertFrom,convertTo;
	JComboBox baseFrom,baseTo;
	JTextField precision;
	JLabel baseFromLabel,baseToLabel,precisionLabel;
	JButton convert,help;
	String[] systems = {"Binary","Octal","Decimal","Hexadecimal","Custom"};

	Panel(){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		
		//------------FIRST COLUMN------------
		c.weightx=1;
		c.weighty=1;
		c.gridx=0;
		
		//ConvertFrom Label
		c.gridy=0;
		JLabel baseFromLabel = new JLabel("Convert from:");
		add(baseFromLabel,c);
		
		//ConvertFrom ComboBox
		c.gridy=1;
		baseFrom = new JComboBox(systems);
		baseFrom.setFocusable(false);
		add(baseFrom,c);
		
		//ComvertTo Label
		c.gridy=2;
		baseToLabel=new JLabel("Convert to:");
		add(baseToLabel,c);
		
		//ConvertTo ComboBox
		c.gridy=3;
		baseTo = new JComboBox(systems);
		baseTo.setFocusable(false);
		add(baseTo,c);
		
		//Precision Label
		c.gridy=4;
		precisionLabel = new JLabel("Precision:");
		add(precisionLabel,c);
		
		//Precision TextField
		c.gridy=5;
		precision = new JTextField(10);
		add(precision,c);
		
		
		//-------------SECOND COLUMN-------------
		c.weightx=1;
		c.weighty=1;
		c.gridx=1;
		//ConvertFrom TextArea
		c.gridy=0;
		c.gridheight=2;
		convertFrom=new JTextArea(10,2);
		convertFrom.setLineWrap(true);
		convertFrom.setWrapStyleWord(true);
		convertFromScroll = new JScrollPane(convertFrom);
		convertFromScroll.setHorizontalScrollBar(null);
		add(convertFromScroll,c);
		
		//Convert Button
		c.gridy=2;
		c.gridheight=1;
		convert = new JButton("Convert");
		add(convert,c);
		
		//ConvertTo TextArea
		c.gridy=3;
		c.gridheight=2;
		convertTo=new JTextArea(10,2);
		convertTo.setEditable(false);
		convertToScroll = new JScrollPane(convertTo);
		convertToScroll.setHorizontalScrollBar(null);
		add(convertToScroll,c);
		
		//Help button
		c.gridy=5;
		c.gridheight=1;
		help=new JButton("Help");
		add(help,c);
	}
}
