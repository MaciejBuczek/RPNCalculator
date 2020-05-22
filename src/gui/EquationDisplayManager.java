package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import onp.Equation;

public class EquationDisplayManager {
	
	private JLabel equationLabel;
	private Equation equation;
	
	public EquationDisplayManager(Equation equation) {
		this.equation=equation;
	}
	
	public void createEquationPanel(JFrame frame, Font font) {
		
		equationLabel  = new JLabel(equation.getInfix(), SwingConstants.RIGHT);
		JPanel equationPanel = new JPanel();
		equationPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		equationPanel.setLayout(new GridLayout(0,1));
		
		equationLabel.setFont(font);
		equationPanel.add(equationLabel);
		
		frame.add(equationPanel, BorderLayout.NORTH);
	}
	public Equation getEquation() {
		return equation;
	}
	public void reloadInfix() {
		equationLabel.setText(equation.getInfix());
	}
}
