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
	public char pop() throws ArrayIndexOutOfBoundsException {
		if(stack.isEmpty())
			throw new ArrayIndexOutOfBoundsException("Removing value from empty stack");
		return stack.poll();
	}
}
