package opertaion;

public class Exponentiation extends Operation2Arg{

	public Exponentiation(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public double getResult() throws ArithmeticException{
		if(oArg1.getResult() == 0 && oArg2.getResult()==0)
			throw new ArithmeticException("Trying to calculate 0 to the power o 0");
		return Math.pow(oArg1.getResult(), oArg2.getResult());
	}
}
