package onp;

public class Equation {
	private String infix;
	private String prefix;
	
	public Equation() {
		this.infix="";
	}
	public void addToEquation(char symbol) {
		infix+=symbol;
	}
	public void removeFromEquation() throws ArrayIndexOutOfBoundsException{
		if(infix.isEmpty())
			throw new ArrayIndexOutOfBoundsException("removing elements from empty equation");
		if(infix.length()==1)
			infix = "";
		infix=infix.substring(0, infix.length()-2);
	}
	public String getInfix() {
		if(infix.isEmpty())
			return "0";
		else
			return infix;
	}
	public String getPrefix() {
		return prefix;
	}
	
}
