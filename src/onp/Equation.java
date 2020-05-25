package onp;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<SymbolType> symbolTypes;
	private int opendBrackets;
	private int closedBrackets;
	
	private boolean isComaSet = false;
	private boolean canAddZero = true;
	private boolean isFirstDigit = false; 
	
	public Equation() {
		
		converter = new InfixToPostfixConverter();
		symbolTypes = new ArrayList<SymbolType>();
		
		this.infix="";
		symbolTypes.add(SymbolType.None);
		this.opendBrackets=0;
		this.closedBrackets=0;
	}
	public void addToEquation(char symbol) {
		SymbolType previousSymbol = symbolTypes.get(symbolTypes.size()-1);	
		switch(symbol) {
			case '0':
				if(canAddZero) {
					infix+=symbol;
					symbolTypes.add(SymbolType.Zero);
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
					symbolTypes.add(SymbolType.Coma);
				}
				break;
			case '(':
				if(previousSymbol==SymbolType.Operation1arg || previousSymbol==SymbolType.Operation2arg || previousSymbol==SymbolType.None) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=true;
					symbolTypes.add(SymbolType.BracketOpend);
					opendBrackets++;
				}
				break;
			case ')':
				if(previousSymbol==SymbolType.Number || previousSymbol==SymbolType.Zero) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=false;
					symbolTypes.add(SymbolType.BracketClosed);
					closedBrackets++;
				}
				break;
			case '!':
				if(previousSymbol==SymbolType.Number || previousSymbol==SymbolType.BracketClosed) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=true;
					symbolTypes.add(SymbolType.Operation1arg);
				}
				break;
			case '+':
			case '*':
			case '\u00F7':
			case '\u00D7':
			case '\u221A':
			case '%':
			case '^':
				if(previousSymbol == SymbolType.Number || previousSymbol==SymbolType.Zero || previousSymbol==SymbolType.BracketClosed || previousSymbol==SymbolType.Operation1arg ) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=true;
					isFirstDigit=true;
					symbolTypes.add(SymbolType.Operation2arg);
				}
				break;
			case '-':
				if(previousSymbol != SymbolType.None && previousSymbol != SymbolType.Coma && previousSymbol != SymbolType.Operation2arg) {
					infix+=symbol;
					isComaSet=false;
					canAddZero=true;
					isFirstDigit=true;
					symbolTypes.add(SymbolType.Operation2arg);
				}
				break;
			default:
				if(previousSymbol != SymbolType.BracketClosed) {
					infix+=symbol;
					canAddZero=true;
					isFirstDigit=false;
					symbolTypes.add(SymbolType.Number);
				}
				break;
			
		}
	}
	public void removeFromEquation() throws ArrayIndexOutOfBoundsException{
		if(infix.isEmpty())
			throw new ArrayIndexOutOfBoundsException("removing elements from empty equation");
		infix=infix.substring(0, infix.length()-1);
		symbolTypes.remove(symbolTypes.size()-1);
	}
	public void clearEquation() {
		symbolTypes.clear();
		symbolTypes.add(SymbolType.None);
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
