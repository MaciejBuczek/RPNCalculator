package gui;

import onp.Equation;

public class InfixDisplayManager extends EquationDisplayManager {
	
	public InfixDisplayManager(Equation equation) {
		super(equation);
	}

	public void reloadInfix() {
		equationLabel.setText(equation.getInfix());
	}
}
