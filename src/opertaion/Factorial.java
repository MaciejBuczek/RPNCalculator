package opertaion;

public class Factorial extends Operation1Arg{

	public Factorial(double arg1) {
		super(arg1);
		// TODO Auto-generated constructor stub
	}
	public Factorial(Operation oArg1) {
		super(oArg1);
	}
	
	public double getResult() throws IllegalArgumentException{
		int fac=(int)oArg1.getResult();
		if(fac < 0)
			throw new IllegalArgumentException("Factorial of negative number");
		if(fac == 0)
			return 1;
		else {
			int result=1;
			for(int i=1; i <= (int)fac; i++) {
				result*=i;
			}
			return result;
		}
	}

}
