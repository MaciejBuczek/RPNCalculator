package opertaion;

public class Operation1Arg extends Operation {
	
	protected double arg1;
	protected Operation oArg1;
	
	public Operation1Arg(double arg1) {
		this.arg1=arg1;
	}
	public Operation1Arg(Operation oArg1) {
		this.oArg1=oArg1;
	}
	
	public double getResult() {
		if(oArg1==null)
			return arg1;
		else
			return oArg1.getResult();
	}
	
	public void setArg(double arg1) {
		this.arg1=arg1;
	}
}
