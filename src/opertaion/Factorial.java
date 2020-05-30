package opertaion;

import java.util.stream.LongStream;

public class Factorial extends Operation1Arg{

	public Factorial(double arg1) {
		super(arg1);
		// TODO Auto-generated constructor stub
	}
	public Factorial(Operation oArg1) {
		super(oArg1);
	}
	
	public double getResult() throws ArithmeticException{
		int fac=(int)oArg1.getResult();
		if(fac < 0)
			throw new ArithmeticException("Factorial of negative number");
		if(fac==0)
			return 1;
		return (double) LongStream.rangeClosed(1, (long) fac).reduce(1, (long x, long y) -> x * y);
	}

}
