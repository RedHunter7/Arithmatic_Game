package panel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class DigitBtnGridPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JButton[] digitBtn = new JButton[11];
	String[] digitBtnTxt = {
			"1", "2" , "3", "4", "5", "6",
			"7", "8", "9" , "Delete", "0"
	};
	
	public JButton submitBtn = new JButton("ENTER");
	
	public String digitValue;
	public JTextField textField;
	
	public DigitBtnGridPanel(JTextField inputField) {
		textField = inputField;
		digitValue = "";

		for (int i=0;i<digitBtn.length;i++) {
			String buttonText = digitBtnTxt[i];
			digitBtn[i] = new JButton(buttonText);
			
			// when user click digit number button
			ActionListener clickDigitBtn = new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if (digitValue.length() < 3) {
						digitValue = digitValue.concat(buttonText);
						textField.setText(digitValue);
					}
				}
			};
			
			// does not apply click listener on delete & enter button
			if (i != 9) {
				digitBtn[i].addActionListener(clickDigitBtn);
			}
			
			add(digitBtn[i]); 
		}
		
		ActionListener clickDeleteBtn = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				digitValue = "";
				textField.setText(digitValue);
			}  
		};
		
		// change Delete button background color
		digitBtn[9].setBackground(Color.pink);
		digitBtn[9].addActionListener(clickDeleteBtn);
		
		// change Enter button background color
		submitBtn.setBackground(Color.orange);
		add(submitBtn);
		
		// setting the grid layout using the parameterless constructor    
		setLayout(new GridLayout(4, 3));    
		     
		setVisible(true);    
	}
}
