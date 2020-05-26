package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private EquationDisplayManager infixDisplay, postfixDisplay;
	private ResultDisplayManager resultDisplay;
	
	private Equation equation;
	
	public GUI(Equation equation){		
		
		this.equation=equation;
		
		JFrame frame = new JFrame();
		JPanel displayPanel = new JPanel();
		displayPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		displayPanel.setLayout(new GridLayout(3,0));
		
		infixDisplay = new EquationDisplayManager(equation);
		postfixDisplay = new EquationDisplayManager(equation);
		resultDisplay = new ResultDisplayManager(equation);
		
		buttonManager = new ButtonManager(this);
		
		infixDisplay.createPanel(displayPanel, equationFont);
		postfixDisplay.createPanel(displayPanel, equationFont);
		resultDisplay.createPanel(displayPanel, equationFont);
		infixDisplay.refreshInfix();
		resultDisplay.refresh();
		
		frame.add(displayPanel, BorderLayout.NORTH);
		
		buttonManager.createButtons(frame, mainFont);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RPN Calculator");
		
		frame.setSize(new Dimension(350, 450));
		frame.setMinimumSize(new Dimension(300, 400));
		
		frame.setVisible(true);
	}
	public Font getMainFont() {
		return mainFont;
	}
	public Font getEquationFont() {
		return equationFont;
	}
	public EquationDisplayManager getInfixDisplay() {
		return infixDisplay;
	}
	public EquationDisplayManager getPostfixDisplay() {
		return postfixDisplay;
	}
	public ResultDisplayManager getResultDisplayManager() {
		return resultDisplay;
	}
	public Equation getEquation() {
		return equation;
	}
}
