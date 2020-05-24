package onp;

public class InfixToPostfixConverter {
	
	private Stack stack;
	
	public InfixToPostfixConverter() {
		
		this.stack=new Stack();
	}
	
	public int getSymbolPriority(char symbol) {
		
		switch(symbol) {
			case '!':
			case '^':
			case 's':
				return 3;
			case 'X':
			case '/':
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
		
		String postfix="";
		char symbol;
		
		for(int i=0; i<infix.length(); i++) {
			symbol=infix.charAt(i);
			switch(symbol) {
			
				case '(':
					stack.push(symbol);
					break;
				case ')':
					while(stack.peek() != '(') {
						postfix+=stack.pop();
					}
					stack.pop();
					break;
				case '!':
				case '^':
				case 's':
				case 'X':
				case '/':
				case '%':
				case '+':
				case '-':
					if(stack.isEmpty() || getSymbolPriority(symbol)>getSymbolPriority(stack.peek())) {
						stack.push(symbol);
					}else {
						while(!stack.isEmpty() && getSymbolPriority(stack.peek())>=getSymbolPriority(symbol)) {
							postfix+=stack.pop();
						}
						stack.push(symbol);
					}
					break;
				default:
					postfix+=symbol;
					break;
			}
		}
		while(!stack.isEmpty()) {
			postfix+=stack.pop();
		}
		return postfix;
	}
}
