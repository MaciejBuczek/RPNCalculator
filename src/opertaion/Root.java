package opertaion;

public class Root extends Operation2Arg{

	public Root(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	public double getResult() throws ArithmeticException{
		if(oArg1.getResult()%2 == 0 && oArg2.getResult() < 0)
			throw new ArithmeticException("Trying to calculate even root of a negative number");
		return Math.pow(oArg2.getResult(), 1/oArg1.getResult());
	}
}
