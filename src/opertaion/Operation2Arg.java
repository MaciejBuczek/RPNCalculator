package opertaion;

public class Operation2Arg extends Operation1Arg{

	protected double arg2;
	protected Operation oArg2;
	
	public Operation2Arg(Operation oArg1, Operation oArg2) {
		super(0);
		this.oArg1=oArg1;
		this.oArg2=oArg2;
	}
	
	public double getResult() {
		
		return arg2;
	}
	
	public void setArg2(double arg2) {
		this.arg2=arg2;
	}
}
