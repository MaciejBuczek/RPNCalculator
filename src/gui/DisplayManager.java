package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import onp.Equation;

public class DisplayManager {
	
	protected JLabel label;
	protected Equation equation;
	
	public DisplayManager(Equation equation) {
		this.equation=equation;
	}
	
	public void createPanel(JPanel displayPanel, Font font) {
		
		label  = new JLabel("", SwingConstants.RIGHT);
		
		label.setFont(font);
		displayPanel.add(label);
		
	}
}