package onp;

import java.util.ArrayList;
import java.util.List;

public class Operation {
	
	private List<Double> args = new ArrayList<Double>();
	private char symbol = 'x';
	
	public Operation(double ...args) {
		for(double arg: args) {
			this.args.add(arg);
		}
	}
	public double getResult() {
		return 0;
	}
	public String toString() {
		String temp = "";
		temp+=symbol;
		for(double arg: args) {
			temp+=arg;
		}
		return temp;
	}
}
