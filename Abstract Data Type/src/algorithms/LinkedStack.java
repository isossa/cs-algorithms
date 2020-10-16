/**
 * An implementation of the Stack data structure using linked lists.
 * 
 * This stack provides no restriction on the number of elements it can hold.
 * Such restriction can easily be added.
 */
package algorithms;

import java.util.LinkedList;

/**
 * @author isossa
 */
public class LinkedStack
{
	private LinkedList<Object> head;
	
	public LinkedStack()
	{
		head = new LinkedList<Object>();
	}
	
	public void push(Object element)
	{
		head.addLast(element);
	}
	
	public Object pop()
	{
		return head.removeLast();
	}
}
