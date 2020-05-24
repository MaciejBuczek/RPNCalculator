package onp;

enum SymbolType{
	None,
	Operation1arg,
	Operation2arg,
	Number,
	Zero,
	Coma,
	BracketOpend,
	BracketClosed,
}

public class Equation {
	
	private InfixToPostfixConverter converter;
	
	private String infix;
	private String postfix;
	
	private SymbolType previousSymbol;
	private int opendBrackets;
	private int closedBrackets;
	
	public Equation() {
		
		converter = new InfixToPostfixConverter();
		
		this.infix="";
		this.previousSymbol=SymbolType.None;
		this.opendBrackets=0;
		this.closedBrackets=0;
	}
	public void addToEquation(char symbol) {
		boolean isComaSet = false;
		boolean canAddZero = true;
		boolean isFirstDigit = false; 	
		switch(symbol) {
			case '0':
				if(canAddZero) {
					infix+=symbol;
					previousSymbol=SymbolType.Zero;
					if(isFirstDigit)
						canAddZero=false;
				}
				break;
			case ',':
				if((previousSymbol==SymbolType.Number || previousSymbol==SymbolType.Zero) && !isComaSet) {
					infix+=symbol;
					isComaSet=true;
					canAddZero=true;
					isFirstDigit=false;
					previousSymbol=SymbolType.Coma;
				}
				break;
			case '(':
				if(previousSymbol==SymbolType.Operation1arg || previousSymbol==SymbolType.Operation2arg || previousSymbol==SymbolType.None) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=true;
					previousSymbol=SymbolType.BracketOpend;
					opendBrackets++;
				}
				break;
			case ')':
				if(previousSymbol==SymbolType.Number || previousSymbol==SymbolType.Zero) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=false;
					previousSymbol=SymbolType.BracketClosed;
					closedBrackets++;
				}
				break;
			case '!':
			case 's':
				if(previousSymbol==SymbolType.None || previousSymbol==SymbolType.BracketOpend || previousSymbol==SymbolType.Operation2arg) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=true;
					previousSymbol=SymbolType.Operation1arg;
				}
				break;
			case '+':
			case '*':
			case '/':
			case 'X':
			case '%':
			case '^':
				if(previousSymbol == SymbolType.Number || previousSymbol==SymbolType.Zero || previousSymbol==SymbolType.BracketClosed || previousSymbol==SymbolType.Operation1arg ) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=true;
					isFirstDigit=true;
					previousSymbol=SymbolType.Operation2arg;
				}
				break;
			case '-':
				if(previousSymbol != SymbolType.None && previousSymbol != SymbolType.Coma && previousSymbol != SymbolType.Operation2arg) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=true;
					isFirstDigit=true;
					previousSymbol=SymbolType.Operation2arg;
				}
				break;
			default:
				if(previousSymbol != SymbolType.BracketClosed) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=false;
					previousSymbol=SymbolType.Number;
				}
				break;
			
		}
	}
	public void removeFromEquation() throws ArrayIndexOutOfBoundsException{
		if(infix.isEmpty())
			throw new ArrayIndexOutOfBoundsException("removing elements from empty equation");
		infix=infix.substring(0, infix.length()-1);
	}
	public void clearEquation() {
		infix="";
	}
	public void generatePostfix() throws IllegalArgumentException {
		if(closedBrackets != opendBrackets)
			throw new IllegalArgumentException("Not all brackets are closed");
		
		postfix = converter.convertInfixToPostfix(infix);
	}
	public String getInfix() {
		if(infix.isEmpty())
			return "0";
		else
			return infix;
	}
	public String getPostfix() {
		if(infix.isEmpty())
			return "0";
		else
			return postfix;
	}
	
}
