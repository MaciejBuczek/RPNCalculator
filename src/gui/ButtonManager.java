package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonManager implements ActionListener{
	//\u221A - root
	//\u00F7 - division
	//\u00D7 - multiplication
	private char[] buttonActions = {'!','(',')','<','%','\u221A','^','\u00F7','7','8','9','\u00D7',
			'4','5','6','-','1','2','3','+','C','0','.','='};
	private GUI gui;
	
	public ButtonManager(GUI gui) {
		this.gui=gui;
	}
	public void createButtons(JFrame frame, Font font) {
		int it=0;
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
		buttonPanel.setLayout(new GridLayout(6,4));
		
		JButton tempButton;
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				tempButton =new JButton(""+buttonActions[it]);
				tempButton.setFont(font);
				tempButton.setActionCommand(""+buttonActions[it]);
				tempButton.addActionListener(this);
				it++;
				buttonPanel.add(tempButton);
			}
		}
		frame.add(buttonPanel,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		char command = e.getActionCommand().charAt(0);
		switch(command) {
			case '<':
				gui.getEquation().removeFromEquation();
				break;
			case 'C':
				gui.getEquation().clearEquation();
				gui.getPostfixDisplay().refreshPostfix();
				gui.getResultDisplayManager().refresh();
				break;
			case '=':
				try {
					gui.getEquation().generatePostfix();
				}catch(Exception exception) {
					gui.displayError(exception.getMessage());
				}
				gui.getResultDisplayManager().refresh();
				gui.getPostfixDisplay().refreshPostfix();
				break;
			default:
				if(gui.getEquation().isPostfixGenerated()) {
					gui.getEquation().clearEquation();
				}
				gui.getEquation().addToEquation(command);
				break;
		}
		gui.getInfixDisplay().refreshInfix();
	}
}
