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
		
		String postfix = "";
		char symbol;
		boolean isDecimal = false;
		String temp = "";
		
		for(int i=0; i<infix.length(); i++) {
			symbol=infix.charAt(i);
			switch(symbol) {
			
				case '(':
					stack.push(symbol);
					break;
				case ')':
					if(isDecimal)
						postfixDivided.add(temp);
					else {
						for(int j=0; j<temp.length(); j++) {
							postfixDivided.add(""+temp.charAt(j));
						}
					}
					temp="";
					isDecimal=false;
					while(stack.peek() != '(') {
						postfix+=stack.peek();
						postfixDivided.add(stack.pop().toString());
					}
					stack.pop();
					break;
				case '!':
				case '^':
				case '\u221A':
				case '\u00D7':
				case '\u00F7':
				case '%':
				case '+':
				case '-':
					if(isDecimal)
						postfixDivided.add(temp);
					else {
						for(int j=0; j<temp.length(); j++) {
							postfixDivided.add(""+temp.charAt(j));
						}
					}
					temp="";
					isDecimal=false;
					if(stack.isEmpty() || getSymbolPriority(symbol)>getSymbolPriority(stack.peek())) {
						stack.push(symbol);
					}else {
						while(!stack.isEmpty() && getSymbolPriority(stack.peek())>=getSymbolPriority(symbol)) {
							postfix+=stack.peek();
							postfixDivided.add(stack.pop().toString());
						}
						stack.push(symbol);
					}
					break;
				default:
					if(symbol == '.')
						isDecimal = true;
					postfix+=symbol;
					temp+=symbol;
					break;
			}
		}
		if(isDecimal)
			postfixDivided.add(temp);
		else {
			for(int j=0; j<temp.length(); j++) {
				postfixDivided.add(""+temp.charAt(j));
			}
		}
		while(!stack.isEmpty()) {
			postfix+=stack.peek();
			postfixDivided.add(stack.pop().toString());
		}
		return postfix;
	}
	
	public List<String> getPostfixDivided() {
		return postfixDivided;
	}
}
