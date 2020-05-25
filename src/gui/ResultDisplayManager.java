package gui;

import onp.Equation;

public class ResultDisplayManager extends DisplayManager{

	public ResultDisplayManager(Equation equation) {
		super(equation);
	}
	void refresh() {
		if(equation.isPostfixGenerated())
			label.setText(""+equation.getResult());			
		else
			label.setText("");
	}
}
