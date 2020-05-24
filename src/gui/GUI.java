package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import onp.Equation;

public class GUI {
	private Font mainFont = new Font("Verdana", Font.PLAIN, 18);
	private Font equationFont = new Font("Verdana", Font.BOLD, 25);
	
	private ButtonManager buttonManager;
	private InfixDisplayManager infixDisplayManager;
	private PostfixDisplayManager postfixDisplayManager;
	
	
	public GUI(Equation equation){		

		JFrame frame = new JFrame();
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		displayPanel.setLayout(new GridLayout(2,0));
		
		infixDisplayManager = new InfixDisplayManager(equation);
		postfixDisplayManager = new PostfixDisplayManager(equation);
		
		buttonManager = new ButtonManager(this);
		
		infixDisplayManager.createEquationPanel(displayPanel, equationFont);
		postfixDisplayManager.createEquationPanel(displayPanel, equationFont);
		
		frame.add(displayPanel, BorderLayout.NORTH);
		
		buttonManager.createButtons(frame, mainFont);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RPN Calculator");
		frame.pack();
		frame.setVisible(true);
	}
	public Font getMainFont() {
		return mainFont;
	}
	public Font getEquationFont() {
		return equationFont;
	}
	public InfixDisplayManager getInfixDisplayManager() {
		return infixDisplayManager;
	}
	public PostfixDisplayManager getPostfixDisplayManager() {
		return postfixDisplayManager;
	}
}
