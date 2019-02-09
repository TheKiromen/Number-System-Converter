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
import javax.swing.JTextField;

import data.*;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	//Components
	JScrollPane convertFromScroll,convertToScroll;
	JTextArea convertFrom,convertTo;
	JComboBox<String> baseFrom,baseTo;
	JTextField precision;
	JLabel baseFromLabel,baseToLabel,precisionLabel;
	JButton convert,help;
	String[] systems = {"Binary","Octal","Decimal","Hexadecimal","Custom"};
	
	
	//Data
	FormData data;

	
	Panel(){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets=new Insets(10, 10, 10, 10);
		
		
		//------------FIRST COLUMN------------
		c.weightx=0.7;
		c.gridx=0;
		
		//ConvertFrom Label
		c.gridy=0;
		JLabel baseFromLabel = new JLabel("Convert from:");
		add(baseFromLabel,c);
		
		//ConvertFrom ComboBox
		c.gridy=1;
		baseFrom = new JComboBox<String>(systems);
		baseFrom.setFocusable(false);
		add(baseFrom,c);
		
		//ComvertTo Label
		c.gridy=2;
		baseToLabel=new JLabel("Convert to:");
		add(baseToLabel,c);
		
		//ConvertTo ComboBox
		c.gridy=3;
		baseTo = new JComboBox<String>(systems);
		baseTo.setFocusable(false);
		add(baseTo,c);
		
		//Precision Label
		c.gridy=4;
		precisionLabel = new JLabel("Precision:");
		add(precisionLabel,c);
		
		//Precision TextField
		c.gridy=5;
		precision = new JTextField(10);
		precision.setText("0");
		add(precision,c);
		
		
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
		convert.addActionListener(new DataGetter());
		
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
	

	
	//------------------------------------EVENT HANDLING--------------------------------------
	private class DataGetter implements ActionListener{


		
		@Override
		public void actionPerformed(ActionEvent e) {
			String tmp;
			String number = convertFrom.getText();
			int base1=10,base2=10,prec=0;
			
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
			case 4:
				try {
					tmp=JOptionPane.showInputDialog("Input base to convert to.");
					if(tmp!=null&&!tmp.equals("")) {
						base1=Integer.parseInt(tmp);
						if(base1<2||base1>36) {throw new NumberFormatException("Invalid input.");}
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Number base should be between 2 and 32", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
					return;
				}
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
			case 4:
				try {
					tmp=JOptionPane.showInputDialog("Input base to convert to.");
					if(tmp!=null&&!tmp.equals("")) {
						base2=Integer.parseInt(tmp);
						if(base2<2||base2>36) {throw new NumberFormatException("Invalid input.");}
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input. Number base should be between 2 and 32", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
					return;
				}
			break;
			}
			
			//---PRECISION
			try {
				tmp=precision.getText();
				if(tmp.equals("")) {
					precision.setText("0");
					tmp="0";
				}
				prec=Integer.parseInt(tmp);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Invalid input. Precision should be an integer.", "Invalid Input.", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			
			//------------------CONVERSION-----------------//
			
			try {
				FormData data = new FormData(number,base1,base2,prec);
				convertTo.setText(Converter.convert(data));
			}catch(NumberSystemException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Invalid Input.", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
