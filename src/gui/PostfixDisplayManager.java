package gui;

import onp.Equation;

public class PostfixDisplayManager extends EquationDisplayManager {
	
	public PostfixDisplayManager(Equation equation) {
		super(equation);
	}

	public void reloadPostfix() {
		equationLabel.setText(equation.getPostfix());
	}
}
