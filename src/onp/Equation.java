package onp;

import java.util.Arrays;

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
	private String infix;
	private String prefix;
	private SymbolType previousSymbol;
	private int opendBrackets;
	private int closedBrackets;
	private boolean isComaSet;
	private boolean canAddZero;
	private boolean isFirstDigit; 	
	public Equation() {
		this.infix="";
		this.previousSymbol=SymbolType.None;
		this.opendBrackets=0;
		this.closedBrackets=0;
		this.isComaSet=false;
		this.isFirstDigit=false;
		
		this.canAddZero=true;
	}
	public void addToEquation(char symbol) {
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
	public void generatePrefix() throws IllegalArgumentException {
		if(closedBrackets != opendBrackets)
			throw new IllegalArgumentException("Not all brackets are closed");
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
