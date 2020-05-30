package opertaion;

import java.util.List;

import onp.Stack;

public class PostfixCalculator {
	
	private Stack<Operation> operationStack;
	
	public PostfixCalculator() {
		this.operationStack = new Stack<Operation>();
	}
	
	public double calculate(List<String> postfix) {
		Operation arg1 = new Operation1Arg(0);
		Operation arg2 = new Operation1Arg(0);
		boolean isArg1Set = false, isArg2Set = false;
		
		for(String symbol : postfix) {
			switch(symbol.charAt(0)) {
			case '!':
				arg1=new Factorial(arg1);
				break;
			case '+':
				if(isArg2Set) {
					arg1=new Addition(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Addition(operationStack.pop(), arg1);
				}
				break;
			case '\u00F7':
				if(isArg2Set) {
					arg1=new Division(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Division(operationStack.pop(), arg1);
				}
				break;
			case '\u00D7':
				if(isArg2Set) {
					arg1=new Multiplication(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Multiplication(operationStack.pop(), arg1);
				}
				break;
			case '\u221A':
				if(isArg2Set) {
					arg1=new Root(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Root(operationStack.pop(), arg1);
				}
				break;
			case '%':
				if(isArg2Set) {
					arg1=new Modulo(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Modulo(operationStack.pop(), arg1);
				}
				break;
			case '^':
				if(isArg2Set) {
					arg1=new Exponentiation(arg1, arg2);
					isArg2Set=false;
				}else {
					arg1=new Exponentiation(operationStack.pop(), arg1);
				}
				break;
			case '-':
				if(symbol.length()==1) {
					if(isArg2Set) {
						arg1=new Subtraction(arg1, arg2);
						isArg2Set=false;
					}else {
						arg1=new Subtraction(operationStack.pop(), arg1);
					}
					break;
				}
			default:
				if(!isArg1Set) {
					arg1 = new Operation1Arg(Double.parseDouble(symbol));
					isArg1Set=true;
				}
				else if(!isArg2Set) {
					arg2 = new Operation1Arg(Double.parseDouble(symbol));
					isArg2Set=true;
				}
				else {
					operationStack.push(arg1);
					arg1=arg2;
					arg2=new Operation1Arg(Double.parseDouble(symbol));
				}
				break;
			}
		}
		return arg1.getResult();
	}
}
