package onp;

import java.util.LinkedList;

public class Stack {
	private LinkedList<Character> stack;
	public Stack() {
		stack = new LinkedList<Character>();
	}
	public void push(char input) {
		stack.addFirst(input);
	}
	public void clear() {
		stack.clear();
	}
	public char pop() throws ArrayIndexOutOfBoundsException {
		if(stack.isEmpty())
			throw new ArrayIndexOutOfBoundsException("Removing value from empty stack");
		return stack.poll();
	}
	public char peek() {
		return stack.peek();
	}
	public boolean isEmpty() {
		
		if(stack.size()>0)
			return false;
		else
			return true;
	}
}
