package gui;

import onp.Equation;

public class EquationDisplayManager extends DisplayManager{
	
	
	public EquationDisplayManager(Equation equation) {
		super(equation);
	}
	public void refreshInfix() {
		label.setText(equation.getInfix());
	}
	public void refreshPostfix() {
		label.setText(equation.getPostfix());
	}
	public Equation getEquation() {
		return equation;
	}
}
