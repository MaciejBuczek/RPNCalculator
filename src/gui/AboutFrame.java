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
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutFrame implements ActionListener{
	private JFrame aboutFrame;
	
	private Font main = new Font("Verdana", Font.PLAIN, 15);
	
	public AboutFrame() {
		
		JPanel displayPanel;
		JButton okButton;
		JTextArea  textArea;
		
		aboutFrame = new JFrame();
		
		displayPanel = new JPanel();
		
		displayPanel.setBorder(BorderFactory.createEmptyBorder(10,30,0,30));
		displayPanel.setLayout(new GridLayout(1,0));
		
		textArea = new JTextArea();

		textArea.setText("This software will convert any equation to RPN(Reverse Polish Notation) and calculate result. \n"
				+ "\nDecimal numbers are supported\n"
				+ "\nNegative numbers must be placed in separate brackets eg. -2 -> (-2)\n"
				+ "\nThe nth root of a given value is n\u221Aa eg. 2\u221A4=2 \n"
				+ "\nb raised to the n-th power is b^n eg. 2^3=8\n"
				+ "\nOperation history is saved in file: History.xml\n"
				+ "\nCreated by Maciej Buczek");
		textArea.setFont(main);
		textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setOpaque(false);
	    textArea.setEditable(false);
	    textArea.setFocusable(false);

		displayPanel.add(textArea);
		
		okButton = new JButton("Close");
		okButton.setFont(main);
		okButton.addActionListener(this);
		
		aboutFrame.add(displayPanel, BorderLayout.NORTH);
		aboutFrame.add(okButton, BorderLayout.SOUTH);
		aboutFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		aboutFrame.setTitle("About");
		
		aboutFrame.setSize(new Dimension(400,500));
		aboutFrame.setMinimumSize(new Dimension(400, 500));
		
		aboutFrame.setVisible(false);
	}
	public void displayAbout(Component relativeTo) {
		
		aboutFrame.setLocationRelativeTo(relativeTo);
		aboutFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		aboutFrame.setVisible(false);
	}
}
