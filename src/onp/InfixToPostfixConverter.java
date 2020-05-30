package onp;

import java.util.ArrayList;
import java.util.List;

public class InfixToPostfixConverter {
	
	private Stack<Character> stack;
	List<String> postfixDivided;
	
	public InfixToPostfixConverter() {
		
		this.stack=new Stack<Character>();
		postfixDivided=new ArrayList<String>();
	}
	
	public int getSymbolPriority(char symbol) {
		
		switch(symbol) {
			case '!':
			case '^':
			case '\u221A':
				return 3;
			case '\u00D7':
			case '\u00F7':
			case '%':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return 0;
		}
	}
	
	public String convertInfixToPostfix(String infix) {
		
		postfixDivided.clear();
		String postfix = "";
		char symbol;
		String temp = "";
		boolean isNegative=false;
		
		for(int i=0; i<infix.length(); i++) {
			symbol=infix.charAt(i);
			switch(symbol) {
			
				case '(':
					if(infix.charAt(i+1)=='-') {
						isNegative=true;
						temp+='-';
					}
					else
						stack.push(symbol);
					break;
				case ')':
					if(temp!="") {
						postfixDivided.add(temp);
						temp="";
					}
					if(!stack.isEmpty() && !isNegative) {
						while(stack.peek() != '(') {
							postfixDivided.add(stack.pop().toString());
						}
						stack.pop();
					}
					isNegative=false;
					break;
				case '!':
				case '^':
				case '\u221A':
				case '\u00D7':
				case '\u00F7':
				case '%':
				case '+':
				case '-':
					if(!isNegative) {
						if(temp!="") {
							postfixDivided.add(temp);
							temp="";
						}
						if(stack.isEmpty() || getSymbolPriority(symbol)>getSymbolPriority(stack.peek())) {
							stack.push(symbol);
						}else {
							while(!stack.isEmpty() && getSymbolPriority(stack.peek())>=getSymbolPriority(symbol)) {
								postfixDivided.add(stack.pop().toString());
							}
							stack.push(symbol);
						}
					}
					break;
				default:
					temp+=symbol;
					break;
			}
		}
		if(temp!="")
			postfixDivided.add(temp);
		while(!stack.isEmpty()) {
			postfixDivided.add(stack.pop().toString());
		}
		for(String arg : postfixDivided) {
			postfix += arg;
		}
		return postfix;
	}
	
	public List<String> getPostfixDivided() {
		return postfixDivided;
	}
}
