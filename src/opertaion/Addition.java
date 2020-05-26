package opertaion;

public class Addition extends Operation2Arg{

	public Addition(Operation arg1, Operation arg2) {
		super(arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public double getResult() {
		return oArg1.getResult()+oArg2.getResult();
	}
}
