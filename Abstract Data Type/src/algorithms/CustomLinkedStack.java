package algorithms;

import java.util.EmptyStackException;

/**
 * Generic implementation of the Stack data structure using a doubly-linked
 * list.
 * 
 * @author isossa
 *
 * @param <T> Type parameter.
 */
public class CustomLinkedStack<T>
{	
	private Node<T> head = null;
	
	public CustomLinkedStack()
	{ /*	Floor is ready for stack.	*/	}
	
	/**
	 * Add this value onto the stack.
	 * 
	 * @param value Value to add.
	 */
	public void push(T element)
	{
		if (isEmpty())
		{
			head = new Node<T>(element, null, null);
		}
		else
		{
			Node<T> node = new Node<T>(element, head, null);
			head.next = node;
			head = node;
		}
	}
	
	/**
	 * Return the top element of the stack without removing it.
	 * 
	 * @return top element of the stack.
	 */
	public Object peek()
	{
		if (isEmpty())
			throw new EmptyStackException();
		
		return head.data;
	}
	
	/**
	 * Remove the top element of the stack.
	 * 
	 * @return top element of the stack.
	 */
	public Object pop()
	{
		if (isEmpty())
			throw new EmptyStackException();
		
		Node<T> node = head;
		
		if (head.previous == null)
		{
			head = null;
		}
		else
		{
			head = head.previous;
			head.next = node.next;
		}
		return node.data;
	}
	
	/**
	 * Check if the stack is empty.
	 * 
	 * @return True if the stack is empty otherwise false.
	 */
	private boolean isEmpty() 
	{
		return head == null;
	}
	
	private class Node<E>
	{
		public E data;
		private Node<E> next;
		private Node<E> previous;
		
		private Node(E data, Node<E> previous, Node<E> next)
		{
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}
}


