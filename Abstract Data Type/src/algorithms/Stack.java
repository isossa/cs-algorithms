package algorithms;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * An array-backed implementation of a Stack.
 * 
 * @author isossa
 *
 */
public class Stack
{
	private Object[] elements;
	private final int INITIAL_CAPACITY = 16;
	private int size = 0;
	
	public Stack()
	{
		elements = new Object[INITIAL_CAPACITY];
	}
	
	/**
	 * Add an element in the stack.
	 * 
	 * @param element Last added element in the stack.
	 */
	public void push(Object element)
	{
		ensureCapacity();
		elements[size++] = element;
	}
	
	
	/**
	 * Return last inserted elements in the stack.
	 * 
	 * @return top element of the stack.
	 */
	public Object pop()
	{
		if (size == 0)
			throw new EmptyStackException();
		
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the underlining array needs to grow.
	 */
	private void ensureCapacity()
	{
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}
