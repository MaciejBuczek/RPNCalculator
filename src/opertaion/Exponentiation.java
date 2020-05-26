package opertaion;

public class Exponentiation extends Operation2Arg{

	public Exponentiation(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public double getResult() {
		return Math.pow(oArg1.getResult(), oArg2.getResult());
	}
}
