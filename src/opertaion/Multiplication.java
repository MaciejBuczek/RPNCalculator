package opertaion;

public class Multiplication extends Operation2Arg{

	public Multiplication(Operation arg1, Operation arg2) {
		super(arg1, arg2);
	}

	public double getResult() {
		return oArg1.getResult()*oArg2.getResult();
	}
}
