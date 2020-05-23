package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonManager implements ActionListener{
	
	private char[] buttonActions = {'!','(',')','<','%','s','^','/','7','8','9','X',
			'4','5','6','-','1','2','3','+','C','0',',','='};
	private EquationDisplayManager equationDisplayManager;
	public ButtonManager(EquationDisplayManager equationDisplayManager) {
		this.equationDisplayManager = equationDisplayManager;
	}
	public void createButtons(JFrame frame, Font font) {
		int it=0;
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
		buttonPanel.setLayout(new GridLayout(6,4));
		
		List<JButton> buttons = new ArrayList<JButton>();
		JButton tempButton;
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				tempButton =new JButton(""+buttonActions[it]);
				tempButton.setFont(font);
				tempButton.setActionCommand(""+buttonActions[it]);
				tempButton.addActionListener(this);
				it++;
				buttonPanel.add(tempButton);
				buttons.add(tempButton);
			}
		}
		frame.add(buttonPanel,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		char command = e.getActionCommand().charAt(0);
		switch(command) {
			case '<':
				equationDisplayManager.getEquation().removeFromEquation();
				break;
			case 'C':
				equationDisplayManager.getEquation().clearEquation();
				break;
			case '=':
				equationDisplayManager.getEquation().generatePrefix();
				break;
			default:
				equationDisplayManager.getEquation().addToEquation(command);
				break;
		}
		equationDisplayManager.reloadInfix();
	}
}
