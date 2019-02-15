package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import data.*;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	//Components
	JScrollPane convertFromScroll,convertToScroll;
	JTextArea convertFrom,convertTo;
	JComboBox<String> baseFrom,baseTo;
	JLabel baseFromLabel,baseToLabel;
	JButton convert,help;
	String[] systems = {"Binary","Octal","Decimal","Hexadecimal","Custom"};
	DataGetter events = new DataGetter();
	
	
	//Data
	FormData data;

	
	Panel(){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets=new Insets(10, 10, 10, 10);
		c.anchor=GridBagConstraints.PAGE_START;
		
		//------------FIRST COLUMN------------
		c.weightx=0.7;
		c.gridx=0;
		
		
		//ConvertFrom Label
		c.gridy=0;
		baseFromLabel = new JLabel("Convert from:");
		add(baseFromLabel,c);
		
		//ConvertFrom ComboBox
		c.gridy=1;
		baseFrom = new JComboBox<String>(systems);
		baseFrom.setFocusable(false);
		add(baseFrom,c);
		baseFrom.addActionListener(events);
		
		//ComvertTo Label
		c.gridy=2;
		baseToLabel=new JLabel("Convert to:");
		add(baseToLabel,c);
		
		//ConvertTo ComboBox
		c.gridy=3;
		baseTo = new JComboBox<String>(systems);
		baseTo.setFocusable(false);
		baseTo.addActionListener(events);
		add(baseTo,c);
		
		//Help button
		c.gridy=4;
		help=new JButton("Help");
		add(help,c);

		
		//-------------SECOND COLUMN-------------
		c.weightx=1.5;
		c.weighty=1;
		c.gridx=1;
		
		//ConvertFrom TextArea
		c.gridy=0;
		c.gridheight=2;
		c.fill=GridBagConstraints.BOTH;
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
		convert.addActionListener(events);
		
		//ConvertTo TextArea
		c.gridy=3;
		c.gridheight=2;
		convertTo=new JTextArea(10,2);
		convertTo.setEditable(false);
		convertTo.setLineWrap(true);
		convertTo.setWrapStyleWord(true);
		convertToScroll = new JScrollPane(convertTo);
		convertToScroll.setHorizontalScrollBar(null);
		add(convertToScroll,c);
		

	}
	

	
	//------------------------------------EVENT HANDLING--------------------------------------
	private class DataGetter implements ActionListener{

		String number;
		int base1=0,base2=0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp;
			number = convertFrom.getText();
			
			
			
			//------------------COMBO BOXES INPUT-------------------//
			if(e.getSource()==baseFrom){
				if(baseFrom.getSelectedIndex()==4) {
					try {
						tmp=JOptionPane.showInputDialog("Input base to convert from.");
						if(tmp==null||tmp.equals("")) {
							baseFrom.setSelectedIndex(2);
							baseFromLabel.setText("Convert from:");
							return;
						}else {
							base1=Integer.parseInt(tmp);
							if(base1<2||base1>36) {throw new NumberFormatException("Invalid input.");}
							baseFromLabel.setText("Convert from: <"+base1+">");
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Invalid input. Number base should be between 2 and 36", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
						baseFrom.setSelectedIndex(2);
					}
				return;
				}else {
					baseFromLabel.setText("Convert from:");
				}
			}else if (e.getSource()==baseTo) {
				if(baseTo.getSelectedIndex()==4) {
					try {
						tmp=JOptionPane.showInputDialog("Input base to convert to.");
						if(tmp==null||tmp.equals("")) {
							baseTo.setSelectedIndex(2);
							baseToLabel.setText("Convert to:");
							return;
						}else {
							base2=Integer.parseInt(tmp);
							if(base2<2||base2>36) {throw new NumberFormatException("Invalid input.");}
							baseToLabel.setText("Convert to: <"+base2+">");
						}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Invalid input. Number base should be between 2 and 36", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
						baseFrom.setSelectedIndex(2);
					}
					return;
				}else {
					baseToLabel.setText("Convert to:");
				}
			}
			
			
			
			
			//-------------------GETTING THE DATA--------------------//
			
			//---Base we are converting from
			switch(baseFrom.getSelectedIndex()) {
			case 0:
				base1=2;
			break;
			case 1:
				base1=8;
			break;
			case 2:
				base1=10;
			break;
			case 3:
				base1=16;
			break;
			}
			
			//---Base we are converting to
			switch(baseTo.getSelectedIndex()) {
			case 0:
				base2=2;
			break;
			case 1:
				base2=8;
			break;
			case 2:
				base2=10;
			break;
			case 3:
				base2=16;
			break;
			}
			
		
			
			//------------------CONVERSION-----------------//
			
			try {
				FormData data = new FormData(number,base1,base2);
				convertTo.setText(Converter.convert(data));
			}catch(NumberSystemException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Input.", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
