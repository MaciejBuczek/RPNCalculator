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
		if(equation.isPostfixGenerated())
			label.setText(equation.getPostfix());
		else
			label.setText("");
	}
	public Equation getEquation() {
		return equation;
	}
}
