package opertaion;

public class Modulo extends Operation2Arg{

	public Modulo(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	public double getResult() throws ArithmeticException{
		if(oArg2.getResult()==0)
			throw new ArithmeticException("Trying to divide by zero");
		return oArg1.getResult()%oArg2.getResult();
	}
}
