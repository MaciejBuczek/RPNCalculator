package gui;

import java.awt.Font;

import javax.swing.JFrame;

import onp.Equation;

public class GUI {
	private Font mainFont = new Font("Verdana", Font.PLAIN, 18);
	private Font equationFont = new Font("Verdana", Font.BOLD, 25);
	
	private ButtonManager buttonManager;
	private EquationDisplayManager equationDisplayManager;
	
	
	public GUI(Equation equation){		

		JFrame frame = new JFrame();
		
		equationDisplayManager = new EquationDisplayManager(equation);
		buttonManager = new ButtonManager(equationDisplayManager);
		
		equationDisplayManager.createEquationPanel(frame, equationFont);
		buttonManager.createButtons(frame, mainFont);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RPN Calculator");
		frame.pack();
		frame.setVisible(true);
	}
	public void refreshEquation() {
		equationDisplayManager.reloadInfix();
	}
	public Font getMainFont() {
		return mainFont;
	}
	public Font getEquationFont() {
		return equationFont;
	}
}
