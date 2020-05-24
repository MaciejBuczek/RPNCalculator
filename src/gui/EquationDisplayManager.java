package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import onp.Equation;

public class EquationDisplayManager {
	
	protected JLabel equationLabel;
	protected Equation equation;
	
	public EquationDisplayManager(Equation equation) {
		this.equation=equation;
	}
	
	public void createEquationPanel(JPanel displayPanel, Font font) {
		
		equationLabel  = new JLabel(equation.getInfix(), SwingConstants.RIGHT);
		
		equationLabel.setFont(font);
		displayPanel.add(equationLabel);
		
	}
	public Equation getEquation() {
		return equation;
	}
}
