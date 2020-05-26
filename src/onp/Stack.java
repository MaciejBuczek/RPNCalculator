package onp;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> stack;
	public Stack() {
		stack = new LinkedList<T>();
	}
	public void push(T input) {
		stack.addFirst(input);
	}
	public void clear() {
		stack.clear();
	}
	public T pop() throws ArrayIndexOutOfBoundsException {
		if(stack.isEmpty())
			throw new ArrayIndexOutOfBoundsException("Removing value from empty stack");
		return stack.poll();
	}
	public T peek() {
		return stack.peek();
	}
	public boolean isEmpty() {
		
		if(stack.size()>0)
			return false;
		else
			return true;
	}
}
