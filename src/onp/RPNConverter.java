package onp;

import java.util.ArrayList;
import java.util.List;

public class RPNConverter {
	private Stack stack;
	private List<Operation> rpnEquation;
	
	public RPNConverter() {
		stack = new Stack();
		rpnEquation = new ArrayList<Operation>();
	}
	public List<Operation> generateRPNEquation(String Equation){
		rpnEquation.clear();
		stack.clear();
		return rpnEquation;
	}
	
}
