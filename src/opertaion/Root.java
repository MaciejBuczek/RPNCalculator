package opertaion;

public class Root extends Operation2Arg{

	public Root(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	public double getResult() {
		return Math.pow(oArg1.getResult(), 1/oArg2.getResult());
	}
}
