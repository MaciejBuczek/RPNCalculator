package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDisplayManager implements ActionListener{
	
	private JFrame errorFrame;
	private JLabel errorTextLabel;
	
	private Font errorTitleFont = new Font("Verdana", Font.BOLD, 25);
	private Font errorTextFont = new Font("Verdana", Font.PLAIN, 20);
	
	public ErrorDisplayManager() {
		
		JPanel displayPanel;
		JButton okButton;
		
		errorFrame = new JFrame();
		
		displayPanel = new JPanel();
		
		displayPanel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
		displayPanel.setLayout(new GridLayout(2,0));
		
		JLabel errorTitle;
		errorTitle = new JLabel("An error has occured");
		errorTitle.setFont(errorTitleFont);
		errorTextLabel = new JLabel("error text");
		errorTextLabel.setFont(errorTextFont);
		
		displayPanel.add(errorTitle);
		displayPanel.add(errorTextLabel);
		
		okButton = new JButton("Ok");
		okButton.setFont(errorTextFont);
		okButton.addActionListener(this);
		
		errorFrame.add(displayPanel, BorderLayout.NORTH);
		errorFrame.add(okButton, BorderLayout.SOUTH);
		errorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		errorFrame.setTitle("RPN Calculator ERROR");
		
		errorFrame.setSize(new Dimension(400,180));
		
		errorFrame.setVisible(false);
	}
	public void displayError(String text, Component relativeTo) {
		
		errorTextLabel.setText(text);
		errorFrame.setLocationRelativeTo(relativeTo);
		errorFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		errorFrame.setVisible(false);
	}
}
